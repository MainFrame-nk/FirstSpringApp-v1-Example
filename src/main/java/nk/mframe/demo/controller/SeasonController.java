package nk.mframe.demo.controller;

import nk.mframe.demo.dao.LeagueRepository;
import nk.mframe.demo.dao.SeasonRepository;
import nk.mframe.demo.dao.TeamRepository;
import nk.mframe.demo.model.league;
import nk.mframe.demo.model.season_table;
import nk.mframe.demo.model.team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Controller
public class SeasonController {

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @GetMapping("/season")
    public String seasonMain(Model model) {
        Iterable<season_table> season = seasonRepository.findAll();
        model.addAttribute("season", season);
        return "season-index";
    }

    @GetMapping("/season/add")
    public String seasonAdd(Model model) {
        Iterable<league> league = leagueRepository.findAll();
        model.addAttribute("league", league);
        Iterable<team> teams = teamRepository.findAll();
        model.addAttribute("team", teams);
        return "season-add";
    }

    @PostMapping("/season/add")
    public String seasonAdd(@RequestParam Integer league_season, @RequestParam String name_season, @RequestParam Integer first_place, @RequestParam Integer second_place, @RequestParam Integer third_place, @RequestParam Integer fouth_place, @RequestParam Integer fifth_place, @RequestParam Integer sixth_place, @RequestParam Integer seventh_place, @RequestParam Integer eighth_place, @RequestParam Integer ninth_place, @RequestParam Integer tenth_place, @RequestParam Integer eleventh_place, @RequestParam Integer twelfth_place, @RequestParam Integer thirteenth_place, @RequestParam Integer fourteenth_place, @RequestParam Integer fifteenth_place, @RequestParam Integer sixteenth_place, @RequestParam Integer seventeenth_place, @RequestParam Integer eighteenth_place, @RequestParam Integer nineteenth_place, @RequestParam Integer twentieth_place, Model model) {
        season_table season = new season_table(league_season, name_season, first_place, second_place, third_place, fouth_place, fifth_place, sixth_place, seventh_place, eighth_place, ninth_place, tenth_place, eleventh_place
                , twelfth_place, thirteenth_place, fourteenth_place, fifteenth_place, sixteenth_place, seventeenth_place, eighteenth_place, nineteenth_place, twentieth_place);
        seasonRepository.save(season);
        return "redirect:/season";
    }

    @GetMapping("/season/{id}")
    public String seasonDetails(@PathVariable(value = "id") int idSeason, Model model) {
        if(!seasonRepository.existsById(idSeason)) {
            return "redirect:/season";
        }

        Optional<season_table> season = seasonRepository.findById(idSeason);
        ArrayList<season_table> res = new ArrayList<>();
        season.ifPresent(res::add);
        model.addAttribute("season", res);

        Optional<team> team1 = teamRepository.findById(season.get().getFirstPlace());
        Optional<team> team2 = teamRepository.findById(season.get().getSecondPlace());
        Optional<team> team3 = teamRepository.findById(season.get().getThirdPlace());
        Optional<team> team4 = teamRepository.findById(season.get().getFouthPlace());
        Optional<team> team5 = teamRepository.findById(season.get().getFifthPlace());
        Optional<team> team6 = teamRepository.findById(season.get().getSixthPlace());
        Optional<team> team7 = teamRepository.findById(season.get().getSeventhPlace());
        Optional<team> team8 = teamRepository.findById(season.get().getEighthPlace());
        Optional<team> team9 = teamRepository.findById(season.get().getNinthPlace());
        Optional<team> team10 = teamRepository.findById(season.get().getTenthPlace());
        Optional<team> team11 = teamRepository.findById(season.get().getEleventhPlace());
        Optional<team> team12 = teamRepository.findById(season.get().getTwelfthPlace());
        Optional<team> team13 = teamRepository.findById(season.get().getThirteenthPlace());
        Optional<team> team14 = teamRepository.findById(season.get().getFourteenthPlace());
        Optional<team> team15 = teamRepository.findById(season.get().getFifteenthPlace());
        Optional<team> team16 = teamRepository.findById(season.get().getSixteenthPlace());
        Optional<team> team17 = teamRepository.findById(season.get().getSeventeenthPlace());
        Optional<team> team18 = teamRepository.findById(season.get().getEighteenthPlace());
        Optional<team> team19 = teamRepository.findById(season.get().getNineteenthPlace());
        Optional<team> team20 = teamRepository.findById(season.get().getTwentiethPlace());

        ArrayList<team> tm1 = new ArrayList<>();
        ArrayList<team> tm2 = new ArrayList<>();
        ArrayList<team> tm3 = new ArrayList<>();
        ArrayList<team> tm4 = new ArrayList<>();
        ArrayList<team> tm5 = new ArrayList<>();
        ArrayList<team> tm6 = new ArrayList<>();
        ArrayList<team> tm7 = new ArrayList<>();
        ArrayList<team> tm8 = new ArrayList<>();
        ArrayList<team> tm9 = new ArrayList<>();
        ArrayList<team> tm10 = new ArrayList<>();
        ArrayList<team> tm11 = new ArrayList<>();
        ArrayList<team> tm12 = new ArrayList<>();
        ArrayList<team> tm13 = new ArrayList<>();
        ArrayList<team> tm14 = new ArrayList<>();
        ArrayList<team> tm15 = new ArrayList<>();
        ArrayList<team> tm16 = new ArrayList<>();
        ArrayList<team> tm17 = new ArrayList<>();
        ArrayList<team> tm18 = new ArrayList<>();
        ArrayList<team> tm19 = new ArrayList<>();
        ArrayList<team> tm20 = new ArrayList<>();

        team1.ifPresent(tm1::add);
        team2.ifPresent(tm2::add);
        team3.ifPresent(tm3::add);
        team4.ifPresent(tm4::add);
        team5.ifPresent(tm5::add);
        team6.ifPresent(tm6::add);
        team7.ifPresent(tm7::add);
        team8.ifPresent(tm8::add);
        team9.ifPresent(tm9::add);
        team10.ifPresent(tm10::add);
        team11.ifPresent(tm11::add);
        team12.ifPresent(tm12::add);
        team13.ifPresent(tm13::add);
        team14.ifPresent(tm14::add);
        team15.ifPresent(tm15::add);
        team16.ifPresent(tm16::add);
        team17.ifPresent(tm17::add);
        team18.ifPresent(tm18::add);
        team19.ifPresent(tm19::add);
        team20.ifPresent(tm20::add);

        model.addAttribute("team1", tm1);
        model.addAttribute("team2", tm2);
        model.addAttribute("team3", tm3);
        model.addAttribute("team4", tm4);
        model.addAttribute("team5", tm5);
        model.addAttribute("team6", tm6);
        model.addAttribute("team7", tm7);
        model.addAttribute("team8", tm8);
        model.addAttribute("team9", tm9);
        model.addAttribute("team10", tm10);
        model.addAttribute("team11", tm11);
        model.addAttribute("team12", tm12);
        model.addAttribute("team13", tm13);
        model.addAttribute("team14", tm14);
        model.addAttribute("team15", tm15);
        model.addAttribute("team16", tm16);
        model.addAttribute("team17", tm17);
        model.addAttribute("team18", tm18);
        model.addAttribute("team19", tm19);
        model.addAttribute("team20", tm20);
        return "season-details";
    }

    @GetMapping("/season/{id}/edit")
    public String seasonEdit(@PathVariable(value = "id") int idSeason, Model model) {
        if(!seasonRepository.existsById(idSeason)) {
            return "redirect:/season";
        }

        Optional<season_table> season = seasonRepository.findById(idSeason);
        ArrayList<season_table> res = new ArrayList<>();
        season.ifPresent(res::add);
        model.addAttribute("season", res);

        Optional<team> team1 = teamRepository.findById(season.get().getFirstPlace());
        Optional<team> team2 = teamRepository.findById(season.get().getSecondPlace());
        Optional<team> team3 = teamRepository.findById(season.get().getThirdPlace());
        Optional<team> team4 = teamRepository.findById(season.get().getFouthPlace());
        Optional<team> team5 = teamRepository.findById(season.get().getFifthPlace());
        Optional<team> team6 = teamRepository.findById(season.get().getSixthPlace());
        Optional<team> team7 = teamRepository.findById(season.get().getSeventhPlace());
        Optional<team> team8 = teamRepository.findById(season.get().getEighthPlace());
        Optional<team> team9 = teamRepository.findById(season.get().getNinthPlace());
        Optional<team> team10 = teamRepository.findById(season.get().getTenthPlace());
        Optional<team> team11 = teamRepository.findById(season.get().getEleventhPlace());
        Optional<team> team12 = teamRepository.findById(season.get().getTwelfthPlace());
        Optional<team> team13 = teamRepository.findById(season.get().getThirteenthPlace());
        Optional<team> team14 = teamRepository.findById(season.get().getFourteenthPlace());
        Optional<team> team15 = teamRepository.findById(season.get().getFifteenthPlace());
        Optional<team> team16 = teamRepository.findById(season.get().getSixteenthPlace());
        Optional<team> team17 = teamRepository.findById(season.get().getSeventeenthPlace());
        Optional<team> team18 = teamRepository.findById(season.get().getEighteenthPlace());
        Optional<team> team19 = teamRepository.findById(season.get().getNineteenthPlace());
        Optional<team> team20 = teamRepository.findById(season.get().getTwentiethPlace());

        ArrayList<team> tm1 = new ArrayList<>();
        ArrayList<team> tm2 = new ArrayList<>();
        ArrayList<team> tm3 = new ArrayList<>();
        ArrayList<team> tm4 = new ArrayList<>();
        ArrayList<team> tm5 = new ArrayList<>();
        ArrayList<team> tm6 = new ArrayList<>();
        ArrayList<team> tm7 = new ArrayList<>();
        ArrayList<team> tm8 = new ArrayList<>();
        ArrayList<team> tm9 = new ArrayList<>();
        ArrayList<team> tm10 = new ArrayList<>();
        ArrayList<team> tm11 = new ArrayList<>();
        ArrayList<team> tm12 = new ArrayList<>();
        ArrayList<team> tm13 = new ArrayList<>();
        ArrayList<team> tm14 = new ArrayList<>();
        ArrayList<team> tm15 = new ArrayList<>();
        ArrayList<team> tm16 = new ArrayList<>();
        ArrayList<team> tm17 = new ArrayList<>();
        ArrayList<team> tm18 = new ArrayList<>();
        ArrayList<team> tm19 = new ArrayList<>();
        ArrayList<team> tm20 = new ArrayList<>();

        team1.ifPresent(tm1::add);
        team2.ifPresent(tm2::add);
        team3.ifPresent(tm3::add);
        team4.ifPresent(tm4::add);
        team5.ifPresent(tm5::add);
        team6.ifPresent(tm6::add);
        team7.ifPresent(tm7::add);
        team8.ifPresent(tm8::add);
        team9.ifPresent(tm9::add);
        team10.ifPresent(tm10::add);
        team11.ifPresent(tm11::add);
        team12.ifPresent(tm12::add);
        team13.ifPresent(tm13::add);
        team14.ifPresent(tm14::add);
        team15.ifPresent(tm15::add);
        team16.ifPresent(tm16::add);
        team17.ifPresent(tm17::add);
        team18.ifPresent(tm18::add);
        team19.ifPresent(tm19::add);
        team20.ifPresent(tm20::add);

        model.addAttribute("team1", tm1);
        model.addAttribute("team2", tm2);
        model.addAttribute("team3", tm3);
        model.addAttribute("team4", tm4);
        model.addAttribute("team5", tm5);
        model.addAttribute("team6", tm6);
        model.addAttribute("team7", tm7);
        model.addAttribute("team8", tm8);
        model.addAttribute("team9", tm9);
        model.addAttribute("team10", tm10);
        model.addAttribute("team11", tm11);
        model.addAttribute("team12", tm12);
        model.addAttribute("team13", tm13);
        model.addAttribute("team14", tm14);
        model.addAttribute("team15", tm15);
        model.addAttribute("team16", tm16);
        model.addAttribute("team17", tm17);
        model.addAttribute("team18", tm18);
        model.addAttribute("team19", tm19);
        model.addAttribute("team20", tm20);
        return "season-edit";
    }

    @PostMapping("/season/{id}/edit")
    public String seasonUpdate(@PathVariable(value = "id") int idSeason, @RequestParam Integer score_first_place, @RequestParam Integer score_second_place, @RequestParam Integer score_third_place, @RequestParam Integer score_fouth_place, @RequestParam Integer score_fifth_place, @RequestParam Integer score_sixth_place, @RequestParam Integer score_seventh_place, @RequestParam Integer score_eighth_place
            , @RequestParam Integer score_ninth_place, @RequestParam Integer score_tenth_place, @RequestParam Integer score_eleventh_place, @RequestParam Integer score_twelfth_place, @RequestParam Integer score_thirteenth_place, @RequestParam Integer score_fourteenth_place, @RequestParam Integer score_fifteenth_place, @RequestParam Integer score_sixteenth_place, @RequestParam Integer score_seventeenth_place
            , @RequestParam Integer score_eighteenth_place, @RequestParam Integer score_nineteenth_place, @RequestParam Integer score_twentieth_place, @RequestParam Integer form_first_place, @RequestParam Integer form_second_place, @RequestParam Integer form_third_place, @RequestParam Integer form_fouth_place, @RequestParam Integer form_fifth_place, @RequestParam Integer form_sixth_place, @RequestParam Integer form_seventh_place
            , @RequestParam Integer form_eighth_place, @RequestParam Integer form_ninth_place, @RequestParam Integer form_tenth_place, @RequestParam Integer form_eleventh_place, @RequestParam Integer form_twelfth_place, @RequestParam Integer form_thirteenth_place, @RequestParam Integer form_fourteenth_place, @RequestParam Integer form_fifteenth_place, @RequestParam Integer form_sixteenth_place, @RequestParam Integer form_seventeenth_place
            , @RequestParam Integer form_eighteenth_place, @RequestParam Integer form_nineteenth_place, @RequestParam Integer form_twentieth_place, @RequestParam Integer level_first_place, @RequestParam Integer level_second_place, @RequestParam Integer level_third_place, @RequestParam Integer level_fouth_place, @RequestParam Integer level_fifth_place, @RequestParam Integer level_sixth_place, @RequestParam Integer level_seventh_place
            , @RequestParam Integer level_eighth_place, @RequestParam Integer level_ninth_place, @RequestParam Integer level_tenth_place, @RequestParam Integer level_eleventh_place, @RequestParam Integer level_twelfth_place, @RequestParam Integer level_thirteenth_place, @RequestParam Integer level_fourteenth_place, @RequestParam Integer level_fifteenth_place, @RequestParam Integer level_sixteenth_place, @RequestParam Integer level_seventeenth_place
            , @RequestParam Integer level_eighteenth_place, @RequestParam Integer level_nineteenth_place, @RequestParam Integer level_twentieth_place, Model model) {
        season_table season = seasonRepository.findById(idSeason).orElseThrow(RuntimeException::new);
        season.setScoreFirstPlace(score_first_place);
        season.setScoreSecondPlace(score_second_place);
        season.setScoreThirdPlace(score_third_place);
        season.setScoreFouthPlace(score_fouth_place);
        season.setScoreFifthPlace(score_fifth_place);
        season.setScoreSixthPlace(score_sixth_place);
        season.setScoreSeventhPlace(score_seventh_place);
        season.setScoreEighthPlace(score_eighth_place);
        season.setScoreNinthPlace(score_ninth_place);
        season.setScoreTenthPlace(score_tenth_place);
        season.setScoreEleventhPlace(score_eleventh_place);
        season.setScoreTwelfthPlace(score_twelfth_place);
        season.setScoreThirteenthPlace(score_thirteenth_place);
        season.setScoreFourteenthPlace(score_fourteenth_place);
        season.setScoreFifteenthPlace(score_fifteenth_place);
        season.setScoreSixteenthPlace(score_sixteenth_place);
        season.setScoreSeventeenthPlace(score_seventeenth_place);
        season.setScoreEighteenthPlace(score_eighteenth_place);
        season.setScoreNineteenthPlace(score_nineteenth_place);
        season.setScoreTwentiethPlace(score_twentieth_place);
        season.setFormFirstPlace(form_first_place);
        season.setFormSecondPlace(form_second_place);
        season.setFormThirdPlace(form_third_place);
        season.setFormFouthPlace(form_fouth_place);
        season.setFormFifthPlace(form_fifth_place);
        season.setFormSixthPlace(form_sixth_place);
        season.setFormSeventhPlace(form_seventh_place);
        season.setFormEighthPlace(form_eighth_place);
        season.setFormNinthPlace(form_ninth_place);
        season.setFormTenthPlace(form_tenth_place);
        season.setFormEleventhPlace(form_eleventh_place);
        season.setFormTwelfthPlace(form_twelfth_place);
        season.setFormThirteenthPlace(form_thirteenth_place);
        season.setFormFourteenthPlace(form_fourteenth_place);
        season.setFormFifteenthPlace(form_fifteenth_place);
        season.setFormSixteenthPlace(form_sixteenth_place);
        season.setFormSeventeenthPlace(form_seventeenth_place);
        season.setFormEighteenthPlace(form_eighteenth_place);
        season.setFormNineteenthPlace(form_nineteenth_place);
        season.setFormTwentiethPlace(form_twentieth_place);
        season.setLevelFirstPlace(level_first_place);
        season.setLevelSecondPlace(level_second_place);
        season.setLevelThirdPlace(level_third_place);
        season.setLevelFouthPlace(level_fouth_place);
        season.setLevelFifthPlace(level_fifth_place);
        season.setLevelSixthPlace(level_sixth_place);
        season.setLevelSeventhPlace(level_seventh_place);
        season.setLevelEighthPlace(level_eighth_place);
        season.setLevelNinthPlace(level_ninth_place);
        season.setLevelTenthPlace(level_tenth_place);
        season.setLevelEleventhPlace(level_eleventh_place);
        season.setLevelTwelfthPlace(level_twelfth_place);
        season.setLevelThirteenthPlace(level_thirteenth_place);
        season.setLevelFourteenthPlace(level_fourteenth_place);
        season.setLevelFifteenthPlace(level_fifteenth_place);
        season.setLevelSixteenthPlace(level_sixteenth_place);
        season.setLevelSeventeenthPlace(level_seventeenth_place);
        season.setLevelEighteenthPlace(level_eighteenth_place);
        season.setLevelNineteenthPlace(level_nineteenth_place);
        season.setLevelTwentiethPlace(level_twentieth_place);
        seasonRepository.save(season);
        return "redirect:/season";
    }

    @PostMapping("/season/{id}/delete")
    public String seasonDelete(@PathVariable(value = "id") int idSeason, Model model) {
        season_table season = seasonRepository.findById(idSeason).orElseThrow(RuntimeException::new);
        seasonRepository.delete(season);
        return "redirect:/season";
    }

    @GetMapping("/season/{countryLeague}/{nameLeague}")
    public String seasonOnline(@PathVariable(value = "countryLeague") String countryLeague, @PathVariable(value = "nameLeague") String nameLeague, Model model) {
        Iterable<league> leagues = leagueRepository.findAll();
        Iterable<season_table> seasons = seasonRepository.findAll();
        Iterable<team> teams = teamRepository.findAll();
        ArrayList<season_table> leagueSeasons = new ArrayList<>();
        ArrayList<season_table> lastSeason = new ArrayList<>();
        ArrayList<team> teamsSeason = new ArrayList<>();
        for (league lg : leagues) {
            if (Objects.equals(lg.getCountryLeague(), countryLeague) && Objects.equals(lg.getNameLeague(), nameLeague)) { // Нужно переопределение!
                Optional<league> league = leagueRepository.findById(lg.getIdLeague());
                model.addAttribute("league", league);

                for (season_table calcsns : seasons) {
                    if (Objects.equals(calcsns.getIdLeague(), league.get().getIdLeague()) && !Objects.equals(calcsns.getNameSeason(), "2023\\24")) { // Нужна константа на определение нынешнего сезона
                        Optional<season_table> st = seasonRepository.findById(calcsns.getIdSeason());
                        st.ifPresent(leagueSeasons::add);
                        System.out.println(calcsns.getNameSeason()+ "2023\24 сезон? = " + !Objects.equals(calcsns.getNameSeason(), "2023\\24"));
                    } else if (Objects.equals(calcsns.getNameSeason(), "2023\\24")) {
                        Optional<season_table> ls = seasonRepository.findById(calcsns.getIdSeason());
                        ls.ifPresent(lastSeason::add);
                        for (team ts : teams) {
                            if (ts.getIdTeam() == ls.get().getFirstPlace() ) {

                            }
                        }
                    }
                }
                break;
            }
        }

        double pos1 = 0, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9, pos10, pos11, pos12, pos13, pos14, pos15, pos16, pos17, pos18, pos19, pos20;
        double count1 = 0, count2, count3, count4, count5, count6, count7, count8, count9, count10, count11, count12, count13, count14, count15, count16, count17, count18, count19, count20;
        double score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, score11, score12, score13, score14, score15, score16, score17, score18, score19, score20;
        double id1 = lastSeason.get(0).getFirstPlace(),
                id2,
                id3,
                id4,
                id5,
                id6,
                id7,
                id8,
                id9,
                id10,
                id11,
                id12,
                id13,
                id14,
                id15,
                id16,
                id17,
                id18,
                id19,
                id20;
        for (season_table infoSeason : leagueSeasons) {
            if (infoSeason.getFirstPlace() == id1) {
                pos1 += 1;
                count1++;
            } else if (infoSeason.getSecondPlace() == id1) {
                pos1 += 2;
                count1++;
            } else if (infoSeason.getThirdPlace() == id1) {
                pos1 += 3;
                count1++;
            } else if (infoSeason.getFouthPlace() == id1) {
                pos1 += 4;
                count1++;
            } else if (infoSeason.getFifthPlace() == id1) {
                pos1 += 5;
                count1++;
            } else if (infoSeason.getSixthPlace() == id1) {
                pos1 += 6;
                count1++;
            } else if (infoSeason.getSeventhPlace() == id1) {
                pos1 += 7;
                count1++;
            } else if (infoSeason.getEighthPlace() == id1) {
                pos1 += 8;
                count1++;
            } else if (infoSeason.getNinthPlace() == id1) {
                pos1 += 9;
                count1++;
            } else if (infoSeason.getTenthPlace() == id1) {
                pos1 += 10;
                count1++;
            } else if (infoSeason.getEleventhPlace() == id1) {
                pos1 += 11;
                count1++;
            } else if (infoSeason.getTwelfthPlace() == id1) {
                pos1 += 12;
                count1++;
            } else if (infoSeason.getThirteenthPlace() == id1) {
                pos1 += 13;
                count1++;
            } else if (infoSeason.getFourteenthPlace() == id1) {
                pos1 += 14;
                count1++;
            } else if (infoSeason.getFifteenthPlace() == id1) {
                pos1 += 15;
                count1++;
            } else if (infoSeason.getSixteenthPlace() == id1) {
                pos1 += 16;
                count1++;
            } else if (infoSeason.getSeventeenthPlace() == id1) {
                pos1 += 17;
                count1++;
            } else if (infoSeason.getEighteenthPlace() == id1) {
                pos1 += 18;
                count1++;
            } else if (infoSeason.getNineteenthPlace() == id1) {
                pos1 += 19;
                count1++;
            } else if (infoSeason.getTwentiethPlace() == id1) {
                pos1 += 20;
                count1++;
            }

        }

        return "season-calculate";
    }

    @PostMapping("/season/{countryLeague}/{nameLeague}")
    public String seasonUpdate(@PathVariable(value = "id") int idTeam, @RequestParam String name_team, @RequestParam Integer team_league, @RequestParam Byte level_team, @RequestParam Byte form_team, Model model) {

        //team team = teamRepository.findById(idTeam).orElseThrow(RuntimeException::new);

        //team.setFormTeam(form_team);
        //teamRepository.save(team);
        return "redirect:/admin";
    }
}
