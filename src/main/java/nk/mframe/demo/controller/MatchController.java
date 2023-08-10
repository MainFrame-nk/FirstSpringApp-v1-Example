package nk.mframe.demo.controller;

import nk.mframe.demo.model.match_table;
import nk.mframe.demo.model.team;
import nk.mframe.demo.dao.MatchRepository;
import nk.mframe.demo.dao.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Controller
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/match")
    public String matchMain(Model model) {
        Iterable<match_table> matches = matchRepository.findAll();
        ArrayList<match_table> allMatches = new ArrayList<>();
        ArrayList<team> th = new ArrayList<>();
        ArrayList<team> tg = new ArrayList<>();
        for (match_table mt : matches) {
            if (LocalDate.now().equals(mt.getDateMatch())) {
                Optional<match_table> todayMatch = matchRepository.findById(mt.getIdMatch());

                todayMatch.ifPresent(allMatches::add);
                model.addAttribute("match", allMatches);

                Optional<team> team_home = teamRepository.findById(mt.getTeamHome());
                Optional<team> team_guest = teamRepository.findById(mt.getTeamGuest());

                team_home.ifPresent(th::add);
                team_guest.ifPresent(tg::add);
                model.addAttribute("team_home", th);
                model.addAttribute("team_guest", tg);
            }
        }
        return "match-index";
    }

    @GetMapping("/match/add")
    public String matchAdd(Model model) {
        Iterable<team> team = teamRepository.findAll();
        model.addAttribute("team", team);
        return "match-add";
    }
    @PostMapping("/match/add")
    public String matchPostAdd(@RequestParam String date_match, @RequestParam String time_match, @RequestParam int team_home, @RequestParam int team_guest, Model model) {
        LocalDate dateStr_match = LocalDate.parse(date_match);
        LocalTime timeStr_match = LocalTime.parse(time_match);

        match_table matches = new match_table(team_home, team_guest, dateStr_match, timeStr_match,0, 0, -1, 0, 0, -1, 0, 0, 0, 0,
                -1, 0, 0, -1, 0, 0, -1, 0, 0, -1,
                0, 0, 0, 0, 0, -1, 0, 0, -1, 0,
                0, -1, 0, 0, -1, 0, 0, -1, 0, 0,
                -1, 0, 0, -1, 0, 0, -1, 0, 0, -1,
                0, 0, -1, 0, 0, -1);
        matchRepository.save(matches);
        return "redirect:/match";
    }

    @GetMapping("/match/{id}/0")
    public String matchDetailsMatch(@PathVariable(value = "id") int idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        Optional<match_table> match = matchRepository.findById(idMatch);
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);

        Optional<team> team_home = teamRepository.findById(match.get().getTeamHome());
        Optional<team> team_guest = teamRepository.findById(match.get().getTeamGuest());
        ArrayList<team> th = new ArrayList<>();
        ArrayList<team> tg = new ArrayList<>();
        team_home.ifPresent(th::add);
        team_guest.ifPresent(tg::add);
        model.addAttribute("team_home", th);
        model.addAttribute("team_guest", tg);
        return "match-details-0";
    }

    @GetMapping("/match/{id}/1")
    public String matchDetailsFirst(@PathVariable(value = "id") int idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        Optional<match_table> match = matchRepository.findById(idMatch);
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);

        Optional<team> team_home = teamRepository.findById(match.get().getTeamHome());
        Optional<team> team_guest = teamRepository.findById(match.get().getTeamGuest());
        ArrayList<team> th = new ArrayList<>();
        ArrayList<team> tg = new ArrayList<>();
        team_home.ifPresent(th::add);
        team_guest.ifPresent(tg::add);
        model.addAttribute("team_home", th);
        model.addAttribute("team_guest", tg);
        return "match-details-1";
    }

    @GetMapping("/match/{id}/2")
    public String matchDetailsSecond(@PathVariable(value = "id") int idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        Optional<match_table> match = matchRepository.findById(idMatch);
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);

        Optional<team> team_home = teamRepository.findById(match.get().getTeamHome());
        Optional<team> team_guest = teamRepository.findById(match.get().getTeamGuest());
        ArrayList<team> th = new ArrayList<>();
        ArrayList<team> tg = new ArrayList<>();
        team_home.ifPresent(th::add);
        team_guest.ifPresent(tg::add);
        model.addAttribute("team_home", th);
        model.addAttribute("team_guest", tg);
        return "match-details-2";
    }

    @GetMapping("/match/{id}/3")
    public String matchDetailsExtra(@PathVariable(value = "id") int idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        Optional<match_table> match = matchRepository.findById(idMatch);
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);

        Optional<team> team_home = teamRepository.findById(match.get().getTeamHome());
        Optional<team> team_guest = teamRepository.findById(match.get().getTeamGuest());
        ArrayList<team> th = new ArrayList<>();
        ArrayList<team> tg = new ArrayList<>();
        team_home.ifPresent(th::add);
        team_guest.ifPresent(tg::add);
        model.addAttribute("team_home", th);
        model.addAttribute("team_guest", tg);
        return "match-details-3";
    }

    @GetMapping("/match/{id}/edit/0")
    public String matchEditMatch(@PathVariable(value = "id") int idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        Optional<match_table> match = matchRepository.findById(idMatch);
        Iterable<team> team = teamRepository.findAll();
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);
        model.addAttribute("team", team);
        return "match-edit-0";
    }

    @GetMapping("/match/{id}/edit/1")
    public String matchEditFirst(@PathVariable(value = "id") int idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        Optional<match_table> match = matchRepository.findById(idMatch);
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);
        return "match-edit-1";
    }

    @GetMapping("/match/{id}/edit/2")
    public String matchEditSecond(@PathVariable(value = "id") int idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        Optional<match_table> match = matchRepository.findById(idMatch);
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);
        return "match-edit-2";
    }

    @GetMapping("/match/{id}/edit/3")
    public String matchEditExtra(@PathVariable(value = "id") int idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        Optional<match_table> match = matchRepository.findById(idMatch);
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);
        return "match-edit-3";
    }

    @PostMapping("/match/{id}/edit/0")
    public String matchUpdateMatch(@PathVariable(value = "id") int idMatch, @RequestParam int team_home, @RequestParam int team_guest,
                              @RequestParam String date_match,
                              @RequestParam String time_match,
                              @RequestParam int score_home,
                              @RequestParam int score_guest,
                              @RequestParam int shot_first_half_home,
                              @RequestParam int shot_second_half_home,
                              @RequestParam int shot_extra_half_home,
                              @RequestParam int shot_first_half_guest,
                              @RequestParam int shot_second_half_guest,
                              @RequestParam int shot_extra_half_guest,
                              @RequestParam int possession_first_half_home,
                              @RequestParam int possession_second_half_home,
                              @RequestParam int possession_extra_half_home,
                              @RequestParam int possession_first_half_guest,
                              @RequestParam int possession_second_half_guest,
                              @RequestParam int possession_extra_half_guest,
                              @RequestParam int shot_on_target_first_half_home,
                              @RequestParam int shot_on_target_second_half_home,
                              @RequestParam int shot_on_target_extra_half_home,
                              @RequestParam int shot_on_target_first_half_guest,
                              @RequestParam int shot_on_target_second_half_guest,
                              @RequestParam int shot_on_target_extra_half_guest,
                              @RequestParam int corner_first_half_home,
                              @RequestParam int corner_second_half_home,
                              @RequestParam int corner_extra_half_home,
                              @RequestParam int corner_first_half_guest,
                              @RequestParam int corner_second_half_guest,
                              @RequestParam int corner_extra_half_guest,
                              @RequestParam int yellow_card_first_half_home,
                              @RequestParam int yellow_card_second_half_home,
                              @RequestParam int yellow_card_extra_half_home,
                              @RequestParam int yellow_card_first_half_guest,
                              @RequestParam int yellow_card_second_half_guest,
                              @RequestParam int yellow_card_extra_half_guest,
                              @RequestParam int red_card_first_half_home,
                              @RequestParam int red_card_second_half_home,
                              @RequestParam int red_card_extra_half_home,
                              @RequestParam int red_card_first_half_guest,
                              @RequestParam int red_card_second_half_guest,
                              @RequestParam int red_card_extra_half_guest,
                              @RequestParam int free_kick_first_half_home,
                              @RequestParam int free_kick_second_half_home,
                              @RequestParam int free_kick_extra_half_home,
                              @RequestParam int free_kick_first_half_guest,
                              @RequestParam int free_kick_second_half_guest,
                              @RequestParam int free_kick_extra_half_guest,
                              @RequestParam int offside_first_half_home,
                              @RequestParam int offside_second_half_home,
                              @RequestParam int offside_extra_half_home,
                              @RequestParam int offside_first_half_guest,
                              @RequestParam int offside_second_half_guest,
                              @RequestParam int offside_extra_half_guest,
                              @RequestParam int foul_first_half_home,
                              @RequestParam int foul_second_half_home,
                              @RequestParam int foul_extra_half_home,
                              @RequestParam int foul_first_half_guest,
                              @RequestParam int foul_second_half_guest,
                              @RequestParam int foul_extra_half_guest,
                              Model model) {
        match_table match = matchRepository.findById(idMatch).orElseThrow(RuntimeException::new);
        LocalDate dateStr_match = LocalDate.parse(date_match);
        LocalTime timeStr_match = LocalTime.parse(time_match);
        match.setDateMatch(dateStr_match);
        match.setTimeMatch(timeStr_match);
        match.setTeamHome(team_home);
        match.setTeamGuest(team_guest);
        match.setScoreHome(score_home);
        match.setScoreGuest(score_guest);
        match.setShotFirstHalfHome(shot_first_half_home);
        match.setShotSecondHalfHome(shot_second_half_home);
        match.setShotExtraTimeHome(shot_extra_half_home);
        match.setShotFirstHalfGuest(shot_first_half_guest);
        match.setShotSecondHalfGuest(shot_second_half_guest);
        match.setShotExtraTimeGuest(shot_extra_half_guest);
        match.setShotOnTargetFirstHalfHome(shot_on_target_first_half_home);
        match.setShotOnTargetSecondHalfHome(shot_on_target_second_half_home);
        match.setShotOnTargetExtraTimeHome(shot_on_target_extra_half_home);
        match.setShotOnTargetFirstHalfGuest(shot_on_target_first_half_guest);
        match.setShotOnTargetSecondHalfGuest(shot_on_target_second_half_guest);
        match.setShotOnTargetExtraTimeGuest(shot_on_target_extra_half_guest);
        match.setPossessionFirstHalfHome(possession_first_half_home);
        match.setPossessionSecondHalfHome(possession_second_half_home);
        match.setPossessionExtraTimeHome(possession_extra_half_home);
        match.setPossessionFirstHalfGuest(possession_first_half_guest);
        match.setPossessionSecondHalfGuest(possession_second_half_guest);
        match.setPossessionExtraTimeGuest(possession_extra_half_guest);
        match.setCornerFirstHalfHome(corner_first_half_home);
        match.setCornerSecondHalfHome(corner_second_half_home);
        match.setCornerExtraTimeHome(corner_extra_half_home);
        match.setCornerFirstHalfGuest(corner_first_half_guest);
        match.setCornerSecondHalfGuest(corner_second_half_guest);
        match.setCornerExtraTimeGuest(corner_extra_half_guest);
        match.setYellowCardFirstHalfHome(yellow_card_first_half_home);
        match.setYellowCardSecondHalfHome(yellow_card_second_half_home);
        match.setYellowCardExtraTimeHome(yellow_card_extra_half_home);
        match.setYellowCardFirstHalfGuest(yellow_card_first_half_guest);
        match.setYellowCardSecondHalfGuest(yellow_card_second_half_guest);
        match.setYellowCardExtraTimeGuest(yellow_card_extra_half_guest);
        match.setRedCardFirstHalfHome(red_card_first_half_home);
        match.setRedCardSecondHalfHome(red_card_second_half_home);
        match.setRedCardExtraTimeHome(red_card_extra_half_home);
        match.setRedCardFirstHalfGuest(red_card_first_half_guest);
        match.setRedCardSecondHalfGuest(red_card_second_half_guest);
        match.setRedCardExtraTimeGuest(red_card_extra_half_guest);
        match.setFreeKickFirstHalfHome(free_kick_first_half_home);
        match.setFreeKickSecondHalfHome(free_kick_second_half_home);
        match.setFreeKickExtraTimeHome(free_kick_extra_half_home);
        match.setFreeKickFirstHalfGuest(free_kick_first_half_guest);
        match.setFreeKickSecondHalfGuest(free_kick_second_half_guest);
        match.setFreeKickExtraTimeGuest(free_kick_extra_half_guest);
        match.setOffsideFirstHalfHome(offside_first_half_home);
        match.setOffsideSecondHalfHome(offside_second_half_home);
        match.setOffsideExtraTimeHome(offside_extra_half_home);
        match.setOffsideFirstHalfGuest(offside_first_half_guest);
        match.setOffsideSecondHalfGuest(offside_second_half_guest);
        match.setOffsideExtraTimeGuest(offside_extra_half_guest);
        match.setFoulFirstHalfHome(foul_first_half_home);
        match.setFoulSecondHalfHome(foul_second_half_home);
        match.setFoulExtraTimeHome(foul_extra_half_home);
        match.setFoulFirstHalfGuest(foul_first_half_guest);
        match.setFoulSecondHalfGuest(foul_second_half_guest);
        match.setFoulExtraTimeGuest(foul_extra_half_guest);
        matchRepository.save(match);
        return "redirect:/match";
    }

    @PostMapping("/match/{id}/edit/1")
    public String matchUpdateFirst(@PathVariable(value = "id") int idMatch,
                              @RequestParam int shot_first_half_home,
                              @RequestParam int shot_first_half_guest,
                              @RequestParam int possession_first_half_home,
                              @RequestParam int possession_first_half_guest,
                              @RequestParam int shot_on_target_first_half_home,
                              @RequestParam int shot_on_target_first_half_guest,
                              @RequestParam int corner_first_half_home,
                              @RequestParam int corner_first_half_guest,
                              @RequestParam int yellow_card_first_half_home,
                              @RequestParam int yellow_card_first_half_guest,
                              @RequestParam int red_card_first_half_home,
                              @RequestParam int red_card_first_half_guest,
                              @RequestParam int free_kick_first_half_home,
                              @RequestParam int free_kick_first_half_guest,
                              @RequestParam int offside_first_half_home,
                              @RequestParam int offside_first_half_guest,
                              @RequestParam int foul_first_half_home,
                              @RequestParam int foul_first_half_guest,
                              Model model) {
        match_table match = matchRepository.findById(idMatch).orElseThrow(RuntimeException::new);
        match.setShotFirstHalfHome(shot_first_half_home);
        match.setShotFirstHalfGuest(shot_first_half_guest);
        match.setShotOnTargetFirstHalfHome(shot_on_target_first_half_home);
        match.setShotOnTargetFirstHalfGuest(shot_on_target_first_half_guest);
        match.setPossessionFirstHalfHome(possession_first_half_home);
        match.setPossessionFirstHalfGuest(possession_first_half_guest);
        match.setCornerFirstHalfHome(corner_first_half_home);
        match.setCornerFirstHalfGuest(corner_first_half_guest);
        match.setYellowCardFirstHalfHome(yellow_card_first_half_home);
        match.setYellowCardFirstHalfGuest(yellow_card_first_half_guest);
        match.setRedCardFirstHalfHome(red_card_first_half_home);
        match.setRedCardFirstHalfGuest(red_card_first_half_guest);
        match.setFreeKickFirstHalfHome(free_kick_first_half_home);
        match.setFreeKickFirstHalfGuest(free_kick_first_half_guest);
        match.setOffsideFirstHalfHome(offside_first_half_home);
        match.setOffsideFirstHalfGuest(offside_first_half_guest);
        match.setFoulFirstHalfHome(foul_first_half_home);
        match.setFoulFirstHalfGuest(foul_first_half_guest);
        matchRepository.save(match);
        return "redirect:/match";
    }

    @PostMapping("/match/{id}/edit/2")
    public String matchUpdateSecond(@PathVariable(value = "id") int idMatch,
                              @RequestParam int shot_second_half_home,
                              @RequestParam int shot_second_half_guest,
                              @RequestParam int possession_second_half_home,
                              @RequestParam int possession_second_half_guest,
                              @RequestParam int shot_on_target_second_half_home,
                              @RequestParam int shot_on_target_second_half_guest,
                              @RequestParam int corner_second_half_home,
                              @RequestParam int corner_second_half_guest,
                              @RequestParam int yellow_card_second_half_home,
                              @RequestParam int yellow_card_second_half_guest,
                              @RequestParam int red_card_second_half_home,
                              @RequestParam int red_card_second_half_guest,
                              @RequestParam int free_kick_second_half_home,
                              @RequestParam int free_kick_second_half_guest,
                              @RequestParam int offside_second_half_home,
                              @RequestParam int offside_second_half_guest,
                              @RequestParam int foul_second_half_home,
                              @RequestParam int foul_second_half_guest,
                              Model model) {
        match_table match = matchRepository.findById(idMatch).orElseThrow(RuntimeException::new);
        match.setShotSecondHalfHome(shot_second_half_home);
        match.setShotSecondHalfGuest(shot_second_half_guest);
        match.setShotOnTargetSecondHalfHome(shot_on_target_second_half_home);
        match.setShotOnTargetSecondHalfGuest(shot_on_target_second_half_guest);
        match.setPossessionSecondHalfHome(possession_second_half_home);
        match.setPossessionSecondHalfGuest(possession_second_half_guest);
        match.setCornerSecondHalfHome(corner_second_half_home);
        match.setCornerSecondHalfGuest(corner_second_half_guest);
        match.setYellowCardSecondHalfHome(yellow_card_second_half_home);
        match.setYellowCardSecondHalfGuest(yellow_card_second_half_guest);
        match.setRedCardSecondHalfHome(red_card_second_half_home);
        match.setRedCardSecondHalfGuest(red_card_second_half_guest);
        match.setFreeKickSecondHalfHome(free_kick_second_half_home);
        match.setFreeKickSecondHalfGuest(free_kick_second_half_guest);
        match.setOffsideSecondHalfHome(offside_second_half_home);
        match.setOffsideSecondHalfGuest(offside_second_half_guest);
        match.setFoulSecondHalfHome(foul_second_half_home);
        match.setFoulSecondHalfGuest(foul_second_half_guest);
        matchRepository.save(match);
        return "redirect:/match";
    }

    @PostMapping("/match/{id}/edit/3")
    public String matchUpdateExtra(@PathVariable(value = "id") int idMatch,
                              @RequestParam int shot_extra_half_home,
                              @RequestParam int shot_extra_half_guest,
                              @RequestParam int possession_extra_half_home,
                              @RequestParam int possession_extra_half_guest,
                              @RequestParam int shot_on_target_extra_half_home,
                              @RequestParam int shot_on_target_extra_half_guest,
                              @RequestParam int corner_extra_half_home,
                              @RequestParam int corner_extra_half_guest,
                              @RequestParam int yellow_card_extra_half_home,
                              @RequestParam int yellow_card_extra_half_guest,
                              @RequestParam int red_card_extra_half_home,
                              @RequestParam int red_card_extra_half_guest,
                              @RequestParam int free_kick_extra_half_home,
                              @RequestParam int free_kick_extra_half_guest,
                              @RequestParam int offside_extra_half_home,
                              @RequestParam int offside_extra_half_guest,
                              @RequestParam int foul_extra_half_home,
                              @RequestParam int foul_extra_half_guest,
                              Model model) {
        match_table match = matchRepository.findById(idMatch).orElseThrow(RuntimeException::new);
        match.setShotExtraTimeHome(shot_extra_half_home);
        match.setShotExtraTimeGuest(shot_extra_half_guest);
        match.setShotOnTargetExtraTimeHome(shot_on_target_extra_half_home);
        match.setShotOnTargetExtraTimeGuest(shot_on_target_extra_half_guest);
        match.setPossessionExtraTimeHome(possession_extra_half_home);
        match.setPossessionExtraTimeGuest(possession_extra_half_guest);
        match.setCornerExtraTimeHome(corner_extra_half_home);
        match.setCornerExtraTimeGuest(corner_extra_half_guest);
        match.setYellowCardExtraTimeHome(yellow_card_extra_half_home);
        match.setYellowCardExtraTimeGuest(yellow_card_extra_half_guest);
        match.setRedCardExtraTimeHome(red_card_extra_half_home);
        match.setRedCardExtraTimeGuest(red_card_extra_half_guest);
        match.setFreeKickExtraTimeHome(free_kick_extra_half_home);
        match.setFreeKickExtraTimeGuest(free_kick_extra_half_guest);
        match.setOffsideExtraTimeHome(offside_extra_half_home);
        match.setOffsideExtraTimeGuest(offside_extra_half_guest);
        match.setFoulExtraTimeHome(foul_extra_half_home);
        match.setFoulExtraTimeGuest(foul_extra_half_guest);
        matchRepository.save(match);
        return "redirect:/match";
    }

    @PostMapping("/match/{id}/delete")
    public String matchDelete(@PathVariable(value = "id") int idMatch, Model model) {
        match_table match = matchRepository.findById(idMatch).orElseThrow(RuntimeException::new);
        matchRepository.delete(match);
        return "redirect:/match";
    }

    @GetMapping("/match/{id}/analysis")
    public String matchAnalisys(@PathVariable(value = "id") int idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        Optional<match_table> match = matchRepository.findById(idMatch);
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);

        Iterable<match_table> matches = matchRepository.findAll();

        ArrayList<match_table> mt = new ArrayList<>();
        ArrayList<match_table> mg = new ArrayList<>();

        Optional<team> teamHome = teamRepository.findById(match.get().getTeamHome());
        Optional<team> teamGuest = teamRepository.findById(match.get().getTeamGuest());
        //LocalDate today = LocalDate.now();
        for (match_table m : matches) {
            if (m.getTeamHome() == match.get().getTeamHome()) {
                //if (m.getDateMatch() ) {
                    Optional<match_table> mth = matchRepository.findById(m.getIdMatch());

                    mth.ifPresent(mt::add);
                    //model.addAttribute("matches_home", mt);
                //}
            } else if (m.getTeamGuest() == match.get().getTeamGuest()) {
                Optional<match_table> mtg = matchRepository.findById(m.getIdMatch());

                mtg.ifPresent(mg::add);
                //model.addAttribute("matches_guest", mg);
            }
        }
        ArrayList<match_table> lastMatchesHomeTeam = new ArrayList<>();
        ArrayList<match_table> lastMatchesHomeTeambyLevel = new ArrayList<>();
        ArrayList<team> lastMatchesHomeTeamHName = new ArrayList<>();
        ArrayList<team> lastMatchesHomeTeamGName = new ArrayList<>();
        int i = 0;
        int j = Math.min(mt.size(), 9);
//        while(lastMatchesHomeTeam.size() != 10) { -- лучшее решение
//            if (mt.get(i) == null) {
//                break;
//            }
        while(i != j) {
            if (match.get().getDateMatch().isAfter(mt.get(i).getDateMatch())) {
                Optional<match_table> mat = matchRepository.findById(mt.get(i).getIdMatch());

                mat.ifPresent(lastMatchesHomeTeam::add);
                model.addAttribute("last_home", lastMatchesHomeTeam);

                Optional<team> byLevelGuest = teamRepository.findById(mt.get(i).getTeamGuest());

                if (teamHome.get().getLevelTeam() == byLevelGuest.get().getLevelTeam()) {
                    Optional<match_table> lvlh = matchRepository.findById(mt.get(i).getIdMatch());
                    Optional<team> team_home = teamRepository.findById(mt.get(i).getTeamHome());
                    Optional<team> team_guest = teamRepository.findById(mt.get(i).getTeamGuest());

                    team_home.ifPresent(lastMatchesHomeTeamHName::add);
                    team_guest.ifPresent(lastMatchesHomeTeamGName::add);
                    lvlh.ifPresent(lastMatchesHomeTeambyLevel::add);
                    model.addAttribute("level_home", lastMatchesHomeTeambyLevel);
                    model.addAttribute("home_table_home_level", lastMatchesHomeTeamHName);
                    model.addAttribute("home_table_guest_level", lastMatchesHomeTeamGName);
                }
            }
            i++;
        }
        ArrayList<match_table> lastMatchesGuestTeam = new ArrayList<>();
        ArrayList<match_table> lastMatchesGuestTeambyLevel = new ArrayList<>();
        ArrayList<team> lastMatchesGuestTeamHName = new ArrayList<>();
        ArrayList<team> lastMatchesGuestTeamGName = new ArrayList<>();
        i = 0;
        j = Math.min(mg.size(), 9);
        while(i != j) {
            if (match.get().getDateMatch().isAfter(mg.get(i).getDateMatch())) {
                Optional<match_table> mat = matchRepository.findById(mg.get(i).getIdMatch());

                mat.ifPresent(lastMatchesGuestTeam::add);
                model.addAttribute("last_guest", lastMatchesGuestTeam);

                Optional<team> byLevelHome = teamRepository.findById(mg.get(i).getTeamHome());

                if (teamGuest.get().getLevelTeam() == byLevelHome.get().getLevelTeam()) {
                    Optional<match_table> lvlg = matchRepository.findById(mg.get(i).getIdMatch());
                    Optional<team> team_home = teamRepository.findById(mt.get(i).getTeamHome());
                    Optional<team> team_guest = teamRepository.findById(mt.get(i).getTeamGuest());

                    team_home.ifPresent(lastMatchesGuestTeamHName::add);
                    team_guest.ifPresent(lastMatchesGuestTeamGName::add);
                    lvlg.ifPresent(lastMatchesGuestTeambyLevel::add);
                    model.addAttribute("level_guest", lastMatchesGuestTeambyLevel);
                    model.addAttribute("guest_table_home_level", lastMatchesGuestTeamHName);
                    model.addAttribute("guest_table_guest_level", lastMatchesGuestTeamGName);
                }
            }
            i++;
        }

        Collections.sort(lastMatchesHomeTeam);
        Collections.sort(lastMatchesGuestTeam);
        Collections.sort(lastMatchesHomeTeambyLevel);
        Collections.sort(lastMatchesGuestTeambyLevel);

        ArrayList<team> th = new ArrayList<>();
        ArrayList<team> tg = new ArrayList<>();
        double shots_home = 0, shots_away = 0;
        double possession_home = 0, possession_away = 0;
        double shots_on_target_home = 0, shots_on_target_away = 0;
        double corners_home = 0, corners_away = 0;
        double yellow_card_home = 0, yellow_card_away = 0;
        double red_card_home = 0, red_card_away = 0;
        double free_kicks_home = 0, free_kicks_away = 0;
        double offsides_home = 0, offsides_away = 0;
        double fouls_home = 0, fouls_away = 0;

        for (match_table teams : lastMatchesHomeTeam) {
            Optional<team> team_home = teamRepository.findById(teams.getTeamHome());
            Optional<team> team_guest = teamRepository.findById(teams.getTeamGuest());

            shots_home += teams.getShotFirstHalfHome() + teams.getShotSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            shots_away += teams.getShotFirstHalfGuest() + teams.getShotSecondHalfGuest();
            possession_home += teams.getPossessionFirstHalfHome() + teams.getPossessionSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            possession_away += teams.getPossessionFirstHalfGuest() + teams.getPossessionSecondHalfGuest();
            shots_on_target_home += teams.getShotOnTargetFirstHalfHome() + teams.getShotOnTargetSecondHalfHome();
            shots_on_target_away += teams.getShotOnTargetFirstHalfGuest() + teams.getShotOnTargetSecondHalfGuest();
            corners_home += teams.getCornerFirstHalfHome() + teams.getCornerSecondHalfHome();
            corners_away += teams.getCornerFirstHalfGuest() + teams.getCornerSecondHalfGuest();
            yellow_card_home += teams.getYellowCardFirstHalfHome() + teams.getYellowCardSecondHalfHome();
            yellow_card_away += teams.getYellowCardFirstHalfGuest() + teams.getYellowCardSecondHalfGuest();
            red_card_home += teams.getRedCardFirstHalfHome() + teams.getRedCardSecondHalfHome();
            red_card_away += teams.getRedCardFirstHalfGuest() + teams.getRedCardSecondHalfGuest();
            free_kicks_home += teams.getFreeKickFirstHalfHome() + teams.getFreeKickSecondHalfHome();
            free_kicks_away += teams.getFreeKickFirstHalfGuest() + teams.getFreeKickSecondHalfGuest();
            offsides_home += teams.getOffsideFirstHalfHome() + teams.getOffsideSecondHalfHome();
            offsides_away += teams.getOffsideFirstHalfGuest() + teams.getOffsideSecondHalfGuest();
            fouls_home += teams.getFoulFirstHalfHome() + teams.getFoulSecondHalfHome();
            fouls_away += teams.getFoulFirstHalfGuest() + teams.getFoulSecondHalfGuest();

            team_home.ifPresent(th::add);
            team_guest.ifPresent(tg::add);
            model.addAttribute("home_table_home", th);
            model.addAttribute("home_table_guest", tg);
        }
        model.addAttribute("shots_home_stat_table_home", String.format("%.2f", shots_home / lastMatchesHomeTeam.size()));
        model.addAttribute("shots_away_stat_table_home", String.format("%.2f", shots_away / lastMatchesHomeTeam.size()));
        model.addAttribute("shots_away_stat_table_home_all", String.format("%.2f", shots_home / lastMatchesHomeTeam.size() + shots_away / lastMatchesHomeTeam.size()));
        model.addAttribute("possession_home_stat_table_home", String.format("%.0f", possession_home / lastMatchesHomeTeam.size() / 2));
        model.addAttribute("possession_away_stat_table_home", String.format("%.0f", possession_away / lastMatchesHomeTeam.size() / 2));
        model.addAttribute("shots_on_target_home_stat_table_home", String.format("%.2f", shots_on_target_home / lastMatchesHomeTeam.size()));
        model.addAttribute("shots_on_target_away_stat_table_home", String.format("%.2f", shots_on_target_away / lastMatchesHomeTeam.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_all", String.format("%.2f", shots_on_target_home / lastMatchesHomeTeam.size() + shots_on_target_away / lastMatchesHomeTeam.size()));
        model.addAttribute("corners_home_stat_table_home", String.format("%.2f", corners_home / lastMatchesHomeTeam.size()));
        model.addAttribute("corners_away_stat_table_home", String.format("%.2f", corners_away / lastMatchesHomeTeam.size()));
        model.addAttribute("corners_away_stat_table_home_all", String.format("%.2f", corners_home / lastMatchesHomeTeam.size() + corners_away / lastMatchesHomeTeam.size()));
        model.addAttribute("yellow_card_home_stat_table_home", String.format("%.2f", yellow_card_home / lastMatchesHomeTeam.size()));
        model.addAttribute("yellow_card_away_stat_table_home", String.format("%.2f", yellow_card_away / lastMatchesHomeTeam.size()));
        model.addAttribute("yellow_card_away_stat_table_home_all", String.format("%.2f", yellow_card_home / lastMatchesHomeTeam.size() + yellow_card_away / lastMatchesHomeTeam.size()));
        model.addAttribute("red_card_home_stat_table_home", String.format("%.2f", red_card_home / lastMatchesHomeTeam.size()));
        model.addAttribute("red_card_away_stat_table_home", String.format("%.2f", red_card_away / lastMatchesHomeTeam.size()));
        model.addAttribute("red_card_away_stat_table_home_all", String.format("%.2f", red_card_home / lastMatchesHomeTeam.size() + red_card_away / lastMatchesHomeTeam.size()));
        model.addAttribute("free_kicks_home_stat_table_home", String.format("%.2f", free_kicks_home / lastMatchesHomeTeam.size()));
        model.addAttribute("free_kicks_away_stat_table_home", String.format("%.2f", free_kicks_away / lastMatchesHomeTeam.size()));
        model.addAttribute("free_kicks_away_stat_table_home_all", String.format("%.2f", free_kicks_home / lastMatchesHomeTeam.size() + free_kicks_away / lastMatchesHomeTeam.size()));
        model.addAttribute("offsides_home_stat_table_home", String.format("%.2f", offsides_home / lastMatchesHomeTeam.size()));
        model.addAttribute("offsides_away_stat_table_home", String.format("%.2f", offsides_away / lastMatchesHomeTeam.size()));
        model.addAttribute("offsides_home_stat_table_home_all", String.format("%.2f", offsides_home / lastMatchesHomeTeam.size() + offsides_away / lastMatchesHomeTeam.size()));
        model.addAttribute("fouls_home_stat_table_home", String.format("%.2f", fouls_home / lastMatchesHomeTeam.size()));
        model.addAttribute("fouls_away_stat_table_home", String.format("%.2f", fouls_away / lastMatchesHomeTeam.size()));
        model.addAttribute("fouls_home_stat_table_home_all", String.format("%.2f", fouls_home / lastMatchesHomeTeam.size() + fouls_away / lastMatchesHomeTeam.size()));


        ArrayList<team> th2 = new ArrayList<>();
        ArrayList<team> tg2 = new ArrayList<>();
        shots_home = 0; shots_away = 0;
        possession_home = 0; possession_away = 0;
        shots_on_target_home = 0; shots_on_target_away = 0;
        corners_home = 0; corners_away = 0;
        yellow_card_home = 0; yellow_card_away = 0;
        red_card_home = 0; red_card_away = 0;
        free_kicks_home = 0; free_kicks_away = 0;
        offsides_home = 0; offsides_away = 0;
        fouls_home = 0; fouls_away = 0;
        for (match_table teams : lastMatchesGuestTeam) {
            Optional<team> team_home = teamRepository.findById(teams.getTeamHome());
            Optional<team> team_guest = teamRepository.findById(teams.getTeamGuest());

            shots_home += teams.getShotFirstHalfHome() + teams.getShotSecondHalfHome();//ВАЖНА ГОСТЕВАЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            shots_away += teams.getShotFirstHalfGuest() + teams.getShotSecondHalfGuest();
            possession_home += teams.getPossessionFirstHalfHome() + teams.getPossessionSecondHalfHome();//ВАЖНА ГОСТЕВАЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            possession_away += teams.getPossessionFirstHalfGuest() + teams.getPossessionSecondHalfGuest();
            shots_on_target_home += teams.getShotOnTargetFirstHalfHome() + teams.getShotOnTargetSecondHalfHome();
            shots_on_target_away += teams.getShotOnTargetFirstHalfGuest() + teams.getShotOnTargetSecondHalfGuest();
            corners_home += teams.getCornerFirstHalfHome() + teams.getCornerSecondHalfHome();
            corners_away += teams.getCornerFirstHalfGuest() + teams.getCornerSecondHalfGuest();
            yellow_card_home += teams.getYellowCardFirstHalfHome() + teams.getYellowCardSecondHalfHome();
            yellow_card_away += teams.getYellowCardFirstHalfGuest() + teams.getYellowCardSecondHalfGuest();
            red_card_home += teams.getRedCardFirstHalfHome() + teams.getRedCardSecondHalfHome();
            red_card_away += teams.getRedCardFirstHalfGuest() + teams.getRedCardSecondHalfGuest();
            free_kicks_home += teams.getFreeKickFirstHalfHome() + teams.getFreeKickSecondHalfHome();
            free_kicks_away += teams.getFreeKickFirstHalfGuest() + teams.getFreeKickSecondHalfGuest();
            offsides_home += teams.getOffsideFirstHalfHome() + teams.getOffsideSecondHalfHome();
            offsides_away += teams.getOffsideFirstHalfGuest() + teams.getOffsideSecondHalfGuest();
            fouls_home += teams.getFoulFirstHalfHome() + teams.getFoulSecondHalfHome();
            fouls_away += teams.getFoulFirstHalfGuest() + teams.getFoulSecondHalfGuest();

            team_home.ifPresent(th2::add);
            team_guest.ifPresent(tg2::add);
            model.addAttribute("guest_table_home", th2);
            model.addAttribute("guest_table_guest", tg2);
        }
        model.addAttribute("shots_home_stat_table_away", String.format("%.2f",shots_home / lastMatchesGuestTeam.size()));
        model.addAttribute("shots_away_stat_table_away", String.format("%.2f",shots_away / lastMatchesGuestTeam.size()));
        model.addAttribute("shots_away_stat_table_away_all", String.format("%.2f", shots_home / lastMatchesGuestTeam.size() + shots_away / lastMatchesGuestTeam.size()));
        model.addAttribute("possession_home_stat_table_away", String.format("%.0f",possession_home / lastMatchesGuestTeam.size() / 2));
        model.addAttribute("possession_away_stat_table_away", String.format("%.0f",possession_away / lastMatchesGuestTeam.size() / 2));
        model.addAttribute("shots_on_target_home_stat_table_away", String.format("%.2f",shots_on_target_home / lastMatchesGuestTeam.size()));
        model.addAttribute("shots_on_target_away_stat_table_away", String.format("%.2f",shots_on_target_away / lastMatchesGuestTeam.size()));
        model.addAttribute("shots_on_target_away_stat_table_away_all", String.format("%.2f", shots_on_target_home / lastMatchesGuestTeam.size() + shots_on_target_away / lastMatchesGuestTeam.size()));
        model.addAttribute("corners_home_stat_table_away", String.format("%.2f", corners_home / lastMatchesGuestTeam.size()));
        model.addAttribute("corners_away_stat_table_away", String.format("%.2f", corners_away / lastMatchesGuestTeam.size()));
        model.addAttribute("corners_away_stat_table_away_all", String.format("%.2f", corners_home / lastMatchesGuestTeam.size() + corners_away / lastMatchesGuestTeam.size()));
        model.addAttribute("yellow_card_home_stat_table_away", String.format("%.2f", yellow_card_home / lastMatchesGuestTeam.size()));
        model.addAttribute("yellow_card_away_stat_table_away", String.format("%.2f", yellow_card_away / lastMatchesGuestTeam.size()));
        model.addAttribute("yellow_card_away_stat_table_away_all", String.format("%.2f", yellow_card_home / lastMatchesGuestTeam.size() + yellow_card_away / lastMatchesGuestTeam.size()));
        model.addAttribute("red_card_home_stat_table_away", String.format("%.2f",red_card_home / lastMatchesGuestTeam.size()));
        model.addAttribute("red_card_away_stat_table_away", String.format("%.2f",red_card_away / lastMatchesGuestTeam.size()));
        model.addAttribute("red_card_away_stat_table_away_all", String.format("%.2f", red_card_home / lastMatchesGuestTeam.size() + red_card_away / lastMatchesGuestTeam.size()));
        model.addAttribute("free_kicks_home_stat_table_away", String.format("%.2f",free_kicks_home / lastMatchesGuestTeam.size()));
        model.addAttribute("free_kicks_away_stat_table_away", String.format("%.2f",free_kicks_away / lastMatchesGuestTeam.size()));
        model.addAttribute("free_kicks_away_stat_table_away_all", String.format("%.2f", free_kicks_home / lastMatchesGuestTeam.size() + free_kicks_away / lastMatchesGuestTeam.size()));
        model.addAttribute("offsides_home_stat_table_away", String.format("%.2f",offsides_home / lastMatchesGuestTeam.size()));
        model.addAttribute("offsides_away_stat_table_away", String.format("%.2f",offsides_away / lastMatchesGuestTeam.size()));
        model.addAttribute("offsides_home_stat_table_away_all", String.format("%.2f", offsides_home / lastMatchesGuestTeam.size() + offsides_away / lastMatchesGuestTeam.size()));
        model.addAttribute("fouls_home_stat_table_away", String.format("%.2f",fouls_home / lastMatchesGuestTeam.size()));
        model.addAttribute("fouls_away_stat_table_away", String.format("%.2f",fouls_away / lastMatchesGuestTeam.size()));
        model.addAttribute("fouls_away_stat_table_away_all", String.format("%.2f", fouls_home / lastMatchesGuestTeam.size() + fouls_away / lastMatchesGuestTeam.size()));

        ArrayList<team> th3 = new ArrayList<>();
        ArrayList<team> tg3 = new ArrayList<>();
        shots_home = 0; shots_away = 0;
        possession_home = 0; possession_away = 0;
        shots_on_target_home = 0; shots_on_target_away = 0;
        corners_home = 0; corners_away = 0;
        yellow_card_home = 0; yellow_card_away = 0;
        red_card_home = 0; red_card_away = 0;
        free_kicks_home = 0; free_kicks_away = 0;
        offsides_home = 0; offsides_away = 0;
        fouls_home = 0; fouls_away = 0;

        for (match_table teams : lastMatchesHomeTeambyLevel) {
            Optional<team> team_home = teamRepository.findById(teams.getTeamHome());
            Optional<team> team_guest = teamRepository.findById(teams.getTeamGuest());

            shots_home += teams.getShotFirstHalfHome() + teams.getShotSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            shots_away += teams.getShotFirstHalfGuest() + teams.getShotSecondHalfGuest();
            possession_home += teams.getPossessionFirstHalfHome() + teams.getPossessionSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            possession_away += teams.getPossessionFirstHalfGuest() + teams.getPossessionSecondHalfGuest();
            shots_on_target_home += teams.getShotOnTargetFirstHalfHome() + teams.getShotOnTargetSecondHalfHome();
            shots_on_target_away += teams.getShotOnTargetFirstHalfGuest() + teams.getShotOnTargetSecondHalfGuest();
            corners_home += teams.getCornerFirstHalfHome() + teams.getCornerSecondHalfHome();
            corners_away += teams.getCornerFirstHalfGuest() + teams.getCornerSecondHalfGuest();
            yellow_card_home += teams.getYellowCardFirstHalfHome() + teams.getYellowCardSecondHalfHome();
            yellow_card_away += teams.getYellowCardFirstHalfGuest() + teams.getYellowCardSecondHalfGuest();
            red_card_home += teams.getRedCardFirstHalfHome() + teams.getRedCardSecondHalfHome();
            red_card_away += teams.getRedCardFirstHalfGuest() + teams.getRedCardSecondHalfGuest();
            free_kicks_home += teams.getFreeKickFirstHalfHome() + teams.getFreeKickSecondHalfHome();
            free_kicks_away += teams.getFreeKickFirstHalfGuest() + teams.getFreeKickSecondHalfGuest();
            offsides_home += teams.getOffsideFirstHalfHome() + teams.getOffsideSecondHalfHome();
            offsides_away += teams.getOffsideFirstHalfGuest() + teams.getOffsideSecondHalfGuest();
            fouls_home += teams.getFoulFirstHalfHome() + teams.getFoulSecondHalfHome();
            fouls_away += teams.getFoulFirstHalfGuest() + teams.getFoulSecondHalfGuest();

            team_home.ifPresent(th3::add);
            team_guest.ifPresent(tg3::add);
            model.addAttribute("home_table_home_level", th3);
            model.addAttribute("home_table_guest_level", tg3);
        }
        model.addAttribute("shots_home_stat_table_home_level", String.format("%.2f", shots_home / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level", String.format("%.2f", shots_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_all", String.format("%.2f", shots_home / lastMatchesHomeTeambyLevel.size() + shots_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("possession_home_stat_table_home_level", String.format("%.0f", possession_home / lastMatchesHomeTeambyLevel.size() / 2));
        model.addAttribute("possession_away_stat_table_home_level", String.format("%.0f", possession_away / lastMatchesHomeTeambyLevel.size() / 2));
        model.addAttribute("shots_on_target_home_stat_table_home_level", String.format("%.2f", shots_on_target_home / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level", String.format("%.2f", shots_on_target_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_all", String.format("%.2f", shots_on_target_home / lastMatchesHomeTeambyLevel.size() + shots_on_target_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_home_stat_table_home_level", String.format("%.2f", corners_home / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level", String.format("%.2f", corners_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_all", String.format("%.2f", corners_home / lastMatchesHomeTeambyLevel.size() + corners_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_home_stat_table_home_level", String.format("%.2f", yellow_card_home / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level", String.format("%.2f", yellow_card_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_all", String.format("%.2f", yellow_card_home / lastMatchesHomeTeambyLevel.size() + yellow_card_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_home_stat_table_home_level", String.format("%.2f", red_card_home / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level", String.format("%.2f", red_card_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_all", String.format("%.2f", red_card_home / lastMatchesHomeTeambyLevel.size() + red_card_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_home_stat_table_home_level", String.format("%.2f", free_kicks_home / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level", String.format("%.2f", free_kicks_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_all", String.format("%.2f", free_kicks_home / lastMatchesHomeTeambyLevel.size() + free_kicks_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_home_stat_table_home_level", String.format("%.2f", offsides_home / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level", String.format("%.2f", offsides_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_all", String.format("%.2f", offsides_home / lastMatchesHomeTeambyLevel.size() + offsides_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_home_stat_table_home_level", String.format("%.2f", fouls_home / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level", String.format("%.2f", fouls_away / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_all", String.format("%.2f", fouls_home / lastMatchesHomeTeambyLevel.size() + fouls_away / lastMatchesHomeTeambyLevel.size()));

        ArrayList<team> th4 = new ArrayList<>();
        ArrayList<team> tg4 = new ArrayList<>();
        shots_home = 0; shots_away = 0;
        possession_home = 0; possession_away = 0;
        shots_on_target_home = 0; shots_on_target_away = 0;
        corners_home = 0; corners_away = 0;
        yellow_card_home = 0; yellow_card_away = 0;
        red_card_home = 0; red_card_away = 0;
        free_kicks_home = 0; free_kicks_away = 0;
        offsides_home = 0; offsides_away = 0;
        fouls_home = 0; fouls_away = 0;
        for (match_table teams : lastMatchesGuestTeambyLevel) {
            Optional<team> team_home = teamRepository.findById(teams.getTeamHome());
            Optional<team> team_guest = teamRepository.findById(teams.getTeamGuest());

            shots_home += teams.getShotFirstHalfHome() + teams.getShotSecondHalfHome();//ВАЖНА ГОСТЕВАЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            shots_away += teams.getShotFirstHalfGuest() + teams.getShotSecondHalfGuest();
            possession_home += teams.getPossessionFirstHalfHome() + teams.getPossessionSecondHalfHome();//ВАЖНА ГОСТЕВАЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            possession_away += teams.getPossessionFirstHalfGuest() + teams.getPossessionSecondHalfGuest();
            shots_on_target_home += teams.getShotOnTargetFirstHalfHome() + teams.getShotOnTargetSecondHalfHome();
            shots_on_target_away += teams.getShotOnTargetFirstHalfGuest() + teams.getShotOnTargetSecondHalfGuest();
            corners_home += teams.getCornerFirstHalfHome() + teams.getCornerSecondHalfHome();
            corners_away += teams.getCornerFirstHalfGuest() + teams.getCornerSecondHalfGuest();
            yellow_card_home += teams.getYellowCardFirstHalfHome() + teams.getYellowCardSecondHalfHome();
            yellow_card_away += teams.getYellowCardFirstHalfGuest() + teams.getYellowCardSecondHalfGuest();
            red_card_home += teams.getRedCardFirstHalfHome() + teams.getRedCardSecondHalfHome();
            red_card_away += teams.getRedCardFirstHalfGuest() + teams.getRedCardSecondHalfGuest();
            free_kicks_home += teams.getFreeKickFirstHalfHome() + teams.getFreeKickSecondHalfHome();
            free_kicks_away += teams.getFreeKickFirstHalfGuest() + teams.getFreeKickSecondHalfGuest();
            offsides_home += teams.getOffsideFirstHalfHome() + teams.getOffsideSecondHalfHome();
            offsides_away += teams.getOffsideFirstHalfGuest() + teams.getOffsideSecondHalfGuest();
            fouls_home += teams.getFoulFirstHalfHome() + teams.getFoulSecondHalfHome();
            fouls_away += teams.getFoulFirstHalfGuest() + teams.getFoulSecondHalfGuest();

            team_home.ifPresent(th4::add);
            team_guest.ifPresent(tg4::add);
            model.addAttribute("guest_table_home_level", th4);
            model.addAttribute("guest_table_guest_level", tg4);
        }
        model.addAttribute("shots_home_stat_table_away_level", String.format("%.2f", shots_home / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_away_level", String.format("%.2f", shots_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_away_level_all", String.format("%.2f", shots_home / lastMatchesGuestTeambyLevel.size() + shots_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("possession_home_stat_table_away_level", String.format("%.0f", possession_home / lastMatchesGuestTeambyLevel.size() / 2));
        model.addAttribute("possession_away_stat_table_away_level", String.format("%.0f", possession_away / lastMatchesGuestTeambyLevel.size() / 2));
        model.addAttribute("shots_on_target_home_stat_table_away_level", String.format("%.2f", shots_on_target_home / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_away_level", String.format("%.2f", shots_on_target_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_away_level_all", String.format("%.2f", shots_on_target_home / lastMatchesGuestTeambyLevel.size() + shots_on_target_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_home_stat_table_away_level", String.format("%.2f", corners_home / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_away_level", String.format("%.2f", corners_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_away_level_all", String.format("%.2f", corners_home / lastMatchesGuestTeambyLevel.size() + corners_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_home_stat_table_away_level", String.format("%.2f", yellow_card_home / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_away_level", String.format("%.2f", yellow_card_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_away_level_all", String.format("%.2f", yellow_card_home / lastMatchesGuestTeambyLevel.size() + yellow_card_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_home_stat_table_away_level", String.format("%.2f", red_card_home / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_away_level", String.format("%.2f", red_card_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_away_level_all", String.format("%.2f", red_card_home / lastMatchesGuestTeambyLevel.size() + red_card_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_home_stat_table_away_level", String.format("%.2f", free_kicks_home / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_away_level", String.format("%.2f", free_kicks_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_away_level_all", String.format("%.2f", free_kicks_home / lastMatchesGuestTeambyLevel.size() + free_kicks_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_home_stat_table_away_level", String.format("%.2f", offsides_home / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_away_level", String.format("%.2f", offsides_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_away_level_all", String.format("%.2f", offsides_home / lastMatchesGuestTeambyLevel.size() + offsides_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_home_stat_table_away_level", String.format("%.2f", fouls_home / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_away_level", String.format("%.2f", fouls_away / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_away_level_all", String.format("%.2f", fouls_home / lastMatchesGuestTeambyLevel.size() + fouls_away / lastMatchesGuestTeambyLevel.size()));

        Optional<team> team_home = teamRepository.findById(match.get().getTeamHome());
        Optional<team> team_guest = teamRepository.findById(match.get().getTeamGuest());
        ArrayList<team> thm = new ArrayList<>();
        ArrayList<team> tgm = new ArrayList<>();
        team_home.ifPresent(thm::add);
        team_guest.ifPresent(tgm::add);
        model.addAttribute("team_home", thm);
        model.addAttribute("team_guest", tgm);
        return "match-analysis";
    }
}
