package nk.mframe.demo.controller;

import nk.mframe.demo.dao.*;
import nk.mframe.demo.model.coefficient_table;
import nk.mframe.demo.model.event;
import nk.mframe.demo.model.league;
import nk.mframe.demo.model.team;
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
        for (byte gamePeriod = 0; gamePeriod < 3; gamePeriod++) {
            for (int marketId = 3; marketId < 7; marketId++) {
                FindCoefficients(matchesId, marketId, 2, gamePeriod);
                Thread.sleep(1000);
                FindCoefficients(matchesId, marketId, 8, gamePeriod);
                Thread.sleep(1000);
                FindCoefficients(matchesId, marketId, 12, gamePeriod);
                Thread.sleep(1000);
                FindCoefficients(matchesId, marketId, 13, gamePeriod);
                Thread.sleep(1000);
                FindCoefficients(matchesId, marketId, 14, gamePeriod);
                Thread.sleep(1000);
            }
        }
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

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

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
                    System.out.println(st);
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

    public void FindCoefficients(ArrayList<Integer> matchId, Integer marketId, Integer gameTypeId, Byte gamePeriod) throws IOException, InterruptedException {
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
            String idMatchesGet = "https://odds.ru/api/event/table/rate?marketId=" + marketId + "&gameTypeId=" + gameTypeId + "&gamePeriod=" + gamePeriod + "&matchId=" + mt;
            StringBuilder response = ConnectSite(idMatchesGet, "odds_info");

            if (!response.toString().isEmpty()) {
                event event = new event(mt, gamePeriod, gameTypeId, marketId); // ПРОВЕРИТЬ!
                eventRepository.save(event);

                FindCoefficients(response, marketId, event.getIdEvent());
            }
            System.out.println("Коэффициенты матча id: " + idMatchesGet + " успешно занесён в базу данных!");
            Thread.sleep(1000); // Задержка для безопасности потоков
        }
    }

    public int FindValue(String str, String end, boolean book) {
        int value = 0;
        if (str.contains(end)) {
            value = Integer.parseInt(str.substring(str.indexOf(0) + 3, str.indexOf(end)));
        }
        return value;
    }

    public double FindValue(String str, String start, String end, boolean lastFind, boolean moreindex) {
        double value = 0.0;
        if (str.contains(start)) {
            if (str.contains(end)) {
                if (lastFind) {
                    if(moreindex) {
                        value = Double.parseDouble(str.substring(str.lastIndexOf(start) + 14, str.lastIndexOf(end)));
                    } else {
                        value = Double.parseDouble(str.substring(str.lastIndexOf(start) + 13, str.lastIndexOf(end)));
                    }
                } else {
                    value = Double.parseDouble(str.substring(str.indexOf(start) + 13, str.indexOf(end)));
                }
            }
        }
        return value;
    }

    public double FindValue(String str, String end) {
        double value = 0.0;
        if (str.contains(end)) {
            value = Double.parseDouble(str.substring(str.indexOf(0) + 4, str.lastIndexOf(end)));
        }
        return value;
    }

    public void coefAdd(Long idEvent, Integer bookmakerId, Integer outcomeId, Double outcomeValue, Double coefficient) {
        coefficient_table coef = new coefficient_table(idEvent, bookmakerId, outcomeId, outcomeValue, coefficient);
        coefficientRepository.save(coef);
    }
}
