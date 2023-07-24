package nk.mframe.demo.controller;

import nk.mframe.demo.dao.LeagueRepository;
import nk.mframe.demo.dao.MatchRepository;
import nk.mframe.demo.dao.SeasonRepository;
import nk.mframe.demo.dao.TeamRepository;
import nk.mframe.demo.model.league;
import nk.mframe.demo.model.match_table;
import nk.mframe.demo.model.team;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/admin")
    public String adminMain(Model model) {
        Iterable<league> league = leagueRepository.findAll();
        model.addAttribute("league", league);
        return "admin-index";
    }

    @PostMapping("/admin")
    public String importMatch(Model model) {
        excelParse("C:\\Users\\Lumix\\Downloads\\readExcelFIle\\src\\main\\java\\org\\example\\parsing.xlsx");
        System.out.println("Import success!");
        return "redirect:/admin";
    }

    public void excelParse(String fileName) {
        int teamHome = -1;

        int teamGuest = -1;

        int scoreHome = 0, scoreGuest = 0;

        LocalDate dateMatch = null;

        LocalTime timeMatch = null;
        int shotFirstHalfHome= 0, shotSecondHalfHome= 0;

        int shotFirstHalfGuest= 0, shotSecondHalfGuest= 0;

        int shotOnTargetFirstHalfHome= 0, shotOnTargetSecondHalfHome= 0;

        int shotOnTargetFirstHalfGuest= 0, shotOnTargetSecondHalfGuest= 0;

        int possessionFirstHalfHome= 0, possessionSecondHalfHome= 0;

        int possessionFirstHalfGuest= 0, possessionSecondHalfGuest= 0;

        int cornerFirstHalfHome= 0, cornerSecondHalfHome= 0;

        int cornerFirstHalfGuest= 0, cornerSecondHalfGuest= 0;

        int yellowCardFirstHalfHome= 0, yellowCardSecondHalfHome= 0;

        int yellowCardFirstHalfGuest= 0, yellowCardSecondHalfGuest= 0;
        int redCardFirstHalfHome= 0, redCardSecondHalfHome= 0;
        int redCardFirstHalfGuest= 0, redCardSecondHalfGuest= 0;
        int freeKickFirstHalfHome= 0, freeKickSecondHalfHome= 0;
        int freeKickFirstHalfGuest= 0, freeKickSecondHalfGuest= 0;
        int offsideFirstHalfHome= 0, offsideSecondHalfHome= 0;
        int offsideFirstHalfGuest= 0, offsideSecondHalfGuest= 0;
        int foulFirstHalfHome= 0, foulSecondHalfHome= 0;
        int foulFirstHalfGuest= 0, foulSecondHalfGuest= 0;
        //инициализируем потоки
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = Files.newInputStream(Paths.get(fileName));
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        String possession = "Владение мячом";
        String shots = "Удары¬";
        String shotsOnTarget = "Удары в створ";
        String freeKicks = "Штрафные";
        String corners = "Угловые";
        String offsides = "Офсайды";
        String fouls = "Фолы";
        String yellowCards = "Желтые карточки";
        String redCards = "Красные карточки";
        int i = 1;
        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            for (Cell cell : row) {
                //перебираем возможные типы ячеек
                if (cell.toString().isEmpty()) {
                    continue;
                }
                if (cell.getRowIndex() == 0) {
                    continue;
                }
                if (cell.getColumnIndex() == 0) {
                    String date = cell.toString().substring(0, 10);
                    String time = cell.toString().substring(12, cell.toString().lastIndexOf(":"));

                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    dateMatch = LocalDate.parse(date, dateFormat);

                    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
                    timeMatch = LocalTime.parse(time, timeFormat);
                    i++;
                    continue;
                }
                if (cell.getColumnIndex() == 1) {
                    teamHome = parseTeam(cell.toString());
                    continue;
                }
                if (cell.getColumnIndex() == 2) {
                    scoreHome = Integer.parseInt(cell.toString().substring(0, cell.toString().indexOf("-")));
                    scoreGuest = Integer.parseInt(cell.toString().substring(cell.toString().indexOf("-") + 1));
                    continue;
                }
                if (cell.getColumnIndex() == 3) {
                    teamGuest = parseTeam(cell.toString());
                    continue;
                }
                int indexPossession = cell.toString().lastIndexOf(possession);
                int indexShots = cell.toString().lastIndexOf(shots);
                int indexShotsOnTarget = cell.toString().lastIndexOf(shotsOnTarget);
                int indexFreeKicks = cell.toString().lastIndexOf(freeKicks);
                int indexCorners = cell.toString().lastIndexOf(corners);
                int indexOffsides = cell.toString().lastIndexOf(offsides);
                int indexFouls = cell.toString().lastIndexOf(fouls);
                int indexYellowCards = cell.toString().lastIndexOf(yellowCards);
                int indexRedCards = cell.toString().lastIndexOf(redCards);
                if (indexPossession == -1) {
                    System.out.println("Владение мячом не найдено");
                } else {
                    // Второй тайм
                    String str = cell.toString().substring(indexPossession, indexPossession + possession.length() + 14);
                    int indexStr = str.indexOf("SH÷");
                    int posFirstHalfHome = Integer.parseInt(str.substring(indexStr + 3, str.indexOf('%')));
                    int indexStr2 = str.indexOf("SI÷");
                    int posSecondHalfAway = Integer.parseInt(str.substring(indexStr2 + 3, str.lastIndexOf('%')));
                    // Первый тайм
                    int indexPossession2 = cell.toString().lastIndexOf(possession, indexPossession - 1);
                    String str3 = cell.toString().substring(indexPossession2, indexPossession2 + possession.length() + 14);
                    int indexStr3 = str3.indexOf("SH÷");
                    int posFirstHalfAway = Integer.parseInt(str3.substring(indexStr3 + 3, str3.indexOf('%')));
                    int indexStr4 = str3.indexOf("SI÷");
                    int posSecondHalfHome = Integer.parseInt(str3.substring(indexStr4 + 3, str3.lastIndexOf('%')));

                    possessionFirstHalfHome = posFirstHalfAway;
                    possessionFirstHalfGuest = posSecondHalfHome;
                    possessionSecondHalfHome = posFirstHalfHome;
                    possessionSecondHalfGuest = posSecondHalfAway;
                }
                if (indexShots == -1) {
                    System.out.println("Количество ударов не найдено");
                } else {
                    // Второй тайм
                    String str = cell.toString().substring(indexShots, indexShots + shots.length() + 14);
                    int indexStr = str.indexOf("SH÷");
                    int shotsSecondHalfHome = Integer.parseInt(str.substring(indexStr + 3, str.indexOf("¬SI")));
                    int indexStr2 = str.indexOf("SI÷");
                    int shotsSecondHalfAway = Integer.parseInt(str.substring(indexStr2 + 3, str.lastIndexOf("¬~")));
                    // Первый тайм
                    int indexShots2 = cell.toString().lastIndexOf(shots, indexShots - 1);
                    String str3 = cell.toString().substring(indexShots2, indexShots2 + shots.length() + 14);
                    int indexStr3 = str3.indexOf("SH÷");
                    int shotsFirstHalfHome = Integer.parseInt(str3.substring(indexStr3 + 3, str3.indexOf("¬SI")));
                    int indexStr4 = str3.indexOf("SI÷");
                    int shotsFirstHalfAway = Integer.parseInt(str3.substring(indexStr4 + 3, str3.lastIndexOf("¬~")));

                    shotFirstHalfHome = shotsFirstHalfHome;
                    shotFirstHalfGuest = shotsFirstHalfAway;
                    shotSecondHalfHome = shotsSecondHalfHome;
                    shotSecondHalfGuest = shotsSecondHalfAway;
                }
                if (indexShotsOnTarget == -1) {
                    System.out.println("Количество ударов в створ не найдено");
                } else {
                    // Второй тайм
                    String str = cell.toString().substring(indexShotsOnTarget, indexShotsOnTarget + shotsOnTarget.length() + 14);
                    int indexStr = str.indexOf("SH÷");
                    int shotsOnTargetSecondHalfHome = Integer.parseInt(str.substring(indexStr + 3, str.indexOf("¬SI")));
                    int indexStr2 = str.indexOf("SI÷");
                    int shotsOnTargetSecondHalfAway = Integer.parseInt(str.substring(indexStr2 + 3, str.lastIndexOf("¬~")));
                    // Первый тайм
                    int indexShotsOnTarget2 = cell.toString().lastIndexOf(shotsOnTarget, indexShotsOnTarget - 1);
                    String str3 = cell.toString().substring(indexShotsOnTarget2, indexShotsOnTarget2 + shotsOnTarget.length() + 14);
                    int indexStr3 = str3.indexOf("SH÷");
                    int shotsOnTargetFirstHalfHome = Integer.parseInt(str3.substring(indexStr3 + 3, str3.indexOf("¬SI")));
                    int indexStr4 = str3.indexOf("SI÷");
                    int shotsOnTargetFirstHalfAway = Integer.parseInt(str3.substring(indexStr4 + 3, str3.lastIndexOf("¬~")));

                    shotOnTargetFirstHalfHome = shotsOnTargetFirstHalfHome;
                    shotOnTargetFirstHalfGuest = shotsOnTargetFirstHalfAway;
                    shotOnTargetSecondHalfHome = shotsOnTargetSecondHalfHome;
                    shotOnTargetSecondHalfGuest = shotsOnTargetSecondHalfAway;
                }
                if (indexFreeKicks == -1) {
                    System.out.println("Количество штрафных не найдено");
                } else {
                    // Второй тайм
                    String str = cell.toString().substring(indexFreeKicks, indexFreeKicks + freeKicks.length() + 14);
                    int indexStr = str.indexOf("SH÷");
                    int freeKicksSecondHalfHome = Integer.parseInt(str.substring(indexStr + 3, str.indexOf("¬SI")));
                    int indexStr2 = str.indexOf("SI÷");
                    int freeKicksSecondHalfAway = Integer.parseInt(str.substring(indexStr2 + 3, str.lastIndexOf("¬~")));
                    // Первый тайм
                    int indexFreeKicks2 = cell.toString().lastIndexOf(freeKicks, indexFreeKicks - 1);
                    String str3 = cell.toString().substring(indexFreeKicks2, indexFreeKicks2 + freeKicks.length() + 14);
                    int indexStr3 = str3.indexOf("SH÷");
                    int freeKicksFirstHalfHome = Integer.parseInt(str3.substring(indexStr3 + 3, str3.indexOf("¬SI")));
                    int indexStr4 = str3.indexOf("SI÷");
                    int freeKicksFirstHalfAway = Integer.parseInt(str3.substring(indexStr4 + 3, str3.lastIndexOf("¬~")));

                    freeKickFirstHalfHome = freeKicksFirstHalfHome;
                    freeKickFirstHalfGuest = freeKicksFirstHalfAway;
                    freeKickSecondHalfHome = freeKicksSecondHalfHome;
                    freeKickSecondHalfGuest = freeKicksSecondHalfAway;
                }
                if (indexCorners == -1) {
                    System.out.println("Количество угловых не найдено");
                } else {
                    // Второй тайм
                    String str = cell.toString().substring(indexCorners, indexCorners + corners.length() + 14);
                    int indexStr = str.indexOf("SH÷");
                    int cornersSecondHalfHome = Integer.parseInt(str.substring(indexStr + 3, str.indexOf("¬SI")));
                    int indexStr2 = str.indexOf("SI÷");
                    int cornersSecondHalfAway = Integer.parseInt(str.substring(indexStr2 + 3, str.lastIndexOf("¬~")));
                    // Первый тайм
                    int indexCorners2 = cell.toString().lastIndexOf(corners, indexCorners - 1);
                    String str3 = cell.toString().substring(indexCorners2, indexCorners2 + corners.length() + 14);
                    int indexStr3 = str3.indexOf("SH÷");
                    int cornersFirstHalfHome = Integer.parseInt(str3.substring(indexStr3 + 3, str3.indexOf("¬SI")));
                    int indexStr4 = str3.indexOf("SI÷");
                    int cornersFirstHalfAway = Integer.parseInt(str3.substring(indexStr4 + 3, str3.lastIndexOf("¬~")));

                    cornerFirstHalfHome = cornersFirstHalfHome;
                    cornerFirstHalfGuest = cornersFirstHalfAway;
                    cornerSecondHalfHome = cornersSecondHalfHome;
                    cornerSecondHalfGuest = cornersSecondHalfAway;
                }
                if (indexOffsides == -1) {
                    System.out.println("Количество оффсайдов не найдено");
                } else {
                    // Второй тайм
                    String str = cell.toString().substring(indexOffsides, indexOffsides + offsides.length() + 14);
                    int indexStr = str.indexOf("SH÷");
                    int offsidesSecondHalfHome = Integer.parseInt(str.substring(indexStr + 3, str.indexOf("¬SI")));
                    int indexStr2 = str.indexOf("SI÷");
                    int offsidesSecondHalfAway = Integer.parseInt(str.substring(indexStr2 + 3, str.lastIndexOf("¬~")));
                    // Первый тайм
                    int indexOffsides2 = cell.toString().lastIndexOf(offsides, indexOffsides - 1);
                    String str3 = cell.toString().substring(indexOffsides2, indexOffsides2 + offsides.length() + 14);
                    int indexStr3 = str3.indexOf("SH÷");
                    int offsidesFirstHalfHome = Integer.parseInt(str3.substring(indexStr3 + 3, str3.indexOf("¬SI")));
                    int indexStr4 = str3.indexOf("SI÷");
                    int offsidesFirstHalfAway = Integer.parseInt(str3.substring(indexStr4 + 3, str3.lastIndexOf("¬~")));

                    offsideFirstHalfHome = offsidesFirstHalfHome;
                    offsideFirstHalfGuest = offsidesFirstHalfAway;
                    offsideSecondHalfHome = offsidesSecondHalfHome;
                    offsideSecondHalfGuest = offsidesSecondHalfAway;
                }
                if (indexFouls == -1) {
                    System.out.println("Количество фоллов не найдено");
                } else {
                    // Второй тайм
                    String str = cell.toString().substring(indexFouls, indexFouls + fouls.length() + 14);
                    int indexStr = str.indexOf("SH÷");
                    int foulsSecondHalfHome = Integer.parseInt(str.substring(indexStr + 3, str.indexOf("¬SI")));
                    int indexStr2 = str.indexOf("SI÷");
                    int foulsSecondHalfAway = Integer.parseInt(str.substring(indexStr2 + 3, str.lastIndexOf("¬~")));
                    // Первый тайм
                    int indexFouls2 = cell.toString().lastIndexOf(fouls, indexFouls - 1);
                    String str3 = cell.toString().substring(indexFouls2, indexFouls2 + fouls.length() + 14);
                    int indexStr3 = str3.indexOf("SH÷");
                    int foulsFirstHalfHome = Integer.parseInt(str3.substring(indexStr3 + 3, str3.indexOf("¬SI")));
                    int indexStr4 = str3.indexOf("SI÷");
                    int foulsFirstHalfAway = Integer.parseInt(str3.substring(indexStr4 + 3, str3.lastIndexOf("¬~")));

                    foulFirstHalfHome = foulsFirstHalfHome;
                    foulFirstHalfGuest = foulsFirstHalfAway;
                    foulSecondHalfHome = foulsSecondHalfHome;
                    foulSecondHalfGuest = foulsSecondHalfAway;
                }
                if (indexYellowCards == -1) {
                    System.out.println("Количество желтых карточек не найдено");
                } else {
                    // Второй тайм
                    String str = cell.toString().substring(indexYellowCards, indexYellowCards + yellowCards.length() + 14);
                    int indexStr = str.indexOf("SH÷");
                    int yellowCardsSecondHalfHome = Integer.parseInt(str.substring(indexStr + 3, str.indexOf("¬SI")));
                    int indexStr2 = str.indexOf("SI÷");
                    int yellowCardsSecondHalfAway = Integer.parseInt(str.substring(indexStr2 + 3, str.lastIndexOf("¬~")));
                    // Первый тайм
                    int indexYellowCards2 = cell.toString().lastIndexOf(yellowCards, indexYellowCards - 1);
                    String str3 = cell.toString().substring(indexYellowCards2, indexYellowCards2 + yellowCards.length() + 14);
                    int indexStr3 = str3.indexOf("SH÷");
                    int yellowCardsFirstHalfHome = Integer.parseInt(str3.substring(indexStr3 + 3, str3.indexOf("¬SI")));
                    int indexStr4 = str3.indexOf("SI÷");
                    int yellowCardsFirstHalfAway = Integer.parseInt(str3.substring(indexStr4 + 3, str3.lastIndexOf("¬~")));

                    yellowCardFirstHalfHome = yellowCardsFirstHalfHome;
                    yellowCardFirstHalfGuest = yellowCardsFirstHalfAway;
                    yellowCardSecondHalfHome = yellowCardsSecondHalfHome;
                    yellowCardSecondHalfGuest = yellowCardsSecondHalfAway;
                }
                if (indexRedCards == -1) {
                    System.out.println("Количество красных карточек не найдено");
                } else {
                    // Второй тайм
                    String str = cell.toString().substring(indexRedCards, indexRedCards + redCards.length() + 14);
                    int indexStr = str.indexOf("SH÷");
                    int redCardsSecondHalfHome = Integer.parseInt(str.substring(indexStr + 3, str.indexOf("¬SI")));
                    int indexStr2 = str.indexOf("SI÷");
                    int redCardsSecondHalfAway = Integer.parseInt(str.substring(indexStr2 + 3, str.lastIndexOf("¬~")));
                    // Первый тайм
                    int indexRedCards2 = cell.toString().lastIndexOf(redCards, indexRedCards - 1);
                    String str3 = cell.toString().substring(indexRedCards2, indexRedCards2 + redCards.length() + 14);
                    int indexStr3 = str3.indexOf("SH÷");
                    int redCardsFirstHalfHome = Integer.parseInt(str3.substring(indexStr3 + 3, str3.indexOf("¬SI")));
                    int indexStr4 = str3.indexOf("SI÷");
                    int redCardsFirstHalfAway = Integer.parseInt(str3.substring(indexStr4 + 3, str3.lastIndexOf("¬~")));

                    redCardFirstHalfHome = redCardsFirstHalfHome;
                    redCardFirstHalfGuest = redCardsFirstHalfAway;
                    redCardSecondHalfHome = redCardsSecondHalfHome;
                    redCardSecondHalfGuest = redCardsSecondHalfAway;
                }
            }
        }
        match_table matches = new match_table(teamHome, teamGuest, dateMatch, timeMatch,shotFirstHalfHome, shotSecondHalfHome, -1, shotFirstHalfGuest, shotSecondHalfGuest, -1, scoreHome, scoreGuest, possessionFirstHalfHome, possessionSecondHalfHome,
                -1, possessionFirstHalfGuest, possessionSecondHalfGuest, -1, shotOnTargetFirstHalfHome, shotOnTargetSecondHalfHome, -1, shotOnTargetFirstHalfGuest, shotOnTargetSecondHalfGuest, -1,
                cornerFirstHalfHome, cornerSecondHalfHome, -1, cornerFirstHalfGuest, cornerSecondHalfGuest, -1, yellowCardFirstHalfHome, yellowCardSecondHalfHome, -1, yellowCardFirstHalfGuest,
                yellowCardSecondHalfGuest, -1, redCardFirstHalfHome, redCardSecondHalfHome, -1, redCardFirstHalfGuest, redCardSecondHalfGuest, -1, freeKickFirstHalfHome, freeKickSecondHalfHome,
                -1, freeKickFirstHalfGuest, freeKickSecondHalfGuest, -1, offsideFirstHalfHome, offsideSecondHalfHome, -1, offsideFirstHalfGuest, offsideSecondHalfGuest, -1,
                foulFirstHalfHome, foulSecondHalfHome, -1, foulFirstHalfGuest, foulSecondHalfGuest, -1);
        matchRepository.save(matches);
    }
    public int parseTeam(String team) {
        int idTeam = -1;
        if (Objects.equals(team, "Арсенал")) {
            idTeam = 1;
        } else if (Objects.equals(team, "Вулверхэмптон")){
            idTeam = 13;
        } else if (Objects.equals(team, "Брайтон")){
            idTeam = 8;
        } else if (Objects.equals(team, "Саутгемптон")){
            idTeam = 58;
        } else if (Objects.equals(team, "Лидс")){
            idTeam = 158;
        } else if (Objects.equals(team, "Челси")){
            idTeam = 6;
        } else if (Objects.equals(team, "Кристал Пэлас")){
            idTeam = 12;
        } else if (Objects.equals(team, "Борнмут")){
            idTeam = 16;
        } else if (Objects.equals(team, "Эвертон")){
            idTeam = 15;
        } else if (Objects.equals(team, "Манчестер Сити")){
            idTeam = 2;
        } else if (Objects.equals(team, "Брентфорд")){
            idTeam = 10;
        } else if (Objects.equals(team, "Манчестер Юнайтед")){
            idTeam = 3;
        } else if (Objects.equals(team, "Ньюкасл Юнайтед")){
            idTeam = 5;
        } else if (Objects.equals(team, "Вест Хэм")){
            idTeam = 14;
        } else if (Objects.equals(team, "Ноттингем Форест")){
            idTeam = 17;
        } else if (Objects.equals(team, "Ливерпуль")){
            idTeam = 4;
        } else if (Objects.equals(team, "Астон Вилла")){
            idTeam = 9;
        } else if (Objects.equals(team, "Тоттенхэм")){
            idTeam = 7;
        } else if (Objects.equals(team, "Фулхэм")){
            idTeam = 11;
        } else if (Objects.equals(team, "Лестер")){
            idTeam = 153;
        }
        Optional<team> teamM = teamRepository.findById(idTeam);
        if(!teamRepository.existsById(idTeam)) {
            throw new RuntimeException("Команда " + team + " не найдена!");
        }
        return teamM.get().getIdTeam();
    }
}
