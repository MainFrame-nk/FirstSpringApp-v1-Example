package nk.mframe.demo.controller;

import nk.mframe.demo.dao.LeagueRepository;
import nk.mframe.demo.dao.MatchRepository;
import nk.mframe.demo.dao.TeamRepository;
import nk.mframe.demo.model.league;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@Controller
public class CoefficientController {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("/coefsadd")
    public String coefMain(Model model) throws IOException, InterruptedException {
        ArrayList<Integer> matchesId = FindIdMatches(); // Найти все id на матчи на день
        ArrayList<String> todayMatches = FindMatches(); // Найти все доступные матчи на день
        FindCoefficients(matchesId, 4, 2, (byte) 0);
        return "redirect:/admin";
    }

    public static StringBuilder ConnectSite(String url, String findData) throws IOException {
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

    public static ArrayList<String> FindMatches() throws IOException {
        StringBuilder response = ConnectSite("https://odds.ru/football/", "ListMatchesFootballStore"); //Взять данные с сайта

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

    public static ArrayList<Integer> FindIdMatches() throws IOException {
        StringBuilder response = ConnectSite("https://odds.ru/football/", "ListMatchesFootballStore"); //Взять данные с сайта

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

    public static void FindCoefficients(StringBuilder response, Integer marketId) {
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
                    if (bookmaker != 0) {
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


                    System.out.println("Cтавка: " + outcome_value + " Букмекер: " + bookmaker + " КФ 1: " + coefficient_more + " КФ 2: " + coefficient_less);
                }
            }
        }
    }

    public static void FindCoefficients(ArrayList<Integer> matchId, Integer marketId, Integer gameTypeId, Byte gamePeriod) throws IOException, InterruptedException {
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
            FindCoefficients(response, marketId);
            System.out.println("Коэффициенты матча id: " + idMatchesGet + "успешно занесён в базу данных!");
            Thread.sleep(10000); // Задержка для безопасности потоков
        }
    }

    public static int FindValue(String str, String end, boolean book) {
        int value = 0;
        if (str.contains(end)) {
            value = Integer.parseInt(str.substring(str.indexOf(0) + 3, str.indexOf(end)));
        }
        return value;
    }

    public static double FindValue(String str, String start, String end, boolean lastFind, boolean moreindex) {
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

    public static double FindValue(String str, String end) {
        double value = 0.0;
        if (str.contains(end)) {
            value = Double.parseDouble(str.substring(str.indexOf(0) + 4, str.lastIndexOf(end)));
        }
        return value;
    }
}
