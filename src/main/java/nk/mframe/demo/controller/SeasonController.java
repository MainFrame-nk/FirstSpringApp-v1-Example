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
        if (countryLeague == null) {
            return "redirect:/admin";
        }
        Iterable<league> leagues = leagueRepository.findAll();
        Iterable<season_table> seasons = seasonRepository.findAll();
        Iterable<team> teams = teamRepository.findAll();
        ArrayList<season_table> leagueSeasons = new ArrayList<>();
        ArrayList<season_table> lastSeason = new ArrayList<>();
        ArrayList<league> leag = new ArrayList<>();
        int idLastSeason = 0;
        for (league lg : leagues) {
            if (Objects.equals(lg.getCountryLeague(), countryLeague) && Objects.equals(lg.getNameLeague(), nameLeague)) { // Нужно переопределение!
                Optional<league> league = leagueRepository.findById(lg.getIdLeague());
                league.ifPresent(leag::add);
                model.addAttribute("league", leag);

                for (season_table calcsns : seasons) {
                    if (Objects.equals(calcsns.getIdLeague(), league.get().getIdLeague()) && !Objects.equals(calcsns.getNameSeason(), "2023\\24")) { // Нужна константа на определение нынешнего сезона
                        Optional<season_table> st = seasonRepository.findById(calcsns.getIdSeason());
                        st.ifPresent(leagueSeasons::add);
                    } else if (Objects.equals(calcsns.getNameSeason(), "2023\\24")) {
                        Optional<season_table> ls = seasonRepository.findById(calcsns.getIdSeason());
                        idLastSeason = calcsns.getIdSeason();
                        ls.ifPresent(lastSeason::add);
                    }
                }
                break;
            }
        }
        if(!seasonRepository.existsById(idLastSeason)) {
            return "redirect:/admin";
        }

        Optional<season_table> lastSeas = seasonRepository.findById(idLastSeason);

        Optional<team> team1 = teamRepository.findById(lastSeas.get().getFirstPlace());
        Optional<team> team2 = teamRepository.findById(lastSeas.get().getSecondPlace());
        Optional<team> team3 = teamRepository.findById(lastSeas.get().getThirdPlace());
        Optional<team> team4 = teamRepository.findById(lastSeas.get().getFouthPlace());
        Optional<team> team5 = teamRepository.findById(lastSeas.get().getFifthPlace());
        Optional<team> team6 = teamRepository.findById(lastSeas.get().getSixthPlace());
        Optional<team> team7 = teamRepository.findById(lastSeas.get().getSeventhPlace());
        Optional<team> team8 = teamRepository.findById(lastSeas.get().getEighthPlace());
        Optional<team> team9 = teamRepository.findById(lastSeas.get().getNinthPlace());
        Optional<team> team10 = teamRepository.findById(lastSeas.get().getTenthPlace());
        Optional<team> team11 = teamRepository.findById(lastSeas.get().getEleventhPlace());
        Optional<team> team12 = teamRepository.findById(lastSeas.get().getTwelfthPlace());
        Optional<team> team13 = teamRepository.findById(lastSeas.get().getThirteenthPlace());
        Optional<team> team14 = teamRepository.findById(lastSeas.get().getFourteenthPlace());
        Optional<team> team15 = teamRepository.findById(lastSeas.get().getFifteenthPlace());
        Optional<team> team16 = teamRepository.findById(lastSeas.get().getSixteenthPlace());
        Optional<team> team17 = teamRepository.findById(lastSeas.get().getSeventeenthPlace());
        Optional<team> team18 = teamRepository.findById(lastSeas.get().getEighteenthPlace());
        Optional<team> team19 = teamRepository.findById(lastSeas.get().getNineteenthPlace());
        Optional<team> team20 = teamRepository.findById(lastSeas.get().getTwentiethPlace());

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

        double pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0, pos5 = 0, pos6 = 0, pos7 = 0, pos8 = 0, pos9 = 0, pos10 = 0, pos11 = 0, pos12 = 0, pos13 = 0, pos14 = 0, pos15 = 0, pos16 = 0, pos17 = 0, pos18 = 0, pos19 = 0, pos20 = 0;
        double count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0, count10 = 0, count11 = 0, count12 = 0, count13 = 0, count14 = 0, count15 = 0, count16 = 0, count17 = 0, count18 = 0, count19 = 0, count20 = 0;
        double score1 = 0, score2 = 0, score3 = 0, score4 = 0, score5 = 0, score6 = 0, score7 = 0, score8 = 0, score9 = 0, score10 = 0, score11 = 0, score12 = 0, score13 = 0, score14 = 0, score15 = 0, score16 = 0, score17 = 0, score18 = 0, score19 = 0, score20 = 0;
        double id1 = lastSeason.get(0).getFirstPlace(),
                id2 = lastSeason.get(0).getSecondPlace(),
                id3 = lastSeason.get(0).getThirdPlace(),
                id4 = lastSeason.get(0).getFouthPlace(),
                id5 = lastSeason.get(0).getFifthPlace(),
                id6 = lastSeason.get(0).getSixthPlace(),
                id7 = lastSeason.get(0).getSeventhPlace(),
                id8 = lastSeason.get(0).getEighthPlace(),
                id9 = lastSeason.get(0).getNinthPlace(),
                id10 = lastSeason.get(0).getTenthPlace(),
                id11 = lastSeason.get(0).getEleventhPlace(),
                id12 = lastSeason.get(0).getTwelfthPlace(),
                id13 = lastSeason.get(0).getThirteenthPlace(),
                id14 = lastSeason.get(0).getFourteenthPlace(),
                id15 = lastSeason.get(0).getFifteenthPlace(),
                id16 = lastSeason.get(0).getSixteenthPlace(),
                id17 = lastSeason.get(0).getSeventeenthPlace(),
                id18 = lastSeason.get(0).getEighteenthPlace(),
                id19 = lastSeason.get(0).getNineteenthPlace(),
                id20 = lastSeason.get(0).getTwentiethPlace();
        for (season_table infoSeason : leagueSeasons) {
            if (infoSeason.getFirstPlace() == id1) {
                pos1 += 1;
                score1 += infoSeason.getScoreFirstPlace();
                count1++;
            } else if (infoSeason.getSecondPlace() == id1) {
                pos1 += 2;
                score1 += infoSeason.getScoreSecondPlace();
                count1++;
            } else if (infoSeason.getThirdPlace() == id1) {
                pos1 += 3;
                score1 += infoSeason.getScoreThirdPlace();
                count1++;
            } else if (infoSeason.getFouthPlace() == id1) {
                pos1 += 4;
                score1 += infoSeason.getScoreFouthPlace();
                count1++;
            } else if (infoSeason.getFifthPlace() == id1) {
                pos1 += 5;
                score1 += infoSeason.getScoreFifthPlace();
                count1++;
            } else if (infoSeason.getSixthPlace() == id1) {
                pos1 += 6;
                score1 += infoSeason.getScoreSixthPlace();
                count1++;
            } else if (infoSeason.getSeventhPlace() == id1) {
                pos1 += 7;
                score1 += infoSeason.getScoreSeventhPlace();
                count1++;
            } else if (infoSeason.getEighthPlace() == id1) {
                pos1 += 8;
                score1 += infoSeason.getScoreEighthPlace();
                count1++;
            } else if (infoSeason.getNinthPlace() == id1) {
                pos1 += 9;
                score1 += infoSeason.getScoreNinthPlace();
                count1++;
            } else if (infoSeason.getTenthPlace() == id1) {
                pos1 += 10;
                score1 += infoSeason.getScoreTenthPlace();
                count1++;
            } else if (infoSeason.getEleventhPlace() == id1) {
                pos1 += 11;
                score1 += infoSeason.getScoreEleventhPlace();
                count1++;
            } else if (infoSeason.getTwelfthPlace() == id1) {
                pos1 += 12;
                score1 += infoSeason.getScoreTwelfthPlace();
                count1++;
            } else if (infoSeason.getThirteenthPlace() == id1) {
                pos1 += 13;
                score1 += infoSeason.getScoreThirteenthPlace();
                count1++;
            } else if (infoSeason.getFourteenthPlace() == id1) {
                pos1 += 14;
                score1 += infoSeason.getScoreFourteenthPlace();
                count1++;
            } else if (infoSeason.getFifteenthPlace() == id1) {
                pos1 += 15;
                score1 += infoSeason.getScoreFifteenthPlace();
                count1++;
            } else if (infoSeason.getSixteenthPlace() == id1) {
                pos1 += 16;
                score1 += infoSeason.getScoreSixteenthPlace();
                count1++;
            } else if (infoSeason.getSeventeenthPlace() == id1) {
                pos1 += 17;
                score1 += infoSeason.getScoreSeventeenthPlace();
                count1++;
            } else if (infoSeason.getEighteenthPlace() == id1) {
                pos1 += 18;
                score1 += infoSeason.getScoreEighteenthPlace();
                count1++;
            } else if (infoSeason.getNineteenthPlace() == id1) {
                pos1 += 19;
                score1 += infoSeason.getScoreNineteenthPlace();
                count1++;
            } else if (infoSeason.getTwentiethPlace() == id1) {
                pos1 += 20;
                score1 += infoSeason.getScoreTwentiethPlace();
                count1++;
            }
            if (infoSeason.getFirstPlace() == id2) {
                pos2 += 1;
                score2 += infoSeason.getScoreFirstPlace();
                count2++;
            } else if (infoSeason.getSecondPlace() == id2) {
                pos2 += 2;
                score2 += infoSeason.getScoreSecondPlace();
                count2++;
            } else if (infoSeason.getThirdPlace() == id2) {
                pos2 += 3;
                score2 += infoSeason.getScoreThirdPlace();
                count2++;
            } else if (infoSeason.getFouthPlace() == id2) {
                pos2 += 4;
                score2 += infoSeason.getScoreFouthPlace();
                count2++;
            } else if (infoSeason.getFifthPlace() == id2) {
                pos2 += 5;
                score2 += infoSeason.getScoreFifthPlace();
                count2++;
            } else if (infoSeason.getSixthPlace() == id2) {
                pos2 += 6;
                score2 += infoSeason.getScoreSixthPlace();
                count2++;
            } else if (infoSeason.getSeventhPlace() == id2) {
                pos2 += 7;
                score2 += infoSeason.getScoreSeventhPlace();
                count2++;
            } else if (infoSeason.getEighthPlace() == id2) {
                pos2 += 8;
                score2 += infoSeason.getScoreEighthPlace();
                count2++;
            } else if (infoSeason.getNinthPlace() == id2) {
                pos2 += 9;
                score2 += infoSeason.getScoreNinthPlace();
                count2++;
            } else if (infoSeason.getTenthPlace() == id2) {
                pos2 += 10;
                score2 += infoSeason.getScoreTenthPlace();
                count2++;
            } else if (infoSeason.getEleventhPlace() == id2) {
                pos2 += 11;
                score2 += infoSeason.getScoreEleventhPlace();
                count2++;
            } else if (infoSeason.getTwelfthPlace() == id2) {
                pos2 += 12;
                score2 += infoSeason.getScoreTwelfthPlace();
                count2++;
            } else if (infoSeason.getThirteenthPlace() == id2) {
                pos2 += 13;
                score2 += infoSeason.getScoreThirteenthPlace();
                count2++;
            } else if (infoSeason.getFourteenthPlace() == id2) {
                pos2 += 14;
                score2 += infoSeason.getScoreFourteenthPlace();
                count2++;
            } else if (infoSeason.getFifteenthPlace() == id2) {
                pos2 += 15;
                score2 += infoSeason.getScoreFifteenthPlace();
                count2++;
            } else if (infoSeason.getSixteenthPlace() == id2) {
                pos2 += 16;
                score2 += infoSeason.getScoreSixteenthPlace();
                count2++;
            } else if (infoSeason.getSeventeenthPlace() == id2) {
                pos2 += 17;
                score2 += infoSeason.getScoreSeventeenthPlace();
                count2++;
            } else if (infoSeason.getEighteenthPlace() == id2) {
                pos2 += 18;
                score2 += infoSeason.getScoreEighteenthPlace();
                count2++;
            } else if (infoSeason.getNineteenthPlace() == id2) {
                pos2 += 19;
                score2 += infoSeason.getScoreNineteenthPlace();
                count2++;
            } else if (infoSeason.getTwentiethPlace() == id2) {
                pos2 += 20;
                score2 += infoSeason.getScoreTwentiethPlace();
                count2++;
            }
            if (infoSeason.getFirstPlace() == id3) {
                pos3 += 1;
                score3 += infoSeason.getScoreFirstPlace();
                count3++;
            } else if (infoSeason.getSecondPlace() == id3) {
                pos3 += 2;
                score3 += infoSeason.getScoreSecondPlace();
                count3++;
            } else if (infoSeason.getThirdPlace() == id3) {
                pos3 += 3;
                score3 += infoSeason.getScoreThirdPlace();
                count3++;
            } else if (infoSeason.getFouthPlace() == id3) {
                pos3 += 4;
                score3 += infoSeason.getScoreFouthPlace();
                count3++;
            } else if (infoSeason.getFifthPlace() == id3) {
                pos3 += 5;
                score3 += infoSeason.getScoreFifthPlace();
                count3++;
            } else if (infoSeason.getSixthPlace() == id3) {
                pos3 += 6;
                score3 += infoSeason.getScoreSixthPlace();
                count3++;
            } else if (infoSeason.getSeventhPlace() == id3) {
                pos3 += 7;
                score3 += infoSeason.getScoreSeventhPlace();
                count3++;
            } else if (infoSeason.getEighthPlace() == id3) {
                pos3 += 8;
                score3 += infoSeason.getScoreEighthPlace();
                count3++;
            } else if (infoSeason.getNinthPlace() == id3) {
                pos3 += 9;
                score3 += infoSeason.getScoreNinthPlace();
                count3++;
            } else if (infoSeason.getTenthPlace() == id3) {
                pos3 += 10;
                score3 += infoSeason.getScoreTenthPlace();
                count3++;
            } else if (infoSeason.getEleventhPlace() == id3) {
                pos3 += 11;
                score3 += infoSeason.getScoreEleventhPlace();
                count3++;
            } else if (infoSeason.getTwelfthPlace() == id3) {
                pos3 += 12;
                score3 += infoSeason.getScoreTwelfthPlace();
                count3++;
            } else if (infoSeason.getThirteenthPlace() == id3) {
                pos3 += 13;
                score3 += infoSeason.getScoreThirteenthPlace();
                count3++;
            } else if (infoSeason.getFourteenthPlace() == id3) {
                pos3 += 14;
                score3 += infoSeason.getScoreFourteenthPlace();
                count3++;
            } else if (infoSeason.getFifteenthPlace() == id3) {
                pos3 += 15;
                score3 += infoSeason.getScoreFifteenthPlace();
                count3++;
            } else if (infoSeason.getSixteenthPlace() == id3) {
                pos3 += 16;
                score3 += infoSeason.getScoreSixteenthPlace();
                count3++;
            } else if (infoSeason.getSeventeenthPlace() == id3) {
                pos3 += 17;
                score3 += infoSeason.getScoreSeventeenthPlace();
                count3++;
            } else if (infoSeason.getEighteenthPlace() == id3) {
                pos3 += 18;
                score3 += infoSeason.getScoreEighteenthPlace();
                count3++;
            } else if (infoSeason.getNineteenthPlace() == id3) {
                pos3 += 19;
                score3 += infoSeason.getScoreNineteenthPlace();
                count3++;
            } else if (infoSeason.getTwentiethPlace() == id3) {
                pos3 += 20;
                score3 += infoSeason.getScoreTwentiethPlace();
                count3++;
            }
            if (infoSeason.getFirstPlace() == id4) {
                pos4 += 1;
                score4 += infoSeason.getScoreFirstPlace();
                count4++;
            } else if (infoSeason.getSecondPlace() == id4) {
                pos4 += 2;
                score4 += infoSeason.getScoreSecondPlace();
                count4++;
            } else if (infoSeason.getThirdPlace() == id4) {
                pos4 += 3;
                score4 += infoSeason.getScoreThirdPlace();
                count4++;
            } else if (infoSeason.getFouthPlace() == id4) {
                pos4 += 4;
                score4 += infoSeason.getScoreFouthPlace();
                count4++;
            } else if (infoSeason.getFifthPlace() == id4) {
                pos4 += 5;
                score4 += infoSeason.getScoreFifthPlace();
                count4++;
            } else if (infoSeason.getSixthPlace() == id4) {
                pos4 += 6;
                score4 += infoSeason.getScoreSixthPlace();
                count4++;
            } else if (infoSeason.getSeventhPlace() == id4) {
                pos4 += 7;
                score4 += infoSeason.getScoreSeventhPlace();
                count4++;
            } else if (infoSeason.getEighthPlace() == id4) {
                pos4 += 8;
                score4 += infoSeason.getScoreEighthPlace();
                count4++;
            } else if (infoSeason.getNinthPlace() == id4) {
                pos4 += 9;
                score4 += infoSeason.getScoreNinthPlace();
                count4++;
            } else if (infoSeason.getTenthPlace() == id4) {
                pos4 += 10;
                score4 += infoSeason.getScoreTenthPlace();
                count4++;
            } else if (infoSeason.getEleventhPlace() == id4) {
                pos4 += 11;
                score4 += infoSeason.getScoreEleventhPlace();
                count4++;
            } else if (infoSeason.getTwelfthPlace() == id4) {
                pos4 += 12;
                score4 += infoSeason.getScoreTwelfthPlace();
                count4++;
            } else if (infoSeason.getThirteenthPlace() == id4) {
                pos4 += 13;
                score4 += infoSeason.getScoreThirteenthPlace();
                count4++;
            } else if (infoSeason.getFourteenthPlace() == id4) {
                pos4 += 14;
                score4 += infoSeason.getScoreFourteenthPlace();
                count4++;
            } else if (infoSeason.getFifteenthPlace() == id4) {
                pos4 += 15;
                score4 += infoSeason.getScoreFifteenthPlace();
                count4++;
            } else if (infoSeason.getSixteenthPlace() == id4) {
                pos4 += 16;
                score4 += infoSeason.getScoreSixteenthPlace();
                count4++;
            } else if (infoSeason.getSeventeenthPlace() == id4) {
                pos4 += 17;
                score4 += infoSeason.getScoreSeventeenthPlace();
                count4++;
            } else if (infoSeason.getEighteenthPlace() == id4) {
                pos4 += 18;
                score4 += infoSeason.getScoreEighteenthPlace();
                count4++;
            } else if (infoSeason.getNineteenthPlace() == id4) {
                pos4 += 19;
                score4 += infoSeason.getScoreNineteenthPlace();
                count4++;
            } else if (infoSeason.getTwentiethPlace() == id4) {
                pos4 += 20;
                score4 += infoSeason.getScoreTwentiethPlace();
                count4++;
            }
            if (infoSeason.getFirstPlace() == id5) {
                pos5 += 1;
                score5 += infoSeason.getScoreFirstPlace();
                count5++;
            } else if (infoSeason.getSecondPlace() == id5) {
                pos5 += 2;
                score5 += infoSeason.getScoreSecondPlace();
                count5++;
            } else if (infoSeason.getThirdPlace() == id5) {
                pos5 += 3;
                score5 += infoSeason.getScoreThirdPlace();
                count5++;
            } else if (infoSeason.getFouthPlace() == id5) {
                pos5 += 4;
                score5 += infoSeason.getScoreFouthPlace();
                count5++;
            } else if (infoSeason.getFifthPlace() == id5) {
                pos5 += 5;
                score5 += infoSeason.getScoreFifthPlace();
                count5++;
            } else if (infoSeason.getSixthPlace() == id5) {
                pos5 += 6;
                score5 += infoSeason.getScoreSixthPlace();
                count5++;
            } else if (infoSeason.getSeventhPlace() == id5) {
                pos5 += 7;
                score5 += infoSeason.getScoreSeventhPlace();
                count5++;
            } else if (infoSeason.getEighthPlace() == id5) {
                pos5 += 8;
                score5 += infoSeason.getScoreEighthPlace();
                count5++;
            } else if (infoSeason.getNinthPlace() == id5) {
                pos5 += 9;
                score5 += infoSeason.getScoreNinthPlace();
                count5++;
            } else if (infoSeason.getTenthPlace() == id5) {
                pos5 += 10;
                score5 += infoSeason.getScoreTenthPlace();
                count5++;
            } else if (infoSeason.getEleventhPlace() == id5) {
                pos5 += 11;
                score5 += infoSeason.getScoreEleventhPlace();
                count5++;
            } else if (infoSeason.getTwelfthPlace() == id5) {
                pos5 += 12;
                score5 += infoSeason.getScoreTwelfthPlace();
                count5++;
            } else if (infoSeason.getThirteenthPlace() == id5) {
                pos5 += 13;
                score5 += infoSeason.getScoreThirteenthPlace();
                count5++;
            } else if (infoSeason.getFourteenthPlace() == id5) {
                pos5 += 14;
                score5 += infoSeason.getScoreFourteenthPlace();
                count5++;
            } else if (infoSeason.getFifteenthPlace() == id5) {
                pos5 += 15;
                score5 += infoSeason.getScoreFifteenthPlace();
                count5++;
            } else if (infoSeason.getSixteenthPlace() == id5) {
                pos5 += 16;
                score5 += infoSeason.getScoreSixteenthPlace();
                count5++;
            } else if (infoSeason.getSeventeenthPlace() == id5) {
                pos5 += 17;
                score5 += infoSeason.getScoreSeventeenthPlace();
                count5++;
            } else if (infoSeason.getEighteenthPlace() == id5) {
                pos5 += 18;
                score5 += infoSeason.getScoreEighteenthPlace();
                count5++;
            } else if (infoSeason.getNineteenthPlace() == id5) {
                pos5 += 19;
                score5 += infoSeason.getScoreNineteenthPlace();
                count5++;
            } else if (infoSeason.getTwentiethPlace() == id5) {
                pos5 += 20;
                score5 += infoSeason.getScoreTwentiethPlace();
                count5++;
            }
            if (infoSeason.getFirstPlace() == id6) {
                pos6 += 1;
                score6 += infoSeason.getScoreFirstPlace();
                count6++;
            } else if (infoSeason.getSecondPlace() == id6) {
                pos6 += 2;
                score6 += infoSeason.getScoreSecondPlace();
                count6++;
            } else if (infoSeason.getThirdPlace() == id6) {
                pos6 += 3;
                score6 += infoSeason.getScoreThirdPlace();
                count6++;
            } else if (infoSeason.getFouthPlace() == id6) {
                pos6 += 4;
                score6 += infoSeason.getScoreFouthPlace();
                count6++;
            } else if (infoSeason.getFifthPlace() == id6) {
                pos6 += 5;
                score6 += infoSeason.getScoreFifthPlace();
                count6++;
            } else if (infoSeason.getSixthPlace() == id6) {
                pos6 += 6;
                score6 += infoSeason.getScoreSixthPlace();
                count6++;
            } else if (infoSeason.getSeventhPlace() == id6) {
                pos6 += 7;
                score6 += infoSeason.getScoreSeventhPlace();
                count6++;
            } else if (infoSeason.getEighthPlace() == id6) {
                pos6 += 8;
                score6 += infoSeason.getScoreEighthPlace();
                count6++;
            } else if (infoSeason.getNinthPlace() == id6) {
                pos6 += 9;
                score6 += infoSeason.getScoreNinthPlace();
                count6++;
            } else if (infoSeason.getTenthPlace() == id6) {
                pos6 += 10;
                score6 += infoSeason.getScoreTenthPlace();
                count6++;
            } else if (infoSeason.getEleventhPlace() == id6) {
                pos6 += 11;
                score6 += infoSeason.getScoreEleventhPlace();
                count6++;
            } else if (infoSeason.getTwelfthPlace() == id6) {
                pos6 += 12;
                score6 += infoSeason.getScoreTwelfthPlace();
                count6++;
            } else if (infoSeason.getThirteenthPlace() == id6) {
                pos6 += 13;
                score6 += infoSeason.getScoreThirteenthPlace();
                count6++;
            } else if (infoSeason.getFourteenthPlace() == id6) {
                pos6 += 14;
                score6 += infoSeason.getScoreFourteenthPlace();
                count6++;
            } else if (infoSeason.getFifteenthPlace() == id6) {
                pos6 += 15;
                score6 += infoSeason.getScoreFifteenthPlace();
                count6++;
            } else if (infoSeason.getSixteenthPlace() == id6) {
                pos6 += 16;
                score6 += infoSeason.getScoreSixteenthPlace();
                count6++;
            } else if (infoSeason.getSeventeenthPlace() == id6) {
                pos6 += 17;
                score6 += infoSeason.getScoreSeventeenthPlace();
                count6++;
            } else if (infoSeason.getEighteenthPlace() == id6) {
                pos6 += 18;
                score6 += infoSeason.getScoreEighteenthPlace();
                count6++;
            } else if (infoSeason.getNineteenthPlace() == id6) {
                pos6 += 19;
                score6 += infoSeason.getScoreNineteenthPlace();
                count6++;
            } else if (infoSeason.getTwentiethPlace() == id6) {
                pos6 += 20;
                score6 += infoSeason.getScoreTwentiethPlace();
                count6++;
            }
            if (infoSeason.getFirstPlace() == id7) {
                pos7 += 1;
                score7 += infoSeason.getScoreFirstPlace();
                count7++;
            } else if (infoSeason.getSecondPlace() == id7) {
                pos7 += 2;
                score7 += infoSeason.getScoreSecondPlace();
                count7++;
            } else if (infoSeason.getThirdPlace() == id7) {
                pos7 += 3;
                score7 += infoSeason.getScoreThirdPlace();
                count7++;
            } else if (infoSeason.getFouthPlace() == id7) {
                pos7 += 4;
                score7 += infoSeason.getScoreFouthPlace();
                count7++;
            } else if (infoSeason.getFifthPlace() == id7) {
                pos7 += 5;
                score7 += infoSeason.getScoreFifthPlace();
                count7++;
            } else if (infoSeason.getSixthPlace() == id7) {
                pos7 += 6;
                score7 += infoSeason.getScoreSixthPlace();
                count7++;
            } else if (infoSeason.getSeventhPlace() == id7) {
                pos7 += 7;
                score7 += infoSeason.getScoreSeventhPlace();
                count7++;
            } else if (infoSeason.getEighthPlace() == id7) {
                pos7 += 8;
                score7 += infoSeason.getScoreEighthPlace();
                count7++;
            } else if (infoSeason.getNinthPlace() == id7) {
                pos7 += 9;
                score7 += infoSeason.getScoreNinthPlace();
                count7++;
            } else if (infoSeason.getTenthPlace() == id7) {
                pos7 += 10;
                score7 += infoSeason.getScoreTenthPlace();
                count7++;
            } else if (infoSeason.getEleventhPlace() == id7) {
                pos7 += 11;
                score7 += infoSeason.getScoreEleventhPlace();
                count7++;
            } else if (infoSeason.getTwelfthPlace() == id7) {
                pos7 += 12;
                score7 += infoSeason.getScoreTwelfthPlace();
                count7++;
            } else if (infoSeason.getThirteenthPlace() == id7) {
                pos7 += 13;
                score7 += infoSeason.getScoreThirteenthPlace();
                count7++;
            } else if (infoSeason.getFourteenthPlace() == id7) {
                pos7 += 14;
                score7 += infoSeason.getScoreFourteenthPlace();
                count7++;
            } else if (infoSeason.getFifteenthPlace() == id7) {
                pos7 += 15;
                score7 += infoSeason.getScoreFifteenthPlace();
                count7++;
            } else if (infoSeason.getSixteenthPlace() == id7) {
                pos7 += 16;
                score7 += infoSeason.getScoreSixteenthPlace();
                count7++;
            } else if (infoSeason.getSeventeenthPlace() == id7) {
                pos7 += 17;
                score7 += infoSeason.getScoreSeventeenthPlace();
                count7++;
            } else if (infoSeason.getEighteenthPlace() == id7) {
                pos7 += 18;
                score7 += infoSeason.getScoreEighteenthPlace();
                count7++;
            } else if (infoSeason.getNineteenthPlace() == id7) {
                pos7 += 19;
                score7 += infoSeason.getScoreNineteenthPlace();
                count7++;
            } else if (infoSeason.getTwentiethPlace() == id7) {
                pos7 += 20;
                score7 += infoSeason.getScoreTwentiethPlace();
                count7++;
            }
            if (infoSeason.getFirstPlace() == id8) {
                pos8 += 1;
                score8 += infoSeason.getScoreFirstPlace();
                count8++;
            } else if (infoSeason.getSecondPlace() == id8) {
                pos8 += 2;
                score8 += infoSeason.getScoreSecondPlace();
                count8++;
            } else if (infoSeason.getThirdPlace() == id8) {
                pos8 += 3;
                score8 += infoSeason.getScoreThirdPlace();
                count8++;
            } else if (infoSeason.getFouthPlace() == id8) {
                pos8 += 4;
                score8 += infoSeason.getScoreFouthPlace();
                count8++;
            } else if (infoSeason.getFifthPlace() == id8) {
                pos8 += 5;
                score8 += infoSeason.getScoreFifthPlace();
                count8++;
            } else if (infoSeason.getSixthPlace() == id8) {
                pos8 += 6;
                score8 += infoSeason.getScoreSixthPlace();
                count8++;
            } else if (infoSeason.getSeventhPlace() == id8) {
                pos8 += 7;
                score8 += infoSeason.getScoreSeventhPlace();
                count8++;
            } else if (infoSeason.getEighthPlace() == id8) {
                pos8 += 8;
                score8 += infoSeason.getScoreEighthPlace();
                count8++;
            } else if (infoSeason.getNinthPlace() == id8) {
                pos8 += 9;
                score8 += infoSeason.getScoreNinthPlace();
                count8++;
            } else if (infoSeason.getTenthPlace() == id8) {
                pos8 += 10;
                score8 += infoSeason.getScoreTenthPlace();
                count8++;
            } else if (infoSeason.getEleventhPlace() == id8) {
                pos8 += 11;
                score8 += infoSeason.getScoreEleventhPlace();
                count8++;
            } else if (infoSeason.getTwelfthPlace() == id8) {
                pos8 += 12;
                score8 += infoSeason.getScoreTwelfthPlace();
                count8++;
            } else if (infoSeason.getThirteenthPlace() == id8) {
                pos8 += 13;
                score8 += infoSeason.getScoreThirteenthPlace();
                count8++;
            } else if (infoSeason.getFourteenthPlace() == id8) {
                pos8 += 14;
                score8 += infoSeason.getScoreFourteenthPlace();
                count8++;
            } else if (infoSeason.getFifteenthPlace() == id8) {
                pos8 += 15;
                score8 += infoSeason.getScoreFifteenthPlace();
                count8++;
            } else if (infoSeason.getSixteenthPlace() == id8) {
                pos8 += 16;
                score8 += infoSeason.getScoreSixteenthPlace();
                count8++;
            } else if (infoSeason.getSeventeenthPlace() == id8) {
                pos8 += 17;
                score8 += infoSeason.getScoreSeventeenthPlace();
                count8++;
            } else if (infoSeason.getEighteenthPlace() == id8) {
                pos8 += 18;
                score8 += infoSeason.getScoreEighteenthPlace();
                count8++;
            } else if (infoSeason.getNineteenthPlace() == id8) {
                pos8 += 19;
                score8 += infoSeason.getScoreNineteenthPlace();
                count8++;
            } else if (infoSeason.getTwentiethPlace() == id8) {
                pos8 += 20;
                score8 += infoSeason.getScoreTwentiethPlace();
                count8++;
            }
            if (infoSeason.getFirstPlace() == id9) {
                pos9 += 1;
                score9 += infoSeason.getScoreFirstPlace();
                count9++;
            } else if (infoSeason.getSecondPlace() == id9) {
                pos9 += 2;
                score9 += infoSeason.getScoreSecondPlace();
                count9++;
            } else if (infoSeason.getThirdPlace() == id9) {
                pos9 += 3;
                score9 += infoSeason.getScoreThirdPlace();
                count9++;
            } else if (infoSeason.getFouthPlace() == id9) {
                pos9 += 4;
                score9 += infoSeason.getScoreFouthPlace();
                count9++;
            } else if (infoSeason.getFifthPlace() == id9) {
                pos9 += 5;
                score9 += infoSeason.getScoreFifthPlace();
                count9++;
            } else if (infoSeason.getSixthPlace() == id9) {
                pos9 += 6;
                score9 += infoSeason.getScoreSixthPlace();
                count9++;
            } else if (infoSeason.getSeventhPlace() == id9) {
                pos9 += 7;
                score9 += infoSeason.getScoreSeventhPlace();
                count9++;
            } else if (infoSeason.getEighthPlace() == id9) {
                pos9 += 8;
                score9 += infoSeason.getScoreEighthPlace();
                count9++;
            } else if (infoSeason.getNinthPlace() == id9) {
                pos9 += 9;
                score9 += infoSeason.getScoreNinthPlace();
                count9++;
            } else if (infoSeason.getTenthPlace() == id9) {
                pos9 += 10;
                score9 += infoSeason.getScoreTenthPlace();
                count9++;
            } else if (infoSeason.getEleventhPlace() == id9) {
                pos9 += 11;
                score9 += infoSeason.getScoreEleventhPlace();
                count9++;
            } else if (infoSeason.getTwelfthPlace() == id9) {
                pos9 += 12;
                score9 += infoSeason.getScoreTwelfthPlace();
                count9++;
            } else if (infoSeason.getThirteenthPlace() == id9) {
                pos9 += 13;
                score9 += infoSeason.getScoreThirteenthPlace();
                count9++;
            } else if (infoSeason.getFourteenthPlace() == id9) {
                pos9 += 14;
                score9 += infoSeason.getScoreFourteenthPlace();
                count9++;
            } else if (infoSeason.getFifteenthPlace() == id9) {
                pos9 += 15;
                score9 += infoSeason.getScoreFifteenthPlace();
                count9++;
            } else if (infoSeason.getSixteenthPlace() == id9) {
                pos9 += 16;
                score9 += infoSeason.getScoreSixteenthPlace();
                count9++;
            } else if (infoSeason.getSeventeenthPlace() == id9) {
                pos9 += 17;
                score9 += infoSeason.getScoreSeventeenthPlace();
                count9++;
            } else if (infoSeason.getEighteenthPlace() == id9) {
                pos9 += 18;
                score9 += infoSeason.getScoreEighteenthPlace();
                count9++;
            } else if (infoSeason.getNineteenthPlace() == id9) {
                pos9 += 19;
                score9 += infoSeason.getScoreNineteenthPlace();
                count9++;
            } else if (infoSeason.getTwentiethPlace() == id9) {
                pos9 += 20;
                score9 += infoSeason.getScoreTwentiethPlace();
                count9++;
            }
            if (infoSeason.getFirstPlace() == id10) {
                pos10 += 1;
                score10 += infoSeason.getScoreFirstPlace();
                count10++;
            } else if (infoSeason.getSecondPlace() == id10) {
                pos10 += 2;
                score10 += infoSeason.getScoreSecondPlace();
                count10++;
            } else if (infoSeason.getThirdPlace() == id10) {
                pos10 += 3;
                score10 += infoSeason.getScoreThirdPlace();
                count10++;
            } else if (infoSeason.getFouthPlace() == id10) {
                pos10 += 4;
                score10 += infoSeason.getScoreFouthPlace();
                count10++;
            } else if (infoSeason.getFifthPlace() == id10) {
                pos10 += 5;
                score10 += infoSeason.getScoreFifthPlace();
                count10++;
            } else if (infoSeason.getSixthPlace() == id10) {
                pos10 += 6;
                score10 += infoSeason.getScoreSixthPlace();
                count10++;
            } else if (infoSeason.getSeventhPlace() == id10) {
                pos10 += 7;
                score10 += infoSeason.getScoreSeventhPlace();
                count10++;
            } else if (infoSeason.getEighthPlace() == id10) {
                pos10 += 8;
                score10 += infoSeason.getScoreEighthPlace();
                count10++;
            } else if (infoSeason.getNinthPlace() == id10) {
                pos10 += 9;
                score10 += infoSeason.getScoreNinthPlace();
                count10++;
            } else if (infoSeason.getTenthPlace() == id10) {
                pos10 += 10;
                score10 += infoSeason.getScoreTenthPlace();
                count10++;
            } else if (infoSeason.getEleventhPlace() == id10) {
                pos10 += 11;
                score10 += infoSeason.getScoreEleventhPlace();
                count10++;
            } else if (infoSeason.getTwelfthPlace() == id10) {
                pos10 += 12;
                score10 += infoSeason.getScoreTwelfthPlace();
                count10++;
            } else if (infoSeason.getThirteenthPlace() == id10) {
                pos10 += 13;
                score10 += infoSeason.getScoreThirteenthPlace();
                count10++;
            } else if (infoSeason.getFourteenthPlace() == id10) {
                pos10 += 14;
                score10 += infoSeason.getScoreFourteenthPlace();
                count10++;
            } else if (infoSeason.getFifteenthPlace() == id10) {
                pos10 += 15;
                score10 += infoSeason.getScoreFifteenthPlace();
                count10++;
            } else if (infoSeason.getSixteenthPlace() == id10) {
                pos10 += 16;
                score10 += infoSeason.getScoreSixteenthPlace();
                count10++;
            } else if (infoSeason.getSeventeenthPlace() == id10) {
                pos10 += 17;
                score10 += infoSeason.getScoreSeventeenthPlace();
                count10++;
            } else if (infoSeason.getEighteenthPlace() == id10) {
                pos10 += 18;
                score10 += infoSeason.getScoreEighteenthPlace();
                count10++;
            } else if (infoSeason.getNineteenthPlace() == id10) {
                pos10 += 19;
                score10 += infoSeason.getScoreNineteenthPlace();
                count10++;
            } else if (infoSeason.getTwentiethPlace() == id10) {
                pos10 += 20;
                score10 += infoSeason.getScoreTwentiethPlace();
                count10++;
            }
            if (infoSeason.getFirstPlace() == id11) {
                pos11 += 1;
                score11 += infoSeason.getScoreFirstPlace();
                count11++;
            } else if (infoSeason.getSecondPlace() == id11) {
                pos11 += 2;
                score11 += infoSeason.getScoreSecondPlace();
                count11++;
            } else if (infoSeason.getThirdPlace() == id11) {
                pos11 += 3;
                score11 += infoSeason.getScoreThirdPlace();
                count11++;
            } else if (infoSeason.getFouthPlace() == id11) {
                pos11 += 4;
                score11 += infoSeason.getScoreFouthPlace();
                count11++;
            } else if (infoSeason.getFifthPlace() == id11) {
                pos11 += 5;
                score11 += infoSeason.getScoreFifthPlace();
                count11++;
            } else if (infoSeason.getSixthPlace() == id11) {
                pos11 += 6;
                score11 += infoSeason.getScoreSixthPlace();
                count11++;
            } else if (infoSeason.getSeventhPlace() == id11) {
                pos11 += 7;
                score11 += infoSeason.getScoreSeventhPlace();
                count11++;
            } else if (infoSeason.getEighthPlace() == id11) {
                pos11 += 8;
                score11 += infoSeason.getScoreEighthPlace();
                count11++;
            } else if (infoSeason.getNinthPlace() == id11) {
                pos11 += 9;
                score11 += infoSeason.getScoreNinthPlace();
                count11++;
            } else if (infoSeason.getTenthPlace() == id11) {
                pos11 += 10;
                score11 += infoSeason.getScoreTenthPlace();
                count11++;
            } else if (infoSeason.getEleventhPlace() == id11) {
                pos11 += 11;
                score11 += infoSeason.getScoreEleventhPlace();
                count11++;
            } else if (infoSeason.getTwelfthPlace() == id11) {
                pos11 += 12;
                score11 += infoSeason.getScoreTwelfthPlace();
                count11++;
            } else if (infoSeason.getThirteenthPlace() == id11) {
                pos11 += 13;
                score11 += infoSeason.getScoreThirteenthPlace();
                count11++;
            } else if (infoSeason.getFourteenthPlace() == id11) {
                pos11 += 14;
                score11 += infoSeason.getScoreFourteenthPlace();
                count11++;
            } else if (infoSeason.getFifteenthPlace() == id11) {
                pos11 += 15;
                score11 += infoSeason.getScoreFifteenthPlace();
                count11++;
            } else if (infoSeason.getSixteenthPlace() == id11) {
                pos11 += 16;
                score11 += infoSeason.getScoreSixteenthPlace();
                count11++;
            } else if (infoSeason.getSeventeenthPlace() == id11) {
                pos11 += 17;
                score11 += infoSeason.getScoreSeventeenthPlace();
                count11++;
            } else if (infoSeason.getEighteenthPlace() == id11) {
                pos11 += 18;
                score11 += infoSeason.getScoreEighteenthPlace();
                count11++;
            } else if (infoSeason.getNineteenthPlace() == id11) {
                pos11 += 19;
                score11 += infoSeason.getScoreNineteenthPlace();
                count11++;
            } else if (infoSeason.getTwentiethPlace() == id11) {
                pos11 += 20;
                score11 += infoSeason.getScoreTwentiethPlace();
                count11++;
            }
            if (infoSeason.getFirstPlace() == id12) {
                pos12 += 1;
                score12 += infoSeason.getScoreFirstPlace();
                count12++;
            } else if (infoSeason.getSecondPlace() == id12) {
                pos12 += 2;
                score12 += infoSeason.getScoreSecondPlace();
                count12++;
            } else if (infoSeason.getThirdPlace() == id12) {
                pos12 += 3;
                score12 += infoSeason.getScoreThirdPlace();
                count12++;
            } else if (infoSeason.getFouthPlace() == id12) {
                pos12 += 4;
                score12 += infoSeason.getScoreFouthPlace();
                count12++;
            } else if (infoSeason.getFifthPlace() == id12) {
                pos12 += 5;
                score12 += infoSeason.getScoreFifthPlace();
                count12++;
            } else if (infoSeason.getSixthPlace() == id12) {
                pos12 += 6;
                score12 += infoSeason.getScoreSixthPlace();
                count12++;
            } else if (infoSeason.getSeventhPlace() == id12) {
                pos12 += 7;
                score12 += infoSeason.getScoreSeventhPlace();
                count12++;
            } else if (infoSeason.getEighthPlace() == id12) {
                pos12 += 8;
                score12 += infoSeason.getScoreEighthPlace();
                count12++;
            } else if (infoSeason.getNinthPlace() == id12) {
                pos12 += 9;
                score12 += infoSeason.getScoreNinthPlace();
                count12++;
            } else if (infoSeason.getTenthPlace() == id12) {
                pos12 += 10;
                score12 += infoSeason.getScoreTenthPlace();
                count12++;
            } else if (infoSeason.getEleventhPlace() == id12) {
                pos12 += 11;
                score12 += infoSeason.getScoreEleventhPlace();
                count12++;
            } else if (infoSeason.getTwelfthPlace() == id12) {
                pos12 += 12;
                score12 += infoSeason.getScoreTwelfthPlace();
                count12++;
            } else if (infoSeason.getThirteenthPlace() == id12) {
                pos12 += 13;
                score12 += infoSeason.getScoreThirteenthPlace();
                count12++;
            } else if (infoSeason.getFourteenthPlace() == id12) {
                pos12 += 14;
                score12 += infoSeason.getScoreFourteenthPlace();
                count12++;
            } else if (infoSeason.getFifteenthPlace() == id12) {
                pos12 += 15;
                score12 += infoSeason.getScoreFifteenthPlace();
                count12++;
            } else if (infoSeason.getSixteenthPlace() == id12) {
                pos12 += 16;
                score12 += infoSeason.getScoreSixteenthPlace();
                count12++;
            } else if (infoSeason.getSeventeenthPlace() == id12) {
                pos12 += 17;
                score12 += infoSeason.getScoreSeventeenthPlace();
                count12++;
            } else if (infoSeason.getEighteenthPlace() == id12) {
                pos12 += 18;
                score12 += infoSeason.getScoreEighteenthPlace();
                count12++;
            } else if (infoSeason.getNineteenthPlace() == id12) {
                pos12 += 19;
                score12 += infoSeason.getScoreNineteenthPlace();
                count12++;
            } else if (infoSeason.getTwentiethPlace() == id12) {
                pos12 += 20;
                score12 += infoSeason.getScoreTwentiethPlace();
                count12++;
            }
            if (infoSeason.getFirstPlace() == id13) {
                pos13 += 1;
                score13 += infoSeason.getScoreFirstPlace();
                count13++;
            } else if (infoSeason.getSecondPlace() == id13) {
                pos13 += 2;
                score13 += infoSeason.getScoreSecondPlace();
                count13++;
            } else if (infoSeason.getThirdPlace() == id13) {
                pos13 += 3;
                score13 += infoSeason.getScoreThirdPlace();
                count13++;
            } else if (infoSeason.getFouthPlace() == id13) {
                pos13 += 4;
                score13 += infoSeason.getScoreFouthPlace();
                count13++;
            } else if (infoSeason.getFifthPlace() == id13) {
                pos13 += 5;
                score13 += infoSeason.getScoreFifthPlace();
                count13++;
            } else if (infoSeason.getSixthPlace() == id13) {
                pos13 += 6;
                score13 += infoSeason.getScoreSixthPlace();
                count13++;
            } else if (infoSeason.getSeventhPlace() == id13) {
                pos13 += 7;
                score13 += infoSeason.getScoreSeventhPlace();
                count13++;
            } else if (infoSeason.getEighthPlace() == id13) {
                pos13 += 8;
                score13 += infoSeason.getScoreEighthPlace();
                count13++;
            } else if (infoSeason.getNinthPlace() == id13) {
                pos13 += 9;
                score13 += infoSeason.getScoreNinthPlace();
                count13++;
            } else if (infoSeason.getTenthPlace() == id13) {
                pos13 += 10;
                score13 += infoSeason.getScoreTenthPlace();
                count13++;
            } else if (infoSeason.getEleventhPlace() == id13) {
                pos13 += 11;
                score13 += infoSeason.getScoreEleventhPlace();
                count13++;
            } else if (infoSeason.getTwelfthPlace() == id13) {
                pos13 += 12;
                score13 += infoSeason.getScoreTwelfthPlace();
                count13++;
            } else if (infoSeason.getThirteenthPlace() == id13) {
                pos13 += 13;
                score13 += infoSeason.getScoreThirteenthPlace();
                count13++;
            } else if (infoSeason.getFourteenthPlace() == id13) {
                pos13 += 14;
                score13 += infoSeason.getScoreFourteenthPlace();
                count13++;
            } else if (infoSeason.getFifteenthPlace() == id13) {
                pos13 += 15;
                score13 += infoSeason.getScoreFifteenthPlace();
                count13++;
            } else if (infoSeason.getSixteenthPlace() == id13) {
                pos13 += 16;
                score13 += infoSeason.getScoreSixteenthPlace();
                count13++;
            } else if (infoSeason.getSeventeenthPlace() == id13) {
                pos13 += 17;
                score13 += infoSeason.getScoreSeventeenthPlace();
                count13++;
            } else if (infoSeason.getEighteenthPlace() == id13) {
                pos13 += 18;
                score13 += infoSeason.getScoreEighteenthPlace();
                count13++;
            } else if (infoSeason.getNineteenthPlace() == id13) {
                pos13 += 19;
                score13 += infoSeason.getScoreNineteenthPlace();
                count13++;
            } else if (infoSeason.getTwentiethPlace() == id13) {
                pos13 += 20;
                score13 += infoSeason.getScoreTwentiethPlace();
                count13++;
            }
            if (infoSeason.getFirstPlace() == id14) {
                pos14 += 1;
                score14 += infoSeason.getScoreFirstPlace();
                count14++;
            } else if (infoSeason.getSecondPlace() == id14) {
                pos14 += 2;
                score14 += infoSeason.getScoreSecondPlace();
                count14++;
            } else if (infoSeason.getThirdPlace() == id14) {
                pos14 += 3;
                score14 += infoSeason.getScoreThirdPlace();
                count14++;
            } else if (infoSeason.getFouthPlace() == id14) {
                pos14 += 4;
                score14 += infoSeason.getScoreFouthPlace();
                count14++;
            } else if (infoSeason.getFifthPlace() == id14) {
                pos14 += 5;
                score14 += infoSeason.getScoreFifthPlace();
                count14++;
            } else if (infoSeason.getSixthPlace() == id14) {
                pos14 += 6;
                score14 += infoSeason.getScoreSixthPlace();
                count14++;
            } else if (infoSeason.getSeventhPlace() == id14) {
                pos14 += 7;
                score14 += infoSeason.getScoreSeventhPlace();
                count14++;
            } else if (infoSeason.getEighthPlace() == id14) {
                pos14 += 8;
                score14 += infoSeason.getScoreEighthPlace();
                count14++;
            } else if (infoSeason.getNinthPlace() == id14) {
                pos14 += 9;
                score14 += infoSeason.getScoreNinthPlace();
                count14++;
            } else if (infoSeason.getTenthPlace() == id14) {
                pos14 += 10;
                score14 += infoSeason.getScoreTenthPlace();
                count14++;
            } else if (infoSeason.getEleventhPlace() == id14) {
                pos14 += 11;
                score14 += infoSeason.getScoreEleventhPlace();
                count14++;
            } else if (infoSeason.getTwelfthPlace() == id14) {
                pos14 += 12;
                score14 += infoSeason.getScoreTwelfthPlace();
                count14++;
            } else if (infoSeason.getThirteenthPlace() == id14) {
                pos14 += 13;
                score14 += infoSeason.getScoreThirteenthPlace();
                count14++;
            } else if (infoSeason.getFourteenthPlace() == id14) {
                pos14 += 14;
                score14 += infoSeason.getScoreFourteenthPlace();
                count14++;
            } else if (infoSeason.getFifteenthPlace() == id14) {
                pos14 += 15;
                score14 += infoSeason.getScoreFifteenthPlace();
                count14++;
            } else if (infoSeason.getSixteenthPlace() == id14) {
                pos14 += 16;
                score14 += infoSeason.getScoreSixteenthPlace();
                count14++;
            } else if (infoSeason.getSeventeenthPlace() == id14) {
                pos14 += 17;
                score14 += infoSeason.getScoreSeventeenthPlace();
                count14++;
            } else if (infoSeason.getEighteenthPlace() == id14) {
                pos14 += 18;
                score14 += infoSeason.getScoreEighteenthPlace();
                count14++;
            } else if (infoSeason.getNineteenthPlace() == id14) {
                pos14 += 19;
                score14 += infoSeason.getScoreNineteenthPlace();
                count14++;
            } else if (infoSeason.getTwentiethPlace() == id14) {
                pos14 += 20;
                score14 += infoSeason.getScoreTwentiethPlace();
                count14++;
            }
            if (infoSeason.getFirstPlace() == id15) {
                pos15 += 1;
                score15 += infoSeason.getScoreFirstPlace();
                count15++;
            } else if (infoSeason.getSecondPlace() == id15) {
                pos15 += 2;
                score15 += infoSeason.getScoreSecondPlace();
                count15++;
            } else if (infoSeason.getThirdPlace() == id15) {
                pos15 += 3;
                score15 += infoSeason.getScoreThirdPlace();
                count15++;
            } else if (infoSeason.getFouthPlace() == id15) {
                pos15 += 4;
                score15 += infoSeason.getScoreFouthPlace();
                count15++;
            } else if (infoSeason.getFifthPlace() == id15) {
                pos15 += 5;
                score15 += infoSeason.getScoreFifthPlace();
                count15++;
            } else if (infoSeason.getSixthPlace() == id15) {
                pos15 += 6;
                score15 += infoSeason.getScoreSixthPlace();
                count15++;
            } else if (infoSeason.getSeventhPlace() == id15) {
                pos15 += 7;
                score15 += infoSeason.getScoreSeventhPlace();
                count15++;
            } else if (infoSeason.getEighthPlace() == id15) {
                pos15 += 8;
                score15 += infoSeason.getScoreEighthPlace();
                count15++;
            } else if (infoSeason.getNinthPlace() == id15) {
                pos15 += 9;
                score15 += infoSeason.getScoreNinthPlace();
                count15++;
            } else if (infoSeason.getTenthPlace() == id15) {
                pos15 += 10;
                score15 += infoSeason.getScoreTenthPlace();
                count15++;
            } else if (infoSeason.getEleventhPlace() == id15) {
                pos15 += 11;
                score15 += infoSeason.getScoreEleventhPlace();
                count15++;
            } else if (infoSeason.getTwelfthPlace() == id15) {
                pos15 += 12;
                score15 += infoSeason.getScoreTwelfthPlace();
                count15++;
            } else if (infoSeason.getThirteenthPlace() == id15) {
                pos15 += 13;
                score15 += infoSeason.getScoreThirteenthPlace();
                count15++;
            } else if (infoSeason.getFourteenthPlace() == id15) {
                pos15 += 14;
                score15 += infoSeason.getScoreFourteenthPlace();
                count15++;
            } else if (infoSeason.getFifteenthPlace() == id15) {
                pos15 += 15;
                score15 += infoSeason.getScoreFifteenthPlace();
                count15++;
            } else if (infoSeason.getSixteenthPlace() == id15) {
                pos15 += 16;
                score15 += infoSeason.getScoreSixteenthPlace();
                count15++;
            } else if (infoSeason.getSeventeenthPlace() == id15) {
                pos15 += 17;
                score15 += infoSeason.getScoreSeventeenthPlace();
                count15++;
            } else if (infoSeason.getEighteenthPlace() == id15) {
                pos15 += 18;
                score15 += infoSeason.getScoreEighteenthPlace();
                count15++;
            } else if (infoSeason.getNineteenthPlace() == id15) {
                pos15 += 19;
                score15 += infoSeason.getScoreNineteenthPlace();
                count15++;
            } else if (infoSeason.getTwentiethPlace() == id15) {
                pos15 += 20;
                score15 += infoSeason.getScoreTwentiethPlace();
                count15++;
            }
            if (infoSeason.getFirstPlace() == id16) {
                pos16 += 1;
                score16 += infoSeason.getScoreFirstPlace();
                count16++;
            } else if (infoSeason.getSecondPlace() == id16) {
                pos16 += 2;
                score16 += infoSeason.getScoreSecondPlace();
                count16++;
            } else if (infoSeason.getThirdPlace() == id16) {
                pos16 += 3;
                score16 += infoSeason.getScoreThirdPlace();
                count16++;
            } else if (infoSeason.getFouthPlace() == id16) {
                pos16 += 4;
                score16 += infoSeason.getScoreFouthPlace();
                count16++;
            } else if (infoSeason.getFifthPlace() == id16) {
                pos16 += 5;
                score16 += infoSeason.getScoreFifthPlace();
                count16++;
            } else if (infoSeason.getSixthPlace() == id16) {
                pos16 += 6;
                score16 += infoSeason.getScoreSixthPlace();
                count16++;
            } else if (infoSeason.getSeventhPlace() == id16) {
                pos16 += 7;
                score16 += infoSeason.getScoreSeventhPlace();
                count16++;
            } else if (infoSeason.getEighthPlace() == id16) {
                pos16 += 8;
                score16 += infoSeason.getScoreEighthPlace();
                count16++;
            } else if (infoSeason.getNinthPlace() == id16) {
                pos16 += 9;
                score16 += infoSeason.getScoreNinthPlace();
                count16++;
            } else if (infoSeason.getTenthPlace() == id16) {
                pos16 += 10;
                score16 += infoSeason.getScoreTenthPlace();
                count16++;
            } else if (infoSeason.getEleventhPlace() == id16) {
                pos16 += 11;
                score16 += infoSeason.getScoreEleventhPlace();
                count16++;
            } else if (infoSeason.getTwelfthPlace() == id16) {
                pos16 += 12;
                score16 += infoSeason.getScoreTwelfthPlace();
                count16++;
            } else if (infoSeason.getThirteenthPlace() == id16) {
                pos16 += 13;
                score16 += infoSeason.getScoreThirteenthPlace();
                count16++;
            } else if (infoSeason.getFourteenthPlace() == id16) {
                pos16 += 14;
                score16 += infoSeason.getScoreFourteenthPlace();
                count16++;
            } else if (infoSeason.getFifteenthPlace() == id16) {
                pos16 += 15;
                score16 += infoSeason.getScoreFifteenthPlace();
                count16++;
            } else if (infoSeason.getSixteenthPlace() == id16) {
                pos16 += 16;
                score16 += infoSeason.getScoreSixteenthPlace();
                count16++;
            } else if (infoSeason.getSeventeenthPlace() == id16) {
                pos16 += 17;
                score16 += infoSeason.getScoreSeventeenthPlace();
                count16++;
            } else if (infoSeason.getEighteenthPlace() == id16) {
                pos16 += 18;
                score16 += infoSeason.getScoreEighteenthPlace();
                count16++;
            } else if (infoSeason.getNineteenthPlace() == id16) {
                pos16 += 19;
                score16 += infoSeason.getScoreNineteenthPlace();
                count16++;
            } else if (infoSeason.getTwentiethPlace() == id16) {
                pos16 += 20;
                score16 += infoSeason.getScoreTwentiethPlace();
                count16++;
            }
            if (infoSeason.getFirstPlace() == id17) {
                pos17 += 1;
                score17 += infoSeason.getScoreFirstPlace();
                count17++;
            } else if (infoSeason.getSecondPlace() == id17) {
                pos17 += 2;
                score17 += infoSeason.getScoreSecondPlace();
                count17++;
            } else if (infoSeason.getThirdPlace() == id17) {
                pos17 += 3;
                score17 += infoSeason.getScoreThirdPlace();
                count17++;
            } else if (infoSeason.getFouthPlace() == id17) {
                pos17 += 4;
                score17 += infoSeason.getScoreFouthPlace();
                count17++;
            } else if (infoSeason.getFifthPlace() == id17) {
                pos17 += 5;
                score17 += infoSeason.getScoreFifthPlace();
                count17++;
            } else if (infoSeason.getSixthPlace() == id17) {
                pos17 += 6;
                score17 += infoSeason.getScoreSixthPlace();
                count17++;
            } else if (infoSeason.getSeventhPlace() == id17) {
                pos17 += 7;
                score17 += infoSeason.getScoreSeventhPlace();
                count17++;
            } else if (infoSeason.getEighthPlace() == id17) {
                pos17 += 8;
                score17 += infoSeason.getScoreEighthPlace();
                count17++;
            } else if (infoSeason.getNinthPlace() == id17) {
                pos17 += 9;
                score17 += infoSeason.getScoreNinthPlace();
                count17++;
            } else if (infoSeason.getTenthPlace() == id17) {
                pos17 += 10;
                score17 += infoSeason.getScoreTenthPlace();
                count17++;
            } else if (infoSeason.getEleventhPlace() == id17) {
                pos17 += 11;
                score17 += infoSeason.getScoreEleventhPlace();
                count17++;
            } else if (infoSeason.getTwelfthPlace() == id17) {
                pos17 += 12;
                score17 += infoSeason.getScoreTwelfthPlace();
                count17++;
            } else if (infoSeason.getThirteenthPlace() == id17) {
                pos17 += 13;
                score17 += infoSeason.getScoreThirteenthPlace();
                count17++;
            } else if (infoSeason.getFourteenthPlace() == id17) {
                pos17 += 14;
                score17 += infoSeason.getScoreFourteenthPlace();
                count17++;
            } else if (infoSeason.getFifteenthPlace() == id17) {
                pos17 += 15;
                score17 += infoSeason.getScoreFifteenthPlace();
                count17++;
            } else if (infoSeason.getSixteenthPlace() == id17) {
                pos17 += 16;
                score17 += infoSeason.getScoreSixteenthPlace();
                count17++;
            } else if (infoSeason.getSeventeenthPlace() == id17) {
                pos17 += 17;
                score17 += infoSeason.getScoreSeventeenthPlace();
                count17++;
            } else if (infoSeason.getEighteenthPlace() == id17) {
                pos17 += 18;
                score17 += infoSeason.getScoreEighteenthPlace();
                count17++;
            } else if (infoSeason.getNineteenthPlace() == id17) {
                pos17 += 19;
                score17 += infoSeason.getScoreNineteenthPlace();
                count17++;
            } else if (infoSeason.getTwentiethPlace() == id17) {
                pos17 += 20;
                score17 += infoSeason.getScoreTwentiethPlace();
                count17++;
            }
            if (infoSeason.getFirstPlace() == id18) {
                pos18 += 1;
                score18 += infoSeason.getScoreFirstPlace();
                count18++;
            } else if (infoSeason.getSecondPlace() == id18) {
                pos18 += 2;
                score18 += infoSeason.getScoreSecondPlace();
                count18++;
            } else if (infoSeason.getThirdPlace() == id18) {
                pos18 += 3;
                score18 += infoSeason.getScoreThirdPlace();
                count18++;
            } else if (infoSeason.getFouthPlace() == id18) {
                pos18 += 4;
                score18 += infoSeason.getScoreFouthPlace();
                count18++;
            } else if (infoSeason.getFifthPlace() == id18) {
                pos18 += 5;
                score18 += infoSeason.getScoreFifthPlace();
                count18++;
            } else if (infoSeason.getSixthPlace() == id18) {
                pos18 += 6;
                score18 += infoSeason.getScoreSixthPlace();
                count18++;
            } else if (infoSeason.getSeventhPlace() == id18) {
                pos18 += 7;
                score18 += infoSeason.getScoreSeventhPlace();
                count18++;
            } else if (infoSeason.getEighthPlace() == id18) {
                pos18 += 8;
                score18 += infoSeason.getScoreEighthPlace();
                count18++;
            } else if (infoSeason.getNinthPlace() == id18) {
                pos18 += 9;
                score18 += infoSeason.getScoreNinthPlace();
                count18++;
            } else if (infoSeason.getTenthPlace() == id18) {
                pos18 += 10;
                score18 += infoSeason.getScoreTenthPlace();
                count18++;
            } else if (infoSeason.getEleventhPlace() == id18) {
                pos18 += 11;
                score18 += infoSeason.getScoreEleventhPlace();
                count18++;
            } else if (infoSeason.getTwelfthPlace() == id18) {
                pos18 += 12;
                score18 += infoSeason.getScoreTwelfthPlace();
                count18++;
            } else if (infoSeason.getThirteenthPlace() == id18) {
                pos18 += 13;
                score18 += infoSeason.getScoreThirteenthPlace();
                count18++;
            } else if (infoSeason.getFourteenthPlace() == id18) {
                pos18 += 14;
                score18 += infoSeason.getScoreFourteenthPlace();
                count18++;
            } else if (infoSeason.getFifteenthPlace() == id18) {
                pos18 += 15;
                score18 += infoSeason.getScoreFifteenthPlace();
                count18++;
            } else if (infoSeason.getSixteenthPlace() == id18) {
                pos18 += 16;
                score18 += infoSeason.getScoreSixteenthPlace();
                count18++;
            } else if (infoSeason.getSeventeenthPlace() == id18) {
                pos18 += 17;
                score18 += infoSeason.getScoreSeventeenthPlace();
                count18++;
            } else if (infoSeason.getEighteenthPlace() == id18) {
                pos18 += 18;
                score18 += infoSeason.getScoreEighteenthPlace();
                count18++;
            } else if (infoSeason.getNineteenthPlace() == id18) {
                pos18 += 19;
                score18 += infoSeason.getScoreNineteenthPlace();
                count18++;
            } else if (infoSeason.getTwentiethPlace() == id18) {
                pos18 += 20;
                score18 += infoSeason.getScoreTwentiethPlace();
                count18++;
            }
            if (infoSeason.getFirstPlace() == id19) {
                pos19 += 1;
                score19 += infoSeason.getScoreFirstPlace();
                count19++;
            } else if (infoSeason.getSecondPlace() == id19) {
                pos19 += 2;
                score19 += infoSeason.getScoreSecondPlace();
                count19++;
            } else if (infoSeason.getThirdPlace() == id19) {
                pos19 += 3;
                score19 += infoSeason.getScoreThirdPlace();
                count19++;
            } else if (infoSeason.getFouthPlace() == id19) {
                pos19 += 4;
                score19 += infoSeason.getScoreFouthPlace();
                count19++;
            } else if (infoSeason.getFifthPlace() == id19) {
                pos19 += 5;
                score19 += infoSeason.getScoreFifthPlace();
                count19++;
            } else if (infoSeason.getSixthPlace() == id19) {
                pos19 += 6;
                score19 += infoSeason.getScoreSixthPlace();
                count19++;
            } else if (infoSeason.getSeventhPlace() == id19) {
                pos19 += 7;
                score19 += infoSeason.getScoreSeventhPlace();
                count19++;
            } else if (infoSeason.getEighthPlace() == id19) {
                pos19 += 8;
                score19 += infoSeason.getScoreEighthPlace();
                count19++;
            } else if (infoSeason.getNinthPlace() == id19) {
                pos19 += 9;
                score19 += infoSeason.getScoreNinthPlace();
                count19++;
            } else if (infoSeason.getTenthPlace() == id19) {
                pos19 += 10;
                score19 += infoSeason.getScoreTenthPlace();
                count19++;
            } else if (infoSeason.getEleventhPlace() == id19) {
                pos19 += 11;
                score19 += infoSeason.getScoreEleventhPlace();
                count19++;
            } else if (infoSeason.getTwelfthPlace() == id19) {
                pos19 += 12;
                score19 += infoSeason.getScoreTwelfthPlace();
                count19++;
            } else if (infoSeason.getThirteenthPlace() == id19) {
                pos19 += 13;
                score19 += infoSeason.getScoreThirteenthPlace();
                count19++;
            } else if (infoSeason.getFourteenthPlace() == id19) {
                pos19 += 14;
                score19 += infoSeason.getScoreFourteenthPlace();
                count19++;
            } else if (infoSeason.getFifteenthPlace() == id19) {
                pos19 += 15;
                score19 += infoSeason.getScoreFifteenthPlace();
                count19++;
            } else if (infoSeason.getSixteenthPlace() == id19) {
                pos19 += 16;
                score19 += infoSeason.getScoreSixteenthPlace();
                count19++;
            } else if (infoSeason.getSeventeenthPlace() == id19) {
                pos19 += 17;
                score19 += infoSeason.getScoreSeventeenthPlace();
                count19++;
            } else if (infoSeason.getEighteenthPlace() == id19) {
                pos19 += 18;
                score19 += infoSeason.getScoreEighteenthPlace();
                count19++;
            } else if (infoSeason.getNineteenthPlace() == id19) {
                pos19 += 19;
                score19 += infoSeason.getScoreNineteenthPlace();
                count19++;
            } else if (infoSeason.getTwentiethPlace() == id19) {
                pos19 += 20;
                score19 += infoSeason.getScoreTwentiethPlace();
                count19++;
            }
            if (infoSeason.getFirstPlace() == id20) {
                pos20 += 1;
                score20 += infoSeason.getScoreFirstPlace();
                count20++;
            } else if (infoSeason.getSecondPlace() == id20) {
                pos20 += 2;
                score20 += infoSeason.getScoreSecondPlace();
                count20++;
            } else if (infoSeason.getThirdPlace() == id20) {
                pos20 += 3;
                score20 += infoSeason.getScoreThirdPlace();
                count20++;
            } else if (infoSeason.getFouthPlace() == id20) {
                pos20 += 4;
                score20 += infoSeason.getScoreFouthPlace();
                count20++;
            } else if (infoSeason.getFifthPlace() == id20) {
                pos20 += 5;
                score20 += infoSeason.getScoreFifthPlace();
                count20++;
            } else if (infoSeason.getSixthPlace() == id20) {
                pos20 += 6;
                score20 += infoSeason.getScoreSixthPlace();
                count20++;
            } else if (infoSeason.getSeventhPlace() == id20) {
                pos20 += 7;
                score20 += infoSeason.getScoreSeventhPlace();
                count20++;
            } else if (infoSeason.getEighthPlace() == id20) {
                pos20 += 8;
                score20 += infoSeason.getScoreEighthPlace();
                count20++;
            } else if (infoSeason.getNinthPlace() == id20) {
                pos20 += 9;
                score20 += infoSeason.getScoreNinthPlace();
                count20++;
            } else if (infoSeason.getTenthPlace() == id20) {
                pos20 += 10;
                score20 += infoSeason.getScoreTenthPlace();
                count20++;
            } else if (infoSeason.getEleventhPlace() == id20) {
                pos20 += 11;
                score20 += infoSeason.getScoreEleventhPlace();
                count20++;
            } else if (infoSeason.getTwelfthPlace() == id20) {
                pos20 += 12;
                score20 += infoSeason.getScoreTwelfthPlace();
                count20++;
            } else if (infoSeason.getThirteenthPlace() == id20) {
                pos20 += 13;
                score20 += infoSeason.getScoreThirteenthPlace();
                count20++;
            } else if (infoSeason.getFourteenthPlace() == id20) {
                pos20 += 14;
                score20 += infoSeason.getScoreFourteenthPlace();
                count20++;
            } else if (infoSeason.getFifteenthPlace() == id20) {
                pos20 += 15;
                score20 += infoSeason.getScoreFifteenthPlace();
                count20++;
            } else if (infoSeason.getSixteenthPlace() == id20) {
                pos20 += 16;
                score20 += infoSeason.getScoreSixteenthPlace();
                count20++;
            } else if (infoSeason.getSeventeenthPlace() == id20) {
                pos20 += 17;
                score20 += infoSeason.getScoreSeventeenthPlace();
                count20++;
            } else if (infoSeason.getEighteenthPlace() == id20) {
                pos20 += 18;
                score20 += infoSeason.getScoreEighteenthPlace();
                count20++;
            } else if (infoSeason.getNineteenthPlace() == id20) {
                pos20 += 19;
                score20 += infoSeason.getScoreNineteenthPlace();
                count20++;
            } else if (infoSeason.getTwentiethPlace() == id20) {
                pos20 += 20;
                score20 += infoSeason.getScoreTwentiethPlace();
                count20++;
            }
        }

        model.addAttribute("positionTeam1", pos1 / count1);
        model.addAttribute("scoreTeam1", score1 / count1);
        model.addAttribute("positionTeam2", pos2 / count2);
        model.addAttribute("scoreTeam2", score2 / count2);
        model.addAttribute("positionTeam3", pos3 / count3);
        model.addAttribute("scoreTeam3", score3 / count3);
        model.addAttribute("positionTeam4", pos4 / count4);
        model.addAttribute("scoreTeam4", score4 / count4);
        model.addAttribute("positionTeam5", pos5 / count5);
        model.addAttribute("scoreTeam5", score5 / count5);
        model.addAttribute("positionTeam6", pos6 / count6);
        model.addAttribute("scoreTeam6", score6 / count6);
        model.addAttribute("positionTeam7", pos7 / count7);
        model.addAttribute("scoreTeam7", score7 / count7);
        model.addAttribute("positionTeam8", pos8 / count8);
        model.addAttribute("scoreTeam8", score8 / count8);
        model.addAttribute("positionTeam9", pos9 / count9);
        model.addAttribute("scoreTeam9", score9 / count9);
        model.addAttribute("positionTeam10", pos10 / count10);
        model.addAttribute("scoreTeam10", score10 / count10);
        model.addAttribute("positionTeam11", pos11 / count11);
        model.addAttribute("scoreTeam11", score11 / count11);
        model.addAttribute("positionTeam12", pos12 / count12);
        model.addAttribute("scoreTeam12", score12 / count12);
        model.addAttribute("positionTeam13", pos13 / count13);
        model.addAttribute("scoreTeam13", score13 / count13);
        model.addAttribute("positionTeam14", pos14 / count14);
        model.addAttribute("scoreTeam14", score14 / count14);
        model.addAttribute("positionTeam15", pos15 / count15);
        model.addAttribute("scoreTeam15", score15 / count15);
        model.addAttribute("positionTeam16", pos16 / count16);
        model.addAttribute("scoreTeam16", score16 / count16);
        model.addAttribute("positionTeam17", pos17 / count17);
        model.addAttribute("scoreTeam17", score17 / count17);
        model.addAttribute("positionTeam18", pos18 / count18);
        model.addAttribute("scoreTeam18", score18 / count18);
        model.addAttribute("positionTeam19", pos19 / count19);
        model.addAttribute("scoreTeam19", score19 / count19);
        model.addAttribute("positionTeam20", pos20 / count20);
        model.addAttribute("scoreTeam20", score20 / count20);

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
