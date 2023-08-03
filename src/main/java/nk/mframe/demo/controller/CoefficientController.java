package nk.mframe.demo.controller;

import nk.mframe.demo.dao.*;
import nk.mframe.demo.model.coefficient_table;
import nk.mframe.demo.model.event;
import nk.mframe.demo.model.league;
import nk.mframe.demo.model.team;
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
import java.util.ArrayList;

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

    @GetMapping("/import/coefs")
    public String coefMain(Model model) {
        return "import-index";
    }

    @PostMapping("/import/coefs")
    public String coefImport(@RequestParam String day_matches, Model model) throws IOException, InterruptedException {
        ArrayList<Integer> matchesId = FindIdMatches(day_matches); // Найти все id на матчи на день
       // ArrayList<String> todayMatches = FindMatches(day_matches); // Найти все доступные матчи на день
        FindCoefficients(matchesId);
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

    public void FindCoefficients(StringBuilder response, Integer marketId, Long eventId) {
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
                    coefAdd(eventId, bookmaker, marketId, outcome_value, coefficient_more);
                    coefAdd(eventId, bookmaker, marketId, outcome_value, coefficient_less);
                    System.out.println("Cтавка: " + outcome_value + " Букмекер: " + bookmaker + " КФ 1: " + coefficient_more + " КФ 2: " + coefficient_less);
                }
            }
        }
    }

    public void FindCoefficients(ArrayList<Integer> matchId) throws IOException, InterruptedException {
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
        for (Integer mt: matchId) {
            for (byte gamePeriod = 0; gamePeriod < 3; gamePeriod++) {
                for (int marketId = 3; marketId < 7; marketId++) {
                    String idMatchesGet = "https://odds.ru/api/event/table/rate?marketId=" + marketId + "&gameTypeId=" + 2 + "&gamePeriod=" + gamePeriod + "&matchId=" + mt + "&sport=1";
                    StringBuilder response = ConnectSite(idMatchesGet, "odds_info");
                    if (!response.toString().isEmpty()) {
                        event event = new event(mt, gamePeriod, 2, marketId);
                        eventRepository.save(event);
                        FindCoefficients(response, marketId, event.getIdEvent());
                        System.out.println("gameTypeId=2 marketId= " + marketId);
                        Thread.sleep(101);
                    }
                    String idMatchesGet2 = "https://odds.ru/api/event/table/rate?marketId=" + marketId + "&gameTypeId=" + 8 + "&gamePeriod=" + gamePeriod + "&matchId=" + mt + "&sport=1";
                    StringBuilder response2 = ConnectSite(idMatchesGet2, "odds_info");
                    if (!response2.toString().isEmpty()) {
                        event event = new event(mt, gamePeriod, 8, marketId);
                        eventRepository.save(event);
                        FindCoefficients(response2, marketId, event.getIdEvent());
                        System.out.println("gameTypeId=8 marketId= " + marketId);
                        Thread.sleep(101);
                    }
                    String idMatchesGet3 = "https://odds.ru/api/event/table/rate?marketId=" + marketId + "&gameTypeId=" + 12 + "&gamePeriod=" + gamePeriod + "&matchId=" + mt + "&sport=1";
                    StringBuilder response3 = ConnectSite(idMatchesGet3, "odds_info");
                    if (!response3.toString().isEmpty()) {
                        event event = new event(mt, gamePeriod, 12, marketId);
                        eventRepository.save(event);
                        FindCoefficients(response3, marketId, event.getIdEvent());
                        System.out.println("gameTypeId=12 marketId= " + marketId);
                        Thread.sleep(101);
                    }
                    String idMatchesGet4 = "https://odds.ru/api/event/table/rate?marketId=" + marketId + "&gameTypeId=" + 13 + "&gamePeriod=" + gamePeriod + "&matchId=" + mt + "&sport=1";
                    StringBuilder response4 = ConnectSite(idMatchesGet4, "odds_info");
                    if (!response4.toString().isEmpty()) {
                        event event = new event(mt, gamePeriod, 13, marketId);
                        eventRepository.save(event);
                        FindCoefficients(response4, marketId, event.getIdEvent());
                        System.out.println("gameTypeId=13 marketId= " + marketId);
                        Thread.sleep(101);
                    }
                    String idMatchesGet5 = "https://odds.ru/api/event/table/rate?marketId=" + marketId + "&gameTypeId=" + 14 + "&gamePeriod=" + gamePeriod + "&matchId=" + mt + "&sport=1";
                    StringBuilder response5 = ConnectSite(idMatchesGet5, "odds_info");
                    if (!response5.toString().isEmpty()) {
                        event event = new event(mt, gamePeriod, 12, marketId);
                        eventRepository.save(event);
                        FindCoefficients(response5, marketId, event.getIdEvent());
                        System.out.println("gameTypeId=14 marketId= " + marketId);
                        Thread.sleep(101);
                    }
                    System.out.println("Коэффициенты матча id: " + mt + " успешно занесён в базу данных! Тайм: " + gamePeriod);
                    Thread.sleep(101); // Задержка для безопасности потоков
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

    public void coefAdd(Long idEvent, Integer bookmakerId, Integer outcomeId, Double outcomeValue, Double coefficient) {
        coefficient_table coef = new coefficient_table(idEvent, bookmakerId, outcomeId, outcomeValue, coefficient);
        coefficientRepository.save(coef);
    }
}
