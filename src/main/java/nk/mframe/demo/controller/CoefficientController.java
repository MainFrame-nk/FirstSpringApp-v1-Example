package nk.mframe.demo.controller;

import nk.mframe.demo.dao.*;
import nk.mframe.demo.model.*;
import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CoefficientController {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CoefficientRepository coefficientRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/import/coefs")
    public String coefMain(Model model) {
        return "import-index";
    }

    @PostMapping("/import/coefs")
    public String coefImport(@RequestParam String day_matches, Model model) throws IOException, InterruptedException {
        //ArrayList<String> todayMatches = FindMatches(day_matches); // Найти все доступные матчи на день
        Scrapper(day_matches);
        //ArrayList<Integer> matchesId = FindIdMatches(day_matches); // Найти все id на матчи на день
        //FindCoefficients(matchesId);
        System.out.println("Импорт успешно завершён! :)");
        return "redirect:/import/coefs";
    }

    public StringBuilder ConnectSite(String url, String findData) throws IOException {
        // url - ссылка сайта, с которого забирать данные
        // findData - текст, полученный с сайта, от которого обрезать искомые данные
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        // искусственный агент для входа на сайт
        connection.addRequestProperty("User-Agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");

        connection.setRequestMethod("GET");
        int statusCode = connection.getResponseCode();
        StringBuilder response = new StringBuilder("");
        if (statusCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } else {
            System.out.println("Ошибка при подключении к серверу сайта!");
            return new StringBuilder();
        }
        if (response.toString().equals("[]")) {
            return new StringBuilder();
        }
        return new StringBuilder(response.substring(response.indexOf(findData)));
    }

    public ArrayList<String> FindMatches(String dayMathes) throws IOException {
        StringBuilder response = ConnectSite("https://odds.ru/football/match/" + dayMathes + "/", "ListMatchesFootballStore"); //Взять данные с сайта

        String start = "/match";
        String end = "\\\",\\\"status";
        String forecasts = "/forecasts";
        ArrayList<String> findData = new ArrayList<>();
        String[] str = response.toString().split("/football");
        for (String mt : str) {
            //Поиск всех ссылок на матчи
            if (mt.contains(start) && !mt.contains(forecasts)) {
                if (mt.contains(end)) {
                    findData.add(mt.substring(mt.indexOf(start), mt.indexOf(end, -5)));
                }
            }
        }
        int n = 1;
        while (n != findData.size() + 1) {
            findData.set(n, findData.get(n - 1).replace("\\\\\\", ""));
            n++;
        }
        return findData;
    }

    public void Scrapper(String dayMathes) throws IOException {
        StringBuilder response = ConnectSite("https://odds.ru/football/match/" + dayMathes + "/","ListMatchesFootball\"");
        String start = "ournament";
        String end = "</a>";
        String startTeam = "bt92PPZyA3Px";
        String endTeam = "</b><img";
        String[] str = response.toString().split("/football/t");
        for (String mt : str) {
            //Поиск всех ссылок на матчи
            if (mt.contains(start)) {
                if (mt.contains(end) && !mt.contains("Таблица")) {
                    String res = mt.substring(mt.indexOf(start), mt.indexOf(end));
                    String star = "\">";
                    res = res.substring(res.indexOf(star) + 2);
                    String[] str2 = res.split("\\. ");

                    countryAdd(str2[0]);

                    leagueAdd(str2[1], str2[0]);

                    String[] str4 = mt.split("HOzoqLwPT5hh");
                    String[] str5 = mt.split("TsO2oIVMd9kb");
                    String[] str3 = mt.split("bt92PPZyA3Px");
                    for (String tm : str3) {
                        if (tm.contains("5pX82PH4")) {
                            String resHome = tm.substring(10, tm.indexOf(endTeam));
                            System.out.println(resHome);
                            teamAdd(resHome, str2[1], str2[0]);
                            String resAway = tm.substring(10, tm.indexOf(endTeam));
                            System.out.println(resAway);
                            teamAdd(resHome, str2[1], str2[0]);
                        }
                    }
                    for (String date : str4) {
                        if (date.contains("EmBZhm2v")) {

                        }
                    }
                    for (String time : str4) {
                        if (time.contains("ad7gJlGW ")) {

                        }
                    }
                }
            }
        }
    }

    public ArrayList<Integer> FindIdMatches(String dayMathes) throws IOException {
        StringBuilder response = ConnectSite("https://odds.ru/football/match/" + dayMathes + "/", "ListMatchesFootballStore"); //Взять данные с сайта

        String events = "events";
        String forecasts = "/forecasts";
        ArrayList<String> idMatches = new ArrayList<>();
        String str2 = ",\\\"url";
        String[] str = response.toString().split("/football");
        for (String mt : str) {
            //Поиск id матча
            if (mt.contains(events)) {
                if (mt.contains(str2)) {
                    idMatches.add(mt.substring(mt.indexOf(events) + 6, mt.indexOf(str2, -5)));
                }
            } else if (mt.contains(forecasts)) {
                if (mt.contains(str2)) {
                    idMatches.add(mt.substring(mt.indexOf(forecasts) + 26, mt.indexOf(str2, -5)));
                }
            }
        }
        int n = 1;
        ArrayList<Integer> matchesId = new ArrayList<>();
        while (n != idMatches.size() + 1) {
            matchesId.add(Integer.valueOf(idMatches.get(n - 1).replace("\\\":[{\\\"id\\\":", "")));
            n++;
        }
        return matchesId;
    }

    public void FindCoefficients(StringBuilder response, Integer marketId, Long eventId) throws InterruptedException {
        String[] str = response.toString().split("outcome_value");
        int bookmaker = 0;
        double coefficient_more = 0.0;
        double coefficient_less = 0.0;
        double outcome_value = 0.0;
        for (String stat : str) {
            if (stat != null && stat.contains("rows")) { //fraectoris
                String[] str2 = stat.split("sfp_id");
                outcome_value = FindValue(str2[0], "\",\"rows");
                for (String st : str2) {
                    bookmaker = FindValue(st, ",\"odds", true);
                    //if (bookmaker != 1 && bookmaker != 17) {
                    if (bookmaker == 0) {
                        continue;
                    }
                    // outcome_value:
                    // 1- 1х2 - 1 победа
                    // 2- 1х2 - ничья
                    // 3- 1х2 - 2 победа
                    // 4,5,6 - Двойной шанс
                    // 7- Фора - Ф1 победа
                    // 8- Фора - Ф2 победа
                    // 9- Тотал - Больше
                    // 10- Тотал - Меньше
                    // 11- Инд. тотал хозяев - Больше
                    // 12- Инд. тотал хозяев - Меньше
                    // 13- Инд. тотал гостей - Больше
                    // 14- Инд. тотал гостей - Меньше
                    if (marketId == 3) {
                        coefficient_more = FindValue(st, "7\":{\"value\":\"", "\",\"direction", false, false);
                        coefficient_less = FindValue(st, "8\":{\"value\":\"", "\",\"direction", true, false);
                    } else if (marketId == 4) {
                        coefficient_more = FindValue(st, "9\":{\"value\":\"", "\",\"direction", false, false);
                        coefficient_less = FindValue(st, "10\":{\"value\":\"", "\",\"direction", true, true);
                    } else if (marketId == 5) {
                        coefficient_more = FindValue(st, "11\":{\"value\":\"", "\",\"direction", false, true);
                        coefficient_less = FindValue(st, "12\":{\"value\":\"", "\",\"direction", true, true);
                    } else if (marketId == 6) {
                        coefficient_more = FindValue(st, "13\":{\"value\":\"", "\",\"direction", false, true);
                        coefficient_less = FindValue(st, "14\":{\"value\":\"", "\",\"direction", true, true);
                    }
                    coefficientAdd(eventId, bookmaker, marketId, outcome_value, coefficient_more);
                    Thread.sleep(5);
                    coefficientAdd(eventId, bookmaker, marketId, outcome_value, coefficient_less);
                }
            }
        }
    }

    public void FindCoefficients(ArrayList<Integer> matchId) throws IOException, InterruptedException {
        Iterable<event> events = eventRepository.findAll();
        //https://odds.ru/api/event/table/rate?marketId=1&gameTypeId=2&gamePeriod=0&matchId=2279293&sport=1
//        marketId=1 - 1Х2
//                 3 - Фора
//                 4 - Тотал
//                 5 - ИТ хозяев
//                 6 - ИТ гостей
//                gameTypeId=1 - основная линия
//                           2 - угловые
//                           8 - желтые карточки
//                           12 - удары в створ
//                           13 - оффсайды
//                           14 - фолы
//                                    (удары)
//                                    (штрафные)
//                                    (красные карточки)
//                            gamePeriod=0 - весь матч
//                                       1 - 1 тайм
//                                       2 - 2 тайм
        boolean isFind;
        for (Integer mt: matchId) {
            for (byte gamePeriod = 0; gamePeriod < 3; gamePeriod++) {
                for (int marketId = 3; marketId < 7; marketId++) {
                    isFind = false;
                    for (event es : events) {
                        if (es.getIdMatch().equals(mt) && es.getBettingLine() == 1 && es.getOccasion() == marketId && es.getGamePeriod() == gamePeriod ||
                                es.getIdMatch().equals(mt) && es.getBettingLine() == 2 && es.getOccasion() == marketId && es.getGamePeriod() == gamePeriod ||
                                es.getIdMatch().equals(mt) && es.getBettingLine() == 3 && es.getOccasion() == marketId && es.getGamePeriod() == gamePeriod ||
                                es.getIdMatch().equals(mt) && es.getBettingLine() == 4 && es.getOccasion() == marketId && es.getGamePeriod() == gamePeriod) {
                            System.out.println("Такое событие уже существует в БД!");
                            isFind = true;
                            break;
                        }
                    }
                    if (isFind) {
                        continue;
                    }
                    String idMatchesGet = "https://odds.ru/api/event/table/rate?marketId=" + marketId + "&gameTypeId=" + 2 + "&gamePeriod=" + gamePeriod + "&matchId=" + mt + "&sport=1";
                    StringBuilder response = ConnectSite(idMatchesGet, "odds_info");
                    if (!response.toString().isEmpty()) {
                        event event = new event(mt, gamePeriod, 1, marketId);
                        eventRepository.save(event);
                        FindCoefficients(response, marketId, event.getIdEvent());
                        Thread.sleep(11);
                    }
                    String idMatchesGet2 = "https://odds.ru/api/event/table/rate?marketId=" + marketId + "&gameTypeId=" + 8 + "&gamePeriod=" + gamePeriod + "&matchId=" + mt + "&sport=1";
                    StringBuilder response2 = ConnectSite(idMatchesGet2, "odds_info");
                    if (!response2.toString().isEmpty()) {
                        event event = new event(mt, gamePeriod, 2, marketId);
                        eventRepository.save(event);
                        FindCoefficients(response2, marketId, event.getIdEvent());
                        Thread.sleep(11);
                    }
                    String idMatchesGet3 = "https://odds.ru/api/event/table/rate?marketId=" + marketId + "&gameTypeId=" + 12 + "&gamePeriod=" + gamePeriod + "&matchId=" + mt + "&sport=1";
                    StringBuilder response3 = ConnectSite(idMatchesGet3, "odds_info");
                    if (!response3.toString().isEmpty()) {
                        event event = new event(mt, gamePeriod, 3, marketId);
                        eventRepository.save(event);
                        FindCoefficients(response3, marketId, event.getIdEvent());
                        Thread.sleep(11);
                    }
                    String idMatchesGet4 = "https://odds.ru/api/event/table/rate?marketId=" + marketId + "&gameTypeId=" + 13 + "&gamePeriod=" + gamePeriod + "&matchId=" + mt + "&sport=1";
                    StringBuilder response4 = ConnectSite(idMatchesGet4, "odds_info");
                    if (!response4.toString().isEmpty()) {
                        event event = new event(mt, gamePeriod, 4, marketId);
                        eventRepository.save(event);
                        FindCoefficients(response4, marketId, event.getIdEvent());
                        Thread.sleep(11);
                    }
                    String idMatchesGet5 = "https://odds.ru/api/event/table/rate?marketId=" + marketId + "&gameTypeId=" + 14 + "&gamePeriod=" + gamePeriod + "&matchId=" + mt + "&sport=1";
                    StringBuilder response5 = ConnectSite(idMatchesGet5, "odds_info");
                    if (!response5.toString().isEmpty()) {
                        event event = new event(mt, gamePeriod, 5, marketId);
                        eventRepository.save(event);
                        FindCoefficients(response5, marketId, event.getIdEvent());
                        Thread.sleep(11);
                    }
                    if (!response.toString().isEmpty() &&
                            !response2.toString().isEmpty() &&
                            !response3.toString().isEmpty() &&
                            !response4.toString().isEmpty() &&
                            !response5.toString().isEmpty()) {
                        System.out.println("Коэффициенты матча id: " + mt + " успешно занесён в базу данных! Тайм: " + gamePeriod);
                        Thread.sleep(11); // Задержка для безопасности потоков
                    } else  {
                        System.out.println("Коэффициенты матча id: " + mt + " не добавились в базу данных! Тайм: " + gamePeriod);
                        Thread.sleep(11); // Задержка для безопасности потоков
                    }
                }
            }
        }
    }

    public int FindValue(String str, String end, boolean book) {
        int value = 0;
        if (str.contains(end)) {
            try {
                value = Integer.parseInt(str.substring(str.indexOf(0) + 3, str.indexOf(end)));
            } catch (NumberFormatException ex) {
                System.out.println("Неверные данные с запроса!");
            }
        }
        return value;
    }

    public double FindValue(String str, String start, String end, boolean lastFind, boolean moreindex) {
        double value = 0.0;
        if (str.contains(start)) {
            if (str.contains(end)) {
                if (lastFind) {
                    if(moreindex) {
                        try {
                            value = Double.parseDouble(str.substring(str.lastIndexOf(start) + 14, str.lastIndexOf(end)));
                        } catch (NumberFormatException ex) {
                            System.out.println("Неверные данные с запроса!");
                        }
                    } else {
                        try {
                            value = Double.parseDouble(str.substring(str.lastIndexOf(start) + 13, str.lastIndexOf(end)));
                        } catch (NumberFormatException ex) {
                            System.out.println("Неверные данные с запроса!");
                        }
                    }
                } else {
                    if(moreindex) {
                        try {
                            value = Double.parseDouble(str.substring(str.indexOf(start) + 14, str.indexOf(end)));
                        } catch (NumberFormatException ex) {
                            System.out.println("Неверные данные с запроса!");
                        }
                    } else {
                        try {
                            value = Double.parseDouble(str.substring(str.indexOf(start) + 13, str.indexOf(end)));
                        } catch (NumberFormatException ex) {
                            System.out.println("Неверные данные с запроса!");
                        }
                    }
                }
            }
        }
        return value;
    }

    public double FindValue(String str, String end) {
        double value = 0.0;
        if (str.contains(end)) {
            try {
                value = Double.parseDouble(str.substring(str.indexOf(0) + 4, str.lastIndexOf(end)));
            } catch (NumberFormatException ex) {
                System.out.println("Неверные данные с запроса!");
            }
        }
        return value;
    }

    public void coefficientAdd(Long idEvent, Integer bookmakerId, Integer outcomeId, Double outcomeValue, Double coefficientValue) {
        coefficient_table coefficient = new coefficient_table(idEvent, bookmakerId, outcomeId, outcomeValue, coefficientValue);
        coefficientRepository.save(coefficient);
        System.out.println("Линия: " + outcomeId + " " + outcomeValue + " Букмекер: " + bookmakerId + " КФ: " + coefficientValue + " успешно добавлена!");
    }

    public void countryAdd(String nameCountry) {
        Iterable<country> countries = countryRepository.findAll();
        boolean isFind = false;
        for (country cts : countries) {
            if (cts.getNameCountry().trim().equals(nameCountry.trim())) {
                isFind = true;
                break;
            }
        }
        if (!isFind) {
            country country = new country(nameCountry);
            countryRepository.save(country);
            System.out.println("Страна: " + nameCountry + " успешно добавлена!");
        } else {
            System.out.println("Ошибка! Страна: " + nameCountry + " уже есть в базе данных!");
        }
    }

    public void leagueAdd(String nameLeague, String nameCountry) {
        Iterable<country> countries = countryRepository.findAll();
        Iterable<league> leagues = leagueRepository.findAll();
        boolean isFind = false;
        int idCountry = -1;
        for (country cts : countries) {
            if (cts.getNameCountry().trim().equals(nameCountry.trim())) {
                Optional<country> countryId = countryRepository.findById(cts.getIdCountry());
                idCountry = countryId.get().getIdCountry();
                for (league lgs : leagues) {
                    if (lgs.getNameLeague().trim().equals(nameLeague.trim())) {
                        isFind = true;
                        break;
                    }
                }
            }
        }
        if (!isFind) {
            league league = new league(nameLeague, idCountry);
            leagueRepository.save(league);
            System.out.println("Лига: " + nameLeague + " [Страна: " + nameCountry + "] успешно добавлена!");
        } else {
            System.out.println("Ошибка! Лига: " + nameLeague + " [Страна: " + nameCountry + "] уже есть в базе данных!");
        }
    }

    public void teamAdd(String nameTeam, String nameLeague, String nameCountry) {
        Iterable<country> countries = countryRepository.findAll();
        Iterable<league> leagues = leagueRepository.findAll();
        Iterable<team> teams = teamRepository.findAll();
        boolean isFind = false;
        int idLeague = -1;
        for (country cts : countries) {
            if (cts.getNameCountry().trim().equals(nameCountry.trim())) {
                for (league lgs : leagues) {
                    if (lgs.getNameLeague().trim().equals(nameLeague.trim())) {
                        Optional<league> leagueId = leagueRepository.findById(lgs.getIdLeague());
                        idLeague = leagueId.get().getIdLeague();
                        for (team tms : teams) {
                            if (tms.getNameTeam().trim().equals(nameTeam.trim())) {
                                isFind = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (!isFind) {
            team team = new team(nameTeam, idLeague, (byte) -1, (byte) -1);
            teamRepository.save(team);
            System.out.println("Клуб: " + nameTeam + " [Лига: " + nameLeague + "] [Страна: " + nameCountry + "] успешно добавлена!");
        } else {
            System.out.println("Ошибка! Клуб: " + nameTeam + " [Лига: " + nameLeague + "] [Страна: " + nameCountry + "] уже есть в базе данных!");
        }
    }

    public void matchAdd(String dateM, String timeM, String nameTeamHome, String nameTeamAway, String nameLeague, String nameCountry) {
        Iterable<country> countries = countryRepository.findAll();
        Iterable<league> leagues = leagueRepository.findAll();
        Iterable<team> teams = teamRepository.findAll();
        Iterable<match_table> matches = matchRepository.findAll();
        LocalDate dateMatch = LocalDate.parse(dateM);
        LocalTime timeMatch = LocalTime.parse(timeM);
        boolean isFind = false;
        int idLeague = -1;
        int idTeamHome = -1;
        int idTeamAway = -1;
        for (country cts : countries) {
            if (cts.getNameCountry().trim().equals(nameCountry.trim())) {
                for (league lgs : leagues) {
                    if (lgs.getNameLeague().trim().equals(nameLeague.trim())) {
                        Optional<league> leagueId = leagueRepository.findById(lgs.getIdLeague());
                        idLeague = leagueId.get().getIdLeague();
                        for (team tms : teams) {
                            if (tms.getNameTeam().trim().equals(nameTeamHome.trim())) {
                                Optional<team> teamHome = teamRepository.findById(tms.getIdTeam());
                                idTeamHome = teamHome.get().getIdTeam();
                            }
                            if (tms.getNameTeam().trim().equals(nameTeamAway.trim())) {
                                Optional<team> teamAway = teamRepository.findById(tms.getIdTeam());
                                idTeamAway = teamAway.get().getIdTeam();
                            }
                        }
                    }
                }
            }
        }
        for (match_table mts : matches) {
            if (mts.getDateMatch().equals(dateMatch) && mts.getTimeMatch().equals(timeMatch) && mts.getTeamHome() == idTeamHome && mts.getTeamGuest() == idTeamAway) {
                isFind = true;
                break;
            }
        }
        if (!isFind) {
            match_table match = new match_table(idTeamHome, idTeamAway, dateMatch, timeMatch,0, 0, -1, 0, 0, -1, 0, 0, 0, 0,
                    -1, 0, 0, -1, 0, 0, -1, 0, 0, -1,
                    0, 0, 0, 0, 0, -1, 0, 0, -1, 0,
                    0, -1, 0, 0, -1, 0, 0, -1, 0, 0,
                    -1, 0, 0, -1, 0, 0, -1, 0, 0, -1,
                    0, 0, -1, 0, 0, -1);
            matchRepository.save(match);
            System.out.println("Матч" + dateMatch + timeMatch + " " + nameTeamHome + " - " + nameTeamAway + " [Лига: " + nameLeague + "] [Страна: " + nameCountry + "] успешно добавлен!");
        } else {
            System.out.println("Ошибка! Матч: " + dateMatch + timeMatch + " " + nameTeamHome + " - " + nameTeamAway + " [Лига: " + nameLeague + "] [Страна: " + nameCountry + "] уже есть в базе данных!");
        }
    }
}
