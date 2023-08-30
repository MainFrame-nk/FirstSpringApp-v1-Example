package nk.mframe.demo.controller;

import nk.mframe.demo.dao.CoefficientRepository;
import nk.mframe.demo.dao.EventRepository;
import nk.mframe.demo.model.coefficient_table;
import nk.mframe.demo.model.event;
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

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CoefficientRepository coefficientRepository;

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
        double shots_home_first_time  = 0, shots_away_first_time  = 0;
        double possession_home_first_time  = 0, possession_away_first_time  = 0;
        double shots_on_target_home_first_time  = 0, shots_on_target_away_first_time  = 0;
        double corners_home_first_time  = 0, corners_away_first_time  = 0;
        double yellow_card_home_first_time  = 0, yellow_card_away_first_time  = 0;
        double red_card_home_first_time  = 0, red_card_away_first_time  = 0;
        double free_kicks_home_first_time  = 0, free_kicks_away_first_time  = 0;
        double offsides_home_first_time  = 0, offsides_away_first_time  = 0;
        double fouls_home_first_time  = 0, fouls_away_first_time  = 0;
        double shots_home_second_time = 0, shots_away_second_time = 0;
        double possession_home_second_time = 0, possession_away_second_time = 0;
        double shots_on_target_home_second_time = 0, shots_on_target_away_second_time = 0;
        double corners_home_second_time = 0, corners_away_second_time = 0;
        double yellow_card_home_second_time = 0, yellow_card_away_second_time = 0;
        double red_card_home_second_time = 0, red_card_away_second_time = 0;
        double free_kicks_home_second_time = 0, free_kicks_away_second_time = 0;
        double offsides_home_second_time = 0, offsides_away_second_time = 0;
        double fouls_home_second_time = 0, fouls_away_second_time = 0;
        double shots_home_all_time = 0, shots_away_all_time = 0;
        double possession_home_all_time = 0, possession_away_all_time = 0;
        double shots_on_target_home_all_time = 0, shots_on_target_away_all_time = 0;
        double corners_home_all_time = 0, corners_away_all_time = 0;
        double yellow_card_home_all_time = 0, yellow_card_away_all_time = 0;
        double red_card_home_all_time = 0, red_card_away_all_time = 0;
        double free_kicks_home_all_time = 0, free_kicks_away_all_time = 0;
        double offsides_home_all_time = 0, offsides_away_all_time = 0;
        double fouls_home_all_time = 0, fouls_away_all_time = 0;

        for (match_table teams : lastMatchesHomeTeambyLevel) {
            Optional<team> team_home = teamRepository.findById(teams.getTeamHome());
            Optional<team> team_guest = teamRepository.findById(teams.getTeamGuest());

            shots_home_first_time += teams.getShotFirstHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            shots_away_first_time  += teams.getShotFirstHalfGuest();
            possession_home_first_time += teams.getPossessionFirstHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            possession_away_first_time  += teams.getPossessionFirstHalfGuest();
            shots_on_target_home_first_time += teams.getShotOnTargetFirstHalfHome();
            shots_on_target_away_first_time  += teams.getShotOnTargetFirstHalfGuest();
            corners_home_first_time += teams.getCornerFirstHalfHome();
            corners_away_first_time  += teams.getCornerFirstHalfGuest();
            yellow_card_home_first_time += teams.getYellowCardFirstHalfHome();
            yellow_card_away_first_time  += teams.getYellowCardFirstHalfGuest();
            red_card_home_first_time += teams.getRedCardFirstHalfHome();
            red_card_away_first_time  += teams.getRedCardFirstHalfGuest();
            free_kicks_home_first_time += teams.getFreeKickFirstHalfHome();
            free_kicks_away_first_time  += teams.getFreeKickFirstHalfGuest();
            offsides_home_first_time += teams.getOffsideFirstHalfHome();
            offsides_away_first_time  += teams.getOffsideFirstHalfGuest();
            fouls_home_first_time += teams.getFoulFirstHalfHome();
            fouls_away_first_time  += teams.getFoulFirstHalfGuest();
            shots_home_second_time += teams.getShotSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            shots_away_second_time += teams.getShotSecondHalfGuest();
            possession_home_second_time += teams.getPossessionSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            possession_away_second_time += teams.getPossessionSecondHalfGuest();
            shots_on_target_home_second_time += teams.getShotOnTargetSecondHalfHome();
            shots_on_target_away_second_time += teams.getShotOnTargetSecondHalfGuest();
            corners_home_second_time += teams.getCornerSecondHalfHome();
            corners_away_second_time += teams.getCornerSecondHalfGuest();
            yellow_card_home_second_time += teams.getYellowCardSecondHalfHome();
            yellow_card_away_second_time += teams.getYellowCardSecondHalfGuest();
            red_card_home_second_time += teams.getRedCardSecondHalfHome();
            red_card_away_second_time += teams.getRedCardSecondHalfGuest();
            free_kicks_home_second_time += teams.getFreeKickSecondHalfHome();
            free_kicks_away_second_time += teams.getFreeKickSecondHalfGuest();
            offsides_home_second_time += teams.getOffsideSecondHalfHome();
            offsides_away_second_time += teams.getOffsideSecondHalfGuest();
            fouls_home_second_time += teams.getFoulSecondHalfHome();
            fouls_away_second_time += teams.getFoulSecondHalfGuest();
            shots_home_all_time += teams.getShotFirstHalfHome() + teams.getShotSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            shots_away_all_time += teams.getShotFirstHalfGuest() + teams.getShotSecondHalfGuest();
            possession_home_all_time += teams.getPossessionFirstHalfHome() + teams.getPossessionSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            possession_away_all_time += teams.getPossessionFirstHalfGuest() + teams.getPossessionSecondHalfGuest();
            shots_on_target_home_all_time += teams.getShotOnTargetFirstHalfHome() + teams.getShotOnTargetSecondHalfHome();
            shots_on_target_away_all_time += teams.getShotOnTargetFirstHalfGuest() + teams.getShotOnTargetSecondHalfGuest();
            corners_home_all_time += teams.getCornerFirstHalfHome() + teams.getCornerSecondHalfHome();
            corners_away_all_time += teams.getCornerFirstHalfGuest() + teams.getCornerSecondHalfGuest();
            yellow_card_home_all_time += teams.getYellowCardFirstHalfHome() + teams.getYellowCardSecondHalfHome();
            yellow_card_away_all_time += teams.getYellowCardFirstHalfGuest() + teams.getYellowCardSecondHalfGuest();
            red_card_home_all_time += teams.getRedCardFirstHalfHome() + teams.getRedCardSecondHalfHome();
            red_card_away_all_time += teams.getRedCardFirstHalfGuest() + teams.getRedCardSecondHalfGuest();
            free_kicks_home_all_time += teams.getFreeKickFirstHalfHome() + teams.getFreeKickSecondHalfHome();
            free_kicks_away_all_time += teams.getFreeKickFirstHalfGuest() + teams.getFreeKickSecondHalfGuest();
            offsides_home_all_time += teams.getOffsideFirstHalfHome() + teams.getOffsideSecondHalfHome();
            offsides_away_all_time += teams.getOffsideFirstHalfGuest() + teams.getOffsideSecondHalfGuest();
            fouls_home_all_time += teams.getFoulFirstHalfHome() + teams.getFoulSecondHalfHome();
            fouls_away_all_time += teams.getFoulFirstHalfGuest() + teams.getFoulSecondHalfGuest();

            team_home.ifPresent(th3::add);
            team_guest.ifPresent(tg3::add);
            model.addAttribute("home_table_home_level", th3);
            model.addAttribute("home_table_guest_level", tg3);
        }
        model.addAttribute("shots_home_stat_table_home_level_first_time", String.format("%.2f", shots_home_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_first_time", String.format("%.2f", shots_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_first_time_all", String.format("%.2f", shots_home_first_time / lastMatchesHomeTeambyLevel.size() + shots_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("possession_home_stat_table_home_level_first_time", String.format("%.0f", possession_home_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("possession_away_stat_table_home_level_first_time", String.format("%.0f", possession_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_on_target_home_stat_table_home_level_first_time", String.format("%.2f", shots_on_target_home_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_first_time", String.format("%.2f", shots_on_target_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_first_time_all", String.format("%.2f", shots_on_target_home_first_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_home_stat_table_home_level_first_time", String.format("%.2f", corners_home_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_first_time", String.format("%.2f", corners_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_first_time_all", String.format("%.2f", corners_home_first_time / lastMatchesHomeTeambyLevel.size() + corners_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_home_stat_table_home_level_first_time", String.format("%.2f", yellow_card_home_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_first_time", String.format("%.2f", yellow_card_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_first_time_all", String.format("%.2f", yellow_card_home_first_time / lastMatchesHomeTeambyLevel.size() + yellow_card_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_home_stat_table_home_level_first_time", String.format("%.2f", red_card_home_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_first_time", String.format("%.2f", red_card_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_first_time_all", String.format("%.2f", red_card_home_first_time / lastMatchesHomeTeambyLevel.size() + red_card_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_home_stat_table_home_level_first_time", String.format("%.2f", free_kicks_home_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_first_time", String.format("%.2f", free_kicks_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_first_time_all", String.format("%.2f", free_kicks_home_first_time / lastMatchesHomeTeambyLevel.size() + free_kicks_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_home_stat_table_home_level_first_time", String.format("%.2f", offsides_home_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_first_time", String.format("%.2f", offsides_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_first_time_all", String.format("%.2f", offsides_home_first_time / lastMatchesHomeTeambyLevel.size() + offsides_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_home_stat_table_home_level_first_time", String.format("%.2f", fouls_home_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_first_time", String.format("%.2f", fouls_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_first_time_all", String.format("%.2f", fouls_home_first_time / lastMatchesHomeTeambyLevel.size() + fouls_away_first_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_home_stat_table_home_level_second_time", String.format("%.2f", shots_home_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_second_time", String.format("%.2f", shots_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_second_time_all", String.format("%.2f", shots_home_second_time / lastMatchesHomeTeambyLevel.size() + shots_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("possession_home_stat_table_home_level_second_time", String.format("%.0f", possession_home_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("possession_away_stat_table_home_level_second_time", String.format("%.0f", possession_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_on_target_home_stat_table_home_level_second_time", String.format("%.2f", shots_on_target_home_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_second_time", String.format("%.2f", shots_on_target_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_second_time_all", String.format("%.2f", shots_on_target_home_second_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_home_stat_table_home_level_second_time", String.format("%.2f", corners_home_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_second_time", String.format("%.2f", corners_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_second_time_all", String.format("%.2f", corners_home_second_time / lastMatchesHomeTeambyLevel.size() + corners_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_home_stat_table_home_level_second_time", String.format("%.2f", yellow_card_home_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_second_time", String.format("%.2f", yellow_card_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_second_time_all", String.format("%.2f", yellow_card_home_second_time / lastMatchesHomeTeambyLevel.size() + yellow_card_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_home_stat_table_home_level_second_time", String.format("%.2f", red_card_home_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_second_time", String.format("%.2f", red_card_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_second_time_all", String.format("%.2f", red_card_home_second_time / lastMatchesHomeTeambyLevel.size() + red_card_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_home_stat_table_home_level_second_time", String.format("%.2f", free_kicks_home_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_second_time", String.format("%.2f", free_kicks_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_second_time_all", String.format("%.2f", free_kicks_home_second_time / lastMatchesHomeTeambyLevel.size() + free_kicks_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_home_stat_table_home_level_second_time", String.format("%.2f", offsides_home_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_second_time", String.format("%.2f", offsides_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_second_time_all", String.format("%.2f", offsides_home_second_time / lastMatchesHomeTeambyLevel.size() + offsides_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_home_stat_table_home_level_second_time", String.format("%.2f", fouls_home_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_second_time", String.format("%.2f", fouls_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_second_time_all", String.format("%.2f", fouls_home_second_time / lastMatchesHomeTeambyLevel.size() + fouls_away_second_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_home_stat_table_home_level_all_time", String.format("%.2f", shots_home_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_all_time", String.format("%.2f", shots_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_all_time_all", String.format("%.2f", shots_home_all_time / lastMatchesHomeTeambyLevel.size() + shots_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("possession_home_stat_table_home_level_all_time", String.format("%.0f", possession_home_all_time / lastMatchesHomeTeambyLevel.size() / 2));
        model.addAttribute("possession_away_stat_table_home_level_all_time", String.format("%.0f", possession_away_all_time / lastMatchesHomeTeambyLevel.size() / 2));
        model.addAttribute("shots_on_target_home_stat_table_home_level_all_time", String.format("%.2f", shots_on_target_home_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_all_time", String.format("%.2f", shots_on_target_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_all_time_all", String.format("%.2f", shots_on_target_home_all_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_home_stat_table_home_level_all_time", String.format("%.2f", corners_home_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_all_time", String.format("%.2f", corners_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_all_time_all", String.format("%.2f", corners_home_all_time / lastMatchesHomeTeambyLevel.size() + corners_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_home_stat_table_home_level_all_time", String.format("%.2f", yellow_card_home_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_all_time", String.format("%.2f", yellow_card_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_all_time_all", String.format("%.2f", yellow_card_home_all_time / lastMatchesHomeTeambyLevel.size() + yellow_card_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_home_stat_table_home_level_all_time", String.format("%.2f", red_card_home_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_all_time", String.format("%.2f", red_card_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_all_time_all", String.format("%.2f", red_card_home_all_time / lastMatchesHomeTeambyLevel.size() + red_card_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_home_stat_table_home_level_all_time", String.format("%.2f", free_kicks_home_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_all_time", String.format("%.2f", free_kicks_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_all_time_all", String.format("%.2f", free_kicks_home_all_time / lastMatchesHomeTeambyLevel.size() + free_kicks_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_home_stat_table_home_level_all_time", String.format("%.2f", offsides_home_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_all_time", String.format("%.2f", offsides_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_all_time_all", String.format("%.2f", offsides_home_all_time / lastMatchesHomeTeambyLevel.size() + offsides_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_home_stat_table_home_level_all_time", String.format("%.2f", fouls_home_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_all_time", String.format("%.2f", fouls_away_all_time / lastMatchesHomeTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_all_time_all", String.format("%.2f", fouls_home_all_time / lastMatchesHomeTeambyLevel.size() + fouls_away_all_time / lastMatchesHomeTeambyLevel.size()));

        ArrayList<team> th4 = new ArrayList<>();
        ArrayList<team> tg4 = new ArrayList<>();
        double shots_home_first_time2  = 0, shots_away_first_time2  = 0;
        double possession_home_first_time2  = 0, possession_away_first_time2  = 0;
        double shots_on_target_home_first_time2  = 0, shots_on_target_away_first_time2  = 0;
        double corners_home_first_time2  = 0, corners_away_first_time2  = 0;
        double yellow_card_home_first_time2  = 0, yellow_card_away_first_time2  = 0;
        double red_card_home_first_time2  = 0, red_card_away_first_time2  = 0;
        double free_kicks_home_first_time2  = 0, free_kicks_away_first_time2  = 0;
        double offsides_home_first_time2  = 0, offsides_away_first_time2  = 0;
        double fouls_home_first_time2  = 0, fouls_away_first_time2  = 0;
        double shots_home_second_time2 = 0, shots_away_second_time2 = 0;
        double possession_home_second_time2 = 0, possession_away_second_time2 = 0;
        double shots_on_target_home_second_time2 = 0, shots_on_target_away_second_time2 = 0;
        double corners_home_second_time2 = 0, corners_away_second_time2 = 0;
        double yellow_card_home_second_time2 = 0, yellow_card_away_second_time2 = 0;
        double red_card_home_second_time2 = 0, red_card_away_second_time2 = 0;
        double free_kicks_home_second_time2 = 0, free_kicks_away_second_time2 = 0;
        double offsides_home_second_time2 = 0, offsides_away_second_time2 = 0;
        double fouls_home_second_time2 = 0, fouls_away_second_time2 = 0;
        double shots_home_all_time2 = 0, shots_away_all_time2 = 0;
        double possession_home_all_time2 = 0, possession_away_all_time2 = 0;
        double shots_on_target_home_all_time2 = 0, shots_on_target_away_all_time2 = 0;
        double corners_home_all_time2 = 0, corners_away_all_time2 = 0;
        double yellow_card_home_all_time2 = 0, yellow_card_away_all_time2 = 0;
        double red_card_home_all_time2 = 0, red_card_away_all_time2 = 0;
        double free_kicks_home_all_time2 = 0, free_kicks_away_all_time2 = 0;
        double offsides_home_all_time2 = 0, offsides_away_all_time2 = 0;
        double fouls_home_all_time2 = 0, fouls_away_all_time2 = 0;
        for (match_table teams : lastMatchesGuestTeambyLevel) {
            Optional<team> team_home = teamRepository.findById(teams.getTeamHome());
            Optional<team> team_guest = teamRepository.findById(teams.getTeamGuest());

            shots_home_first_time2 += teams.getShotFirstHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            shots_away_first_time2  += teams.getShotFirstHalfGuest();
            possession_home_first_time2 += teams.getPossessionFirstHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            possession_away_first_time2  += teams.getPossessionFirstHalfGuest();
            shots_on_target_home_first_time2 += teams.getShotOnTargetFirstHalfHome();
            shots_on_target_away_first_time2  += teams.getShotOnTargetFirstHalfGuest();
            corners_home_first_time2 += teams.getCornerFirstHalfHome();
            corners_away_first_time2  += teams.getCornerFirstHalfGuest();
            yellow_card_home_first_time2 += teams.getYellowCardFirstHalfHome();
            yellow_card_away_first_time2  += teams.getYellowCardFirstHalfGuest();
            red_card_home_first_time2 += teams.getRedCardFirstHalfHome();
            red_card_away_first_time2  += teams.getRedCardFirstHalfGuest();
            free_kicks_home_first_time2 += teams.getFreeKickFirstHalfHome();
            free_kicks_away_first_time2  += teams.getFreeKickFirstHalfGuest();
            offsides_home_first_time2 += teams.getOffsideFirstHalfHome();
            offsides_away_first_time2  += teams.getOffsideFirstHalfGuest();
            fouls_home_first_time2 += teams.getFoulFirstHalfHome();
            fouls_away_first_time2  += teams.getFoulFirstHalfGuest();
            shots_home_second_time2 += teams.getShotSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            shots_away_second_time2 += teams.getShotSecondHalfGuest();
            possession_home_second_time2 += teams.getPossessionSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            possession_away_second_time2 += teams.getPossessionSecondHalfGuest();
            shots_on_target_home_second_time2 += teams.getShotOnTargetSecondHalfHome();
            shots_on_target_away_second_time2 += teams.getShotOnTargetSecondHalfGuest();
            corners_home_second_time2 += teams.getCornerSecondHalfHome();
            corners_away_second_time2 += teams.getCornerSecondHalfGuest();
            yellow_card_home_second_time2 += teams.getYellowCardSecondHalfHome();
            yellow_card_away_second_time2 += teams.getYellowCardSecondHalfGuest();
            red_card_home_second_time2 += teams.getRedCardSecondHalfHome();
            red_card_away_second_time2 += teams.getRedCardSecondHalfGuest();
            free_kicks_home_second_time2 += teams.getFreeKickSecondHalfHome();
            free_kicks_away_second_time2 += teams.getFreeKickSecondHalfGuest();
            offsides_home_second_time2 += teams.getOffsideSecondHalfHome();
            offsides_away_second_time2 += teams.getOffsideSecondHalfGuest();
            fouls_home_second_time2 += teams.getFoulSecondHalfHome();
            fouls_away_second_time2 += teams.getFoulSecondHalfGuest();
            shots_home_all_time2 += teams.getShotFirstHalfHome() + teams.getShotSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            shots_away_all_time2 += teams.getShotFirstHalfGuest() + teams.getShotSecondHalfGuest();
            possession_home_all_time2 += teams.getPossessionFirstHalfHome() + teams.getPossessionSecondHalfHome();//ВАЖНА ДОМАШНЯЯ СТАТИСТИКА!!!!!!!!!!!!!!!!!!!!!!!
            possession_away_all_time2 += teams.getPossessionFirstHalfGuest() + teams.getPossessionSecondHalfGuest();
            shots_on_target_home_all_time2 += teams.getShotOnTargetFirstHalfHome() + teams.getShotOnTargetSecondHalfHome();
            shots_on_target_away_all_time2 += teams.getShotOnTargetFirstHalfGuest() + teams.getShotOnTargetSecondHalfGuest();
            corners_home_all_time2 += teams.getCornerFirstHalfHome() + teams.getCornerSecondHalfHome();
            corners_away_all_time2 += teams.getCornerFirstHalfGuest() + teams.getCornerSecondHalfGuest();
            yellow_card_home_all_time2 += teams.getYellowCardFirstHalfHome() + teams.getYellowCardSecondHalfHome();
            yellow_card_away_all_time2 += teams.getYellowCardFirstHalfGuest() + teams.getYellowCardSecondHalfGuest();
            red_card_home_all_time2 += teams.getRedCardFirstHalfHome() + teams.getRedCardSecondHalfHome();
            red_card_away_all_time2 += teams.getRedCardFirstHalfGuest() + teams.getRedCardSecondHalfGuest();
            free_kicks_home_all_time2 += teams.getFreeKickFirstHalfHome() + teams.getFreeKickSecondHalfHome();
            free_kicks_away_all_time2 += teams.getFreeKickFirstHalfGuest() + teams.getFreeKickSecondHalfGuest();
            offsides_home_all_time2 += teams.getOffsideFirstHalfHome() + teams.getOffsideSecondHalfHome();
            offsides_away_all_time2 += teams.getOffsideFirstHalfGuest() + teams.getOffsideSecondHalfGuest();
            fouls_home_all_time2 += teams.getFoulFirstHalfHome() + teams.getFoulSecondHalfHome();
            fouls_away_all_time2 += teams.getFoulFirstHalfGuest() + teams.getFoulSecondHalfGuest();

            team_home.ifPresent(th4::add);
            team_guest.ifPresent(tg4::add);
            model.addAttribute("guest_table_home_level", th4);
            model.addAttribute("guest_table_guest_level", tg4);
        }
        model.addAttribute("shots_home_stat_table_home_level_first_time2", String.format("%.2f", shots_home_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_first_time2", String.format("%.2f", shots_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_first_time2_all", String.format("%.2f", shots_home_first_time2 / lastMatchesGuestTeambyLevel.size() + shots_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("possession_home_stat_table_home_level_first_time2", String.format("%.0f", possession_home_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("possession_away_stat_table_home_level_first_time2", String.format("%.0f", possession_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_on_target_home_stat_table_home_level_first_time2", String.format("%.2f", shots_on_target_home_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_first_time2", String.format("%.2f", shots_on_target_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_first_time2_all", String.format("%.2f", shots_on_target_home_first_time2 / lastMatchesGuestTeambyLevel.size() + shots_on_target_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_home_stat_table_home_level_first_time2", String.format("%.2f", corners_home_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_first_time2", String.format("%.2f", corners_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_first_time2_all", String.format("%.2f", corners_home_first_time2 / lastMatchesGuestTeambyLevel.size() + corners_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_home_stat_table_home_level_first_time2", String.format("%.2f", yellow_card_home_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_first_time2", String.format("%.2f", yellow_card_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_first_time2_all", String.format("%.2f", yellow_card_home_first_time2 / lastMatchesGuestTeambyLevel.size() + yellow_card_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_home_stat_table_home_level_first_time2", String.format("%.2f", red_card_home_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_first_time2", String.format("%.2f", red_card_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_first_time2_all", String.format("%.2f", red_card_home_first_time2 / lastMatchesGuestTeambyLevel.size() + red_card_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_home_stat_table_home_level_first_time2", String.format("%.2f", free_kicks_home_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_first_time2", String.format("%.2f", free_kicks_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_first_time2_all", String.format("%.2f", free_kicks_home_first_time2 / lastMatchesGuestTeambyLevel.size() + free_kicks_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_home_stat_table_home_level_first_time2", String.format("%.2f", offsides_home_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_first_time2", String.format("%.2f", offsides_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_first_time2_all", String.format("%.2f", offsides_home_first_time2 / lastMatchesGuestTeambyLevel.size() + offsides_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_home_stat_table_home_level_first_time2", String.format("%.2f", fouls_home_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_first_time2", String.format("%.2f", fouls_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_first_time2_all", String.format("%.2f", fouls_home_first_time2 / lastMatchesGuestTeambyLevel.size() + fouls_away_first_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_home_stat_table_home_level_second_time2", String.format("%.2f", shots_home_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_second_time2", String.format("%.2f", shots_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_second_time2_all", String.format("%.2f", shots_home_second_time2 / lastMatchesGuestTeambyLevel.size() + shots_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("possession_home_stat_table_home_level_second_time2", String.format("%.0f", possession_home_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("possession_away_stat_table_home_level_second_time2", String.format("%.0f", possession_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_on_target_home_stat_table_home_level_second_time2", String.format("%.2f", shots_on_target_home_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_second_time2", String.format("%.2f", shots_on_target_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_second_time2_all", String.format("%.2f", shots_on_target_home_second_time2 / lastMatchesGuestTeambyLevel.size() + shots_on_target_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_home_stat_table_home_level_second_time2", String.format("%.2f", corners_home_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_second_time2", String.format("%.2f", corners_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_second_time2_all", String.format("%.2f", corners_home_second_time2 / lastMatchesGuestTeambyLevel.size() + corners_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_home_stat_table_home_level_second_time2", String.format("%.2f", yellow_card_home_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_second_time2", String.format("%.2f", yellow_card_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_second_time2_all", String.format("%.2f", yellow_card_home_second_time2 / lastMatchesGuestTeambyLevel.size() + yellow_card_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_home_stat_table_home_level_second_time2", String.format("%.2f", red_card_home_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_second_time2", String.format("%.2f", red_card_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_second_time2_all", String.format("%.2f", red_card_home_second_time2 / lastMatchesGuestTeambyLevel.size() + red_card_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_home_stat_table_home_level_second_time2", String.format("%.2f", free_kicks_home_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_second_time2", String.format("%.2f", free_kicks_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_second_time2_all", String.format("%.2f", free_kicks_home_second_time2 / lastMatchesGuestTeambyLevel.size() + free_kicks_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_home_stat_table_home_level_second_time2", String.format("%.2f", offsides_home_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_second_time2", String.format("%.2f", offsides_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_second_time2_all", String.format("%.2f", offsides_home_second_time2 / lastMatchesGuestTeambyLevel.size() + offsides_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_home_stat_table_home_level_second_time2", String.format("%.2f", fouls_home_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_second_time2", String.format("%.2f", fouls_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_second_time2_all", String.format("%.2f", fouls_home_second_time2 / lastMatchesGuestTeambyLevel.size() + fouls_away_second_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_home_stat_table_home_level_all_time2", String.format("%.2f", shots_home_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_all_time2", String.format("%.2f", shots_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_away_stat_table_home_level_all_time2_all", String.format("%.2f", shots_home_all_time2 / lastMatchesGuestTeambyLevel.size() + shots_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("possession_home_stat_table_home_level_all_time2", String.format("%.0f", possession_home_all_time2 / lastMatchesGuestTeambyLevel.size() / 2));
        model.addAttribute("possession_away_stat_table_home_level_all_time2", String.format("%.0f", possession_away_all_time2 / lastMatchesGuestTeambyLevel.size() / 2));
        model.addAttribute("shots_on_target_home_stat_table_home_level_all_time2", String.format("%.2f", shots_on_target_home_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_all_time2", String.format("%.2f", shots_on_target_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("shots_on_target_away_stat_table_home_level_all_time2_all", String.format("%.2f", shots_on_target_home_all_time2 / lastMatchesGuestTeambyLevel.size() + shots_on_target_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_home_stat_table_home_level_all_time2", String.format("%.2f", corners_home_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_all_time2", String.format("%.2f", corners_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("corners_away_stat_table_home_level_all_time2_all", String.format("%.2f", corners_home_all_time2 / lastMatchesGuestTeambyLevel.size() + corners_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_home_stat_table_home_level_all_time2", String.format("%.2f", yellow_card_home_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_all_time2", String.format("%.2f", yellow_card_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("yellow_card_away_stat_table_home_level_all_time2_all", String.format("%.2f", yellow_card_home_all_time2 / lastMatchesGuestTeambyLevel.size() + yellow_card_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_home_stat_table_home_level_all_time2", String.format("%.2f", red_card_home_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_all_time2", String.format("%.2f", red_card_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("red_card_away_stat_table_home_level_all_time2_all", String.format("%.2f", red_card_home_all_time2 / lastMatchesGuestTeambyLevel.size() + red_card_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_home_stat_table_home_level_all_time2", String.format("%.2f", free_kicks_home_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_all_time2", String.format("%.2f", free_kicks_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("free_kicks_away_stat_table_home_level_all_time2_all", String.format("%.2f", free_kicks_home_all_time2 / lastMatchesGuestTeambyLevel.size() + free_kicks_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_home_stat_table_home_level_all_time2", String.format("%.2f", offsides_home_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_all_time2", String.format("%.2f", offsides_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("offsides_away_stat_table_home_level_all_time2_all", String.format("%.2f", offsides_home_all_time2 / lastMatchesGuestTeambyLevel.size() + offsides_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_home_stat_table_home_level_all_time2", String.format("%.2f", fouls_home_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_all_time2", String.format("%.2f", fouls_away_all_time2 / lastMatchesGuestTeambyLevel.size()));
        model.addAttribute("fouls_away_stat_table_home_level_all_time2_all", String.format("%.2f", fouls_home_all_time2 / lastMatchesGuestTeambyLevel.size() + fouls_away_all_time2 / lastMatchesGuestTeambyLevel.size()));

        Optional<team> team_home = teamRepository.findById(match.get().getTeamHome());
        Optional<team> team_guest = teamRepository.findById(match.get().getTeamGuest());
        ArrayList<team> thm = new ArrayList<>();
        ArrayList<team> tgm = new ArrayList<>();
        team_home.ifPresent(thm::add);
        team_guest.ifPresent(tgm::add);
        model.addAttribute("team_home", thm);
        model.addAttribute("team_guest", tgm);
        //                  occasion - 3-6
        //                 3 - Фора
        //                 4 - Тотал
        //                 5 - ИТ хозяев
        //                 6 - ИТ гостей
        //                          game_period - 0-2
        //                          bettingLine - 1-5
        //                           2 - угловые
        //                           8 - желтые карточки
        //                           12 - удары в створ
        //                           13 - оффсайды
        //                           14 - фолы
        Iterable<event> event = eventRepository.findAll();
        Iterable<coefficient_table> coefficients = coefficientRepository.findAll();
        ArrayList<Integer> lcorners_home_first_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_home_first_time_total = new ArrayList<>();
        ArrayList<Integer> lcorners_home_first_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_home_first_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lcorners_home_first_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_home_first_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_home_first_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lcorners_away_first_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_away_first_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_away_first_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lcorners_away_first_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_away_first_time_total = new ArrayList<>();
        ArrayList<Integer> lcorners_away_first_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_away_first_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lcorners_home_second_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_home_second_time_total = new ArrayList<>();
        ArrayList<Integer> lcorners_home_second_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_home_second_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lcorners_home_second_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_home_second_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_home_second_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lcorners_away_second_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_away_second_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_away_second_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lcorners_away_second_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_away_second_time_total = new ArrayList<>();
        ArrayList<Integer> lcorners_away_second_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_away_second_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lcorners_home_all_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_home_all_time_total = new ArrayList<>();
        ArrayList<Integer> lcorners_home_all_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_home_all_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lcorners_home_all_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_home_all_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_home_all_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lcorners_away_all_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_away_all_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_away_all_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lcorners_away_all_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lcorners_away_all_time_total = new ArrayList<>();
        ArrayList<Integer> lcorners_away_all_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lcorners_away_all_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_first_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_first_time_total = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_first_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_first_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_first_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_first_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_first_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_first_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_first_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_first_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_first_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_first_time_total = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_first_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_first_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_second_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_second_time_total = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_second_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_second_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_second_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_second_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_second_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_second_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_second_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_second_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_second_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_second_time_total = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_second_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_second_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_all_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_all_time_total = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_all_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_all_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_all_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_all_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_home_all_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_all_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_all_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_all_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_all_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_all_time_total = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_all_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lyellow_cards_away_all_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_first_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_first_time_total = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_first_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_first_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_first_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_first_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_first_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_first_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_first_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_first_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_first_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_first_time_total = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_first_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_first_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_second_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_second_time_total = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_second_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_second_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_second_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_second_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_second_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_second_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_second_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_second_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_second_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_second_time_total = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_second_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_second_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_all_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_all_time_total = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_all_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_all_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_all_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_all_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_home_all_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_all_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_all_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_all_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_all_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_all_time_total = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_all_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lshots_on_target_away_all_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_home_first_time_home_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_home_first_time_total = new ArrayList<>();
        ArrayList<Integer> loffsides_home_first_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_home_first_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_home_first_time_away_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_home_first_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_home_first_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_away_first_time_home_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_away_first_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_away_first_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_away_first_time_away_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_away_first_time_total = new ArrayList<>();
        ArrayList<Integer> loffsides_away_first_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_away_first_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_home_second_time_home_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_home_second_time_total = new ArrayList<>();
        ArrayList<Integer> loffsides_home_second_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_home_second_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_home_second_time_away_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_home_second_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_home_second_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_away_second_time_home_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_away_second_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_away_second_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_away_second_time_away_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_away_second_time_total = new ArrayList<>();
        ArrayList<Integer> loffsides_away_second_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_away_second_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_home_all_time_home_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_home_all_time_total = new ArrayList<>();
        ArrayList<Integer> loffsides_home_all_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_home_all_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_home_all_time_away_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_home_all_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_home_all_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_away_all_time_home_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_away_all_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_away_all_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> loffsides_away_all_time_away_fora = new ArrayList<>();
        ArrayList<Integer> loffsides_away_all_time_total = new ArrayList<>();
        ArrayList<Integer> loffsides_away_all_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> loffsides_away_all_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_home_first_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_home_first_time_total = new ArrayList<>();
        ArrayList<Integer> lfouls_home_first_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_home_first_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_home_first_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_home_first_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_home_first_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_away_first_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_away_first_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_away_first_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_away_first_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_away_first_time_total = new ArrayList<>();
        ArrayList<Integer> lfouls_away_first_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_away_first_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_home_second_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_home_second_time_total = new ArrayList<>();
        ArrayList<Integer> lfouls_home_second_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_home_second_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_home_second_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_home_second_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_home_second_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_away_second_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_away_second_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_away_second_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_away_second_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_away_second_time_total = new ArrayList<>();
        ArrayList<Integer> lfouls_away_second_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_away_second_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_home_all_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_home_all_time_total = new ArrayList<>();
        ArrayList<Integer> lfouls_home_all_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_home_all_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_home_all_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_home_all_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_home_all_time_away_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_away_all_time_home_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_away_all_time_home_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_away_all_time_home_itaway = new ArrayList<>();
        ArrayList<Integer> lfouls_away_all_time_away_fora = new ArrayList<>();
        ArrayList<Integer> lfouls_away_all_time_total = new ArrayList<>();
        ArrayList<Integer> lfouls_away_all_time_away_ithome = new ArrayList<>();
        ArrayList<Integer> lfouls_away_all_time_away_itaway = new ArrayList<>();
        ArrayList<event> matchEvents = new ArrayList<>();
        ArrayList<coefficient_table> matchCoefficient = new ArrayList<>();
        for (event evs : event) {                                   // очень долгий запрос, использовать sql hibernate
            if (evs.getIdMatch().equals(match.get().getIdMatch())) {
                for (coefficient_table coeffs : coefficients) {                                   // !!!очень долгий запрос, использовать sql hibernate
                    if (coeffs.getIdEvent().equals(evs.getIdEvent())) {
                        if (evs.getGamePeriod() == 0) {
                            if (evs.getBettingLine() == 1) {
                                double homeStat = (corners_home_all_time / lastMatchesHomeTeambyLevel.size() + corners_home_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (corners_away_all_time / lastMatchesHomeTeambyLevel.size() + corners_away_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (corners_home_all_time / lastMatchesHomeTeambyLevel.size() + corners_away_all_time / lastMatchesHomeTeambyLevel.size() + corners_home_all_time2 / lastMatchesGuestTeambyLevel.size() + corners_away_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                cornersCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lcorners_home_all_time_home_fora, lcorners_home_all_time_total, lcorners_home_all_time_home_ithome, lcorners_home_all_time_home_itaway);
                                cornersCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lcorners_home_all_time_away_fora, lcorners_home_all_time_total, lcorners_home_all_time_away_ithome, lcorners_home_all_time_away_itaway);
                                cornersCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lcorners_away_all_time_home_fora, lcorners_away_all_time_total, lcorners_away_all_time_home_ithome, lcorners_away_all_time_home_itaway);
                                cornersCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lcorners_away_all_time_away_fora, lcorners_away_all_time_total, lcorners_away_all_time_away_ithome, lcorners_away_all_time_away_itaway);
                            } else if (evs.getBettingLine() == 2) {
                                double homeStat = (yellow_card_home_all_time / lastMatchesHomeTeambyLevel.size() + yellow_card_home_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (yellow_card_away_all_time / lastMatchesHomeTeambyLevel.size() + yellow_card_away_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (yellow_card_home_all_time / lastMatchesHomeTeambyLevel.size() + yellow_card_away_all_time / lastMatchesHomeTeambyLevel.size() + yellow_card_home_all_time2 / lastMatchesGuestTeambyLevel.size() + yellow_card_away_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                yellowCardsCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lyellow_cards_home_all_time_home_fora, lyellow_cards_home_all_time_total, lyellow_cards_home_all_time_home_ithome, lyellow_cards_home_all_time_home_itaway);
                                yellowCardsCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lyellow_cards_home_all_time_away_fora, lyellow_cards_home_all_time_total, lyellow_cards_home_all_time_away_ithome, lyellow_cards_home_all_time_away_itaway);
                                yellowCardsCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lyellow_cards_away_all_time_home_fora, lyellow_cards_away_all_time_total, lyellow_cards_away_all_time_home_ithome, lyellow_cards_away_all_time_home_itaway);
                                yellowCardsCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lyellow_cards_away_all_time_away_fora, lyellow_cards_away_all_time_total, lyellow_cards_away_all_time_away_ithome, lyellow_cards_away_all_time_away_itaway);
                            } else if (evs.getBettingLine() == 3) {
                                double homeStat = (shots_on_target_home_all_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_home_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (shots_on_target_away_all_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_away_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (shots_on_target_home_all_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_away_all_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_home_all_time2 / lastMatchesGuestTeambyLevel.size() + shots_on_target_away_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                shotsOnTargetCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lshots_on_target_home_all_time_home_fora, lshots_on_target_home_all_time_total, lshots_on_target_home_all_time_home_ithome, lshots_on_target_home_all_time_home_itaway);
                                shotsOnTargetCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lshots_on_target_home_all_time_away_fora, lshots_on_target_home_all_time_total, lshots_on_target_home_all_time_away_ithome, lshots_on_target_home_all_time_away_itaway);
                                shotsOnTargetCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lshots_on_target_away_all_time_home_fora, lshots_on_target_away_all_time_total, lshots_on_target_away_all_time_home_ithome, lshots_on_target_away_all_time_home_itaway);
                                shotsOnTargetCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lshots_on_target_away_all_time_away_fora, lshots_on_target_away_all_time_total, lshots_on_target_away_all_time_away_ithome, lshots_on_target_away_all_time_away_itaway);
                            } else if (evs.getBettingLine() == 4) {
                                double homeStat = (offsides_home_all_time / lastMatchesHomeTeambyLevel.size() + offsides_home_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (offsides_away_all_time / lastMatchesHomeTeambyLevel.size() + offsides_away_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (offsides_home_all_time / lastMatchesHomeTeambyLevel.size() + offsides_away_all_time / lastMatchesHomeTeambyLevel.size() + offsides_home_all_time2 / lastMatchesGuestTeambyLevel.size() + offsides_away_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                offsidesCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, loffsides_home_all_time_home_fora, loffsides_home_all_time_total, loffsides_home_all_time_home_ithome, loffsides_home_all_time_home_itaway);
                                offsidesCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, loffsides_home_all_time_away_fora, loffsides_home_all_time_total, loffsides_home_all_time_away_ithome, loffsides_home_all_time_away_itaway);
                                offsidesCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, loffsides_away_all_time_home_fora, loffsides_away_all_time_total, loffsides_away_all_time_home_ithome, loffsides_away_all_time_home_itaway);
                                offsidesCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, loffsides_away_all_time_away_fora, loffsides_away_all_time_total, loffsides_away_all_time_away_ithome, loffsides_away_all_time_away_itaway);
                            } else if (evs.getBettingLine() == 5) {
                                double homeStat = (fouls_home_all_time / lastMatchesHomeTeambyLevel.size() + fouls_home_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (fouls_away_all_time / lastMatchesHomeTeambyLevel.size() + fouls_away_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (fouls_home_all_time / lastMatchesHomeTeambyLevel.size() + fouls_away_all_time / lastMatchesHomeTeambyLevel.size() + fouls_home_all_time2 / lastMatchesGuestTeambyLevel.size() + fouls_away_all_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                foulsCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lfouls_home_all_time_home_fora, lfouls_home_all_time_total, lfouls_home_all_time_home_ithome, lfouls_home_all_time_home_itaway);
                                foulsCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lfouls_home_all_time_away_fora, lfouls_home_all_time_total, lfouls_home_all_time_away_ithome, lfouls_home_all_time_away_itaway);
                                foulsCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lfouls_away_all_time_home_fora, lfouls_away_all_time_total, lfouls_away_all_time_home_ithome, lfouls_away_all_time_home_itaway);
                                foulsCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lfouls_away_all_time_away_fora, lfouls_away_all_time_total, lfouls_away_all_time_away_ithome, lfouls_away_all_time_away_itaway);
                            }
                        } else if (evs.getGamePeriod() == 1) {
                            if (evs.getBettingLine() == 1) {
                                double homeStat = (corners_home_first_time / lastMatchesHomeTeambyLevel.size() + corners_home_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (corners_away_first_time / lastMatchesHomeTeambyLevel.size() + corners_away_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (corners_home_first_time / lastMatchesHomeTeambyLevel.size() + corners_away_first_time / lastMatchesHomeTeambyLevel.size() + corners_home_first_time2 / lastMatchesGuestTeambyLevel.size() + corners_away_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                cornersCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lcorners_home_first_time_home_fora, lcorners_home_first_time_total, lcorners_home_first_time_home_ithome, lcorners_home_first_time_home_itaway);
                                cornersCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lcorners_home_first_time_away_fora, lcorners_home_first_time_total, lcorners_home_first_time_away_ithome, lcorners_home_first_time_away_itaway);
                                cornersCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lcorners_away_first_time_home_fora, lcorners_away_first_time_total, lcorners_away_first_time_home_ithome, lcorners_away_first_time_home_itaway);
                                cornersCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lcorners_away_first_time_away_fora, lcorners_away_first_time_total, lcorners_away_first_time_away_ithome, lcorners_away_first_time_away_itaway);
                            } else if (evs.getBettingLine() == 2) {
                                double homeStat = (yellow_card_home_first_time / lastMatchesHomeTeambyLevel.size() + yellow_card_home_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (yellow_card_away_first_time / lastMatchesHomeTeambyLevel.size() + yellow_card_away_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (yellow_card_home_first_time / lastMatchesHomeTeambyLevel.size() + yellow_card_away_first_time / lastMatchesHomeTeambyLevel.size() + yellow_card_home_first_time2 / lastMatchesGuestTeambyLevel.size() + yellow_card_away_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                yellowCardsCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lyellow_cards_home_first_time_home_fora, lyellow_cards_home_first_time_total, lyellow_cards_home_first_time_home_ithome, lyellow_cards_home_first_time_home_itaway);
                                yellowCardsCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lyellow_cards_home_first_time_away_fora, lyellow_cards_home_first_time_total, lyellow_cards_home_first_time_away_ithome, lyellow_cards_home_first_time_away_itaway);
                                yellowCardsCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lyellow_cards_away_first_time_home_fora, lyellow_cards_away_first_time_total, lyellow_cards_away_first_time_home_ithome, lyellow_cards_away_first_time_home_itaway);
                                yellowCardsCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lyellow_cards_away_first_time_away_fora, lyellow_cards_away_first_time_total, lyellow_cards_away_first_time_away_ithome, lyellow_cards_away_first_time_away_itaway);
                            } else if (evs.getBettingLine() == 3) {
                                double homeStat = (shots_on_target_home_first_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_home_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (shots_on_target_away_first_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_away_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (shots_on_target_home_first_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_away_first_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_home_first_time2 / lastMatchesGuestTeambyLevel.size() + shots_on_target_away_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                shotsOnTargetCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lshots_on_target_home_first_time_home_fora, lshots_on_target_home_first_time_total, lshots_on_target_home_first_time_home_ithome, lshots_on_target_home_first_time_home_itaway);
                                shotsOnTargetCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lshots_on_target_home_first_time_away_fora, lshots_on_target_home_first_time_total, lshots_on_target_home_first_time_away_ithome, lshots_on_target_home_first_time_away_itaway);
                                shotsOnTargetCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lshots_on_target_away_first_time_home_fora, lshots_on_target_away_first_time_total, lshots_on_target_away_first_time_home_ithome, lshots_on_target_away_first_time_home_itaway);
                                shotsOnTargetCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lshots_on_target_away_first_time_away_fora, lshots_on_target_away_first_time_total, lshots_on_target_away_first_time_away_ithome, lshots_on_target_away_first_time_away_itaway);
                            } else if (evs.getBettingLine() == 4) {
                                double homeStat = (offsides_home_first_time / lastMatchesHomeTeambyLevel.size() + offsides_home_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (offsides_away_first_time / lastMatchesHomeTeambyLevel.size() + offsides_away_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (offsides_home_first_time / lastMatchesHomeTeambyLevel.size() + offsides_away_first_time / lastMatchesHomeTeambyLevel.size() + offsides_home_first_time2 / lastMatchesGuestTeambyLevel.size() + offsides_away_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                offsidesCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, loffsides_home_first_time_home_fora, loffsides_home_first_time_total, loffsides_home_first_time_home_ithome, loffsides_home_first_time_home_itaway);
                                offsidesCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, loffsides_home_first_time_away_fora, loffsides_home_first_time_total, loffsides_home_first_time_away_ithome, loffsides_home_first_time_away_itaway);
                                offsidesCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, loffsides_away_first_time_home_fora, loffsides_away_first_time_total, loffsides_away_first_time_home_ithome, loffsides_away_first_time_home_itaway);
                                offsidesCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, loffsides_away_first_time_away_fora, loffsides_away_first_time_total, loffsides_away_first_time_away_ithome, loffsides_away_first_time_away_itaway);
                            } else if (evs.getBettingLine() == 5) {
                                double homeStat = (fouls_home_first_time / lastMatchesHomeTeambyLevel.size() + fouls_home_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (fouls_away_first_time / lastMatchesHomeTeambyLevel.size() + fouls_away_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (fouls_home_first_time / lastMatchesHomeTeambyLevel.size() + fouls_away_first_time / lastMatchesHomeTeambyLevel.size() + fouls_home_first_time2 / lastMatchesGuestTeambyLevel.size() + fouls_away_first_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                foulsCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lfouls_home_first_time_home_fora, lfouls_home_first_time_total, lfouls_home_first_time_home_ithome, lfouls_home_first_time_home_itaway);
                                foulsCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lfouls_home_first_time_away_fora, lfouls_home_first_time_total, lfouls_home_first_time_away_ithome, lfouls_home_first_time_away_itaway);
                                foulsCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lfouls_away_first_time_home_fora, lfouls_away_first_time_total, lfouls_away_first_time_home_ithome, lfouls_away_first_time_home_itaway);
                                foulsCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lfouls_away_first_time_away_fora, lfouls_away_first_time_total, lfouls_away_first_time_away_ithome, lfouls_away_first_time_away_itaway);
                            }
                        } else if (evs.getGamePeriod() == 2) {
                            if (evs.getBettingLine() == 1) {
                                double homeStat = (corners_home_second_time / lastMatchesHomeTeambyLevel.size() + corners_home_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (corners_away_second_time / lastMatchesHomeTeambyLevel.size() + corners_away_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (corners_home_second_time / lastMatchesHomeTeambyLevel.size() + corners_away_second_time / lastMatchesHomeTeambyLevel.size() + corners_home_second_time2 / lastMatchesGuestTeambyLevel.size() + corners_away_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                cornersCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lcorners_home_second_time_home_fora, lcorners_home_second_time_total, lcorners_home_second_time_home_ithome, lcorners_home_second_time_home_itaway);
                                cornersCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lcorners_home_second_time_away_fora, lcorners_home_second_time_total, lcorners_home_second_time_away_ithome, lcorners_home_second_time_away_itaway);
                                cornersCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lcorners_away_second_time_home_fora, lcorners_away_second_time_total, lcorners_away_second_time_home_ithome, lcorners_away_second_time_home_itaway);
                                cornersCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lcorners_away_second_time_away_fora, lcorners_away_second_time_total, lcorners_away_second_time_away_ithome, lcorners_away_second_time_away_itaway);
                            } else if (evs.getBettingLine() == 2) {
                                double homeStat = (yellow_card_home_second_time / lastMatchesHomeTeambyLevel.size() + yellow_card_home_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (yellow_card_away_second_time / lastMatchesHomeTeambyLevel.size() + yellow_card_away_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (yellow_card_home_second_time / lastMatchesHomeTeambyLevel.size() + yellow_card_away_second_time / lastMatchesHomeTeambyLevel.size() + yellow_card_home_second_time2 / lastMatchesGuestTeambyLevel.size() + yellow_card_away_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                yellowCardsCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lyellow_cards_home_second_time_home_fora, lyellow_cards_home_second_time_total, lyellow_cards_home_second_time_home_ithome, lyellow_cards_home_second_time_home_itaway);
                                yellowCardsCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lyellow_cards_home_second_time_away_fora, lyellow_cards_home_second_time_total, lyellow_cards_home_second_time_away_ithome, lyellow_cards_home_second_time_away_itaway);
                                yellowCardsCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lyellow_cards_away_second_time_home_fora, lyellow_cards_away_second_time_total, lyellow_cards_away_second_time_home_ithome, lyellow_cards_away_second_time_home_itaway);
                                yellowCardsCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lyellow_cards_away_second_time_away_fora, lyellow_cards_away_second_time_total, lyellow_cards_away_second_time_away_ithome, lyellow_cards_away_second_time_away_itaway);
                            } else if (evs.getBettingLine() == 3) {
                                double homeStat = (shots_on_target_home_second_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_away_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (shots_on_target_away_second_time / lastMatchesHomeTeambyLevel.size() + shots_on_target_home_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (homeStat + awayStat) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                shotsOnTargetCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lshots_on_target_home_second_time_home_fora, lshots_on_target_home_second_time_total, lshots_on_target_home_second_time_home_ithome, lshots_on_target_home_second_time_home_itaway);
                                shotsOnTargetCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lshots_on_target_home_second_time_away_fora, lshots_on_target_home_second_time_total, lshots_on_target_home_second_time_away_ithome, lshots_on_target_home_second_time_away_itaway);
                                shotsOnTargetCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lshots_on_target_away_second_time_home_fora, lshots_on_target_away_second_time_total, lshots_on_target_away_second_time_home_ithome, lshots_on_target_away_second_time_home_itaway);
                                shotsOnTargetCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lshots_on_target_away_second_time_away_fora, lshots_on_target_away_second_time_total, lshots_on_target_away_second_time_away_ithome, lshots_on_target_away_second_time_away_itaway);
                            } else if (evs.getBettingLine() == 4) {
                                double homeStat = (offsides_home_second_time / lastMatchesHomeTeambyLevel.size() + offsides_home_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (offsides_away_second_time / lastMatchesHomeTeambyLevel.size() + offsides_away_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (offsides_home_second_time / lastMatchesHomeTeambyLevel.size() + offsides_away_second_time / lastMatchesHomeTeambyLevel.size() + offsides_home_second_time2 / lastMatchesGuestTeambyLevel.size() + offsides_away_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                offsidesCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, loffsides_home_second_time_home_fora, loffsides_home_second_time_total, loffsides_home_second_time_home_ithome, loffsides_home_second_time_home_itaway);
                                offsidesCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, loffsides_home_second_time_away_fora, loffsides_home_second_time_total, loffsides_home_second_time_away_ithome, loffsides_home_second_time_away_itaway);
                                offsidesCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, loffsides_away_second_time_home_fora, loffsides_away_second_time_total, loffsides_away_second_time_home_ithome, loffsides_away_second_time_home_itaway);
                                offsidesCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, loffsides_away_second_time_away_fora, loffsides_away_second_time_total, loffsides_away_second_time_away_ithome, loffsides_away_second_time_away_itaway);
                            } else if (evs.getBettingLine() == 5) {
                                double homeStat = (fouls_home_second_time / lastMatchesHomeTeambyLevel.size() + fouls_home_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double awayStat = (fouls_away_second_time / lastMatchesHomeTeambyLevel.size() + fouls_away_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                double totalStat = (fouls_home_second_time / lastMatchesHomeTeambyLevel.size() + fouls_away_second_time / lastMatchesHomeTeambyLevel.size() + fouls_home_second_time2 / lastMatchesGuestTeambyLevel.size() + fouls_away_second_time2 / lastMatchesGuestTeambyLevel.size()) / 2;
                                analysSuccess(homeStat, awayStat, totalStat, evs, coeffs, matchEvents, matchCoefficient, model);
                                foulsCountMatches(1, evs, coeffs, lastMatchesHomeTeambyLevel, lfouls_home_second_time_home_fora, lfouls_home_second_time_total, lfouls_home_second_time_home_ithome, lfouls_home_second_time_home_itaway);
                                foulsCountMatches(1, evs, coeffs, lastMatchesGuestTeambyLevel, lfouls_home_second_time_away_fora, lfouls_home_second_time_total, lfouls_home_second_time_away_ithome, lfouls_home_second_time_away_itaway);
                                foulsCountMatches(2, evs, coeffs, lastMatchesHomeTeambyLevel, lfouls_away_second_time_home_fora, lfouls_away_second_time_total, lfouls_away_second_time_home_ithome, lfouls_away_second_time_home_itaway);
                                foulsCountMatches(2, evs, coeffs, lastMatchesGuestTeambyLevel, lfouls_away_second_time_away_fora, lfouls_away_second_time_total, lfouls_away_second_time_away_ithome, lfouls_away_second_time_away_itaway);
                            }
                        }
                    }
                }
            }
        }
        if (lcorners_home_first_time_home_fora.isEmpty()) {
            lcorners_home_first_time_home_fora.add(0);
        }
        if (lcorners_home_first_time_total.isEmpty()) {
            lcorners_home_first_time_total.add(0);
        }
        if (lcorners_home_first_time_home_ithome.isEmpty()) {
            lcorners_home_first_time_home_ithome.add(0);
        }
        if (lcorners_home_first_time_home_itaway.isEmpty()) {
            lcorners_home_first_time_home_itaway.add(0);
        }
        if (lcorners_home_first_time_away_fora.isEmpty()) {
            lcorners_home_first_time_away_fora.add(0);
        }
        if (lcorners_home_first_time_away_ithome.isEmpty()) {
            lcorners_home_first_time_away_ithome.add(0);
        }
        if (lcorners_home_first_time_away_itaway.isEmpty()) {
            lcorners_home_first_time_away_itaway.add(0);
        }
        if (lcorners_away_first_time_home_fora.isEmpty()) {
            lcorners_away_first_time_home_fora.add(0);
        }
        if (lcorners_away_first_time_total.isEmpty()) {
            lcorners_away_first_time_total.add(0);
        }
        if (lcorners_away_first_time_home_ithome.isEmpty()) {
            lcorners_away_first_time_home_ithome.add(0);
        }
        if (lcorners_away_first_time_home_itaway.isEmpty()) {
            lcorners_away_first_time_home_itaway.add(0);
        }
        if (lcorners_away_first_time_away_fora.isEmpty()) {
            lcorners_away_first_time_away_fora.add(0);
        }
        if (lcorners_away_first_time_away_ithome.isEmpty()) {
            lcorners_away_first_time_away_ithome.add(0);
        }
        if (lcorners_away_first_time_away_itaway.isEmpty()) {
            lcorners_away_first_time_away_itaway.add(0);
        }
        if (lcorners_home_second_time_home_fora.isEmpty()) {
            lcorners_home_second_time_home_fora.add(0);
        }
        if (lcorners_home_second_time_total.isEmpty()) {
            lcorners_home_second_time_total.add(0);
        }
        if (lcorners_home_second_time_home_ithome.isEmpty()) {
            lcorners_home_second_time_home_ithome.add(0);
        }
        if (lcorners_home_second_time_home_itaway.isEmpty()) {
            lcorners_home_second_time_home_itaway.add(0);
        }
        if (lcorners_home_second_time_away_fora.isEmpty()) {
            lcorners_home_second_time_away_fora.add(0);
        }
        if (lcorners_home_second_time_away_ithome.isEmpty()) {
            lcorners_home_second_time_away_ithome.add(0);
        }
        if (lcorners_home_second_time_away_itaway.isEmpty()) {
            lcorners_home_second_time_away_itaway.add(0);
        }
        if (lcorners_away_second_time_home_fora.isEmpty()) {
            lcorners_away_second_time_home_fora.add(0);
        }
        if (lcorners_away_second_time_total.isEmpty()) {
            lcorners_away_second_time_total.add(0);
        }
        if (lcorners_away_second_time_home_ithome.isEmpty()) {
            lcorners_away_second_time_home_ithome.add(0);
        }
        if (lcorners_away_second_time_home_itaway.isEmpty()) {
            lcorners_away_second_time_home_itaway.add(0);
        }
        if (lcorners_away_second_time_away_fora.isEmpty()) {
            lcorners_away_second_time_away_fora.add(0);
        }
        if (lcorners_away_second_time_away_ithome.isEmpty()) {
            lcorners_away_second_time_away_ithome.add(0);
        }
        if (lcorners_away_second_time_away_itaway.isEmpty()) {
            lcorners_away_second_time_away_itaway.add(0);
        }
        if (lcorners_home_all_time_home_fora.isEmpty()) {
            lcorners_home_all_time_home_fora.add(0);
        }
        if (lcorners_home_all_time_total.isEmpty()) {
            lcorners_home_all_time_total.add(0);
        }
        if (lcorners_home_all_time_home_ithome.isEmpty()) {
            lcorners_home_all_time_home_ithome.add(0);
        }
        if (lcorners_home_all_time_home_itaway.isEmpty()) {
            lcorners_home_all_time_home_itaway.add(0);
        }
        if (lcorners_home_all_time_away_fora.isEmpty()) {
            lcorners_home_all_time_away_fora.add(0);
        }
        if (lcorners_home_all_time_away_ithome.isEmpty()) {
            lcorners_home_all_time_away_ithome.add(0);
        }
        if (lcorners_home_all_time_away_itaway.isEmpty()) {
            lcorners_home_all_time_away_itaway.add(0);
        }
        if (lcorners_away_all_time_home_fora.isEmpty()) {
            lcorners_away_all_time_home_fora.add(0);
        }
        if (lcorners_away_all_time_total.isEmpty()) {
            lcorners_away_all_time_total.add(0);
        }
        if (lcorners_away_all_time_home_ithome.isEmpty()) {
            lcorners_away_all_time_home_ithome.add(0);
        }
        if (lcorners_away_all_time_home_itaway.isEmpty()) {
            lcorners_away_all_time_home_itaway.add(0);
        }
        if (lcorners_away_all_time_away_fora.isEmpty()) {
            lcorners_away_all_time_away_fora.add(0);
        }
        if (lcorners_away_all_time_away_ithome.isEmpty()) {
            lcorners_away_all_time_away_ithome.add(0);
        }
        if (lcorners_away_all_time_away_itaway.isEmpty()) {
            lcorners_away_all_time_away_itaway.add(0);
        }
        if (lyellow_cards_home_first_time_home_fora.isEmpty()) {
            lyellow_cards_home_first_time_home_fora.add(0);
        }
        if (lyellow_cards_home_first_time_total.isEmpty()) {
            lyellow_cards_home_first_time_total.add(0);
        }
        if (lyellow_cards_home_first_time_home_ithome.isEmpty()) {
            lyellow_cards_home_first_time_home_ithome.add(0);
        }
        if (lyellow_cards_home_first_time_home_itaway.isEmpty()) {
            lyellow_cards_home_first_time_home_itaway.add(0);
        }
        if (lyellow_cards_home_first_time_away_fora.isEmpty()) {
            lyellow_cards_home_first_time_away_fora.add(0);
        }
        if (lyellow_cards_home_first_time_away_ithome.isEmpty()) {
            lyellow_cards_home_first_time_away_ithome.add(0);
        }
        if (lyellow_cards_home_first_time_away_itaway.isEmpty()) {
            lyellow_cards_home_first_time_away_itaway.add(0);
        }
        if (lyellow_cards_away_first_time_home_fora.isEmpty()) {
            lyellow_cards_away_first_time_home_fora.add(0);
        }
        if (lyellow_cards_away_first_time_total.isEmpty()) {
            lyellow_cards_away_first_time_total.add(0);
        }
        if (lyellow_cards_away_first_time_home_ithome.isEmpty()) {
            lyellow_cards_away_first_time_home_ithome.add(0);
        }
        if (lyellow_cards_away_first_time_home_itaway.isEmpty()) {
            lyellow_cards_away_first_time_home_itaway.add(0);
        }
        if (lyellow_cards_away_first_time_away_fora.isEmpty()) {
            lyellow_cards_away_first_time_away_fora.add(0);
        }
        if (lyellow_cards_away_first_time_away_ithome.isEmpty()) {
            lyellow_cards_away_first_time_away_ithome.add(0);
        }
        if (lyellow_cards_away_first_time_away_itaway.isEmpty()) {
            lyellow_cards_away_first_time_away_itaway.add(0);
        }
        if (lyellow_cards_home_second_time_home_fora.isEmpty()) {
            lyellow_cards_home_second_time_home_fora.add(0);
        }
        if (lyellow_cards_home_second_time_total.isEmpty()) {
            lyellow_cards_home_second_time_total.add(0);
        }
        if (lyellow_cards_home_second_time_home_ithome.isEmpty()) {
            lyellow_cards_home_second_time_home_ithome.add(0);
        }
        if (lyellow_cards_home_second_time_home_itaway.isEmpty()) {
            lyellow_cards_home_second_time_home_itaway.add(0);
        }
        if (lyellow_cards_home_second_time_away_fora.isEmpty()) {
            lyellow_cards_home_second_time_away_fora.add(0);
        }
        if (lyellow_cards_home_second_time_away_ithome.isEmpty()) {
            lyellow_cards_home_second_time_away_ithome.add(0);
        }
        if (lyellow_cards_home_second_time_away_itaway.isEmpty()) {
            lyellow_cards_home_second_time_away_itaway.add(0);
        }
        if (lyellow_cards_away_second_time_home_fora.isEmpty()) {
            lyellow_cards_away_second_time_home_fora.add(0);
        }
        if (lyellow_cards_away_second_time_total.isEmpty()) {
            lyellow_cards_away_second_time_total.add(0);
        }
        if (lyellow_cards_away_second_time_home_ithome.isEmpty()) {
            lyellow_cards_away_second_time_home_ithome.add(0);
        }
        if (lyellow_cards_away_second_time_home_itaway.isEmpty()) {
            lyellow_cards_away_second_time_home_itaway.add(0);
        }
        if (lyellow_cards_away_second_time_away_fora.isEmpty()) {
            lyellow_cards_away_second_time_away_fora.add(0);
        }
        if (lyellow_cards_away_second_time_away_ithome.isEmpty()) {
            lyellow_cards_away_second_time_away_ithome.add(0);
        }
        if (lyellow_cards_away_second_time_away_itaway.isEmpty()) {
            lyellow_cards_away_second_time_away_itaway.add(0);
        }
        if (lyellow_cards_home_all_time_home_fora.isEmpty()) {
            lyellow_cards_home_all_time_home_fora.add(0);
        }
        if (lyellow_cards_home_all_time_total.isEmpty()) {
            lyellow_cards_home_all_time_total.add(0);
        }
        if (lyellow_cards_home_all_time_home_ithome.isEmpty()) {
            lyellow_cards_home_all_time_home_ithome.add(0);
        }
        if (lyellow_cards_home_all_time_home_itaway.isEmpty()) {
            lyellow_cards_home_all_time_home_itaway.add(0);
        }
        if (lyellow_cards_home_all_time_away_fora.isEmpty()) {
            lyellow_cards_home_all_time_away_fora.add(0);
        }
        if (lyellow_cards_home_all_time_away_ithome.isEmpty()) {
            lyellow_cards_home_all_time_away_ithome.add(0);
        }
        if (lyellow_cards_home_all_time_away_itaway.isEmpty()) {
            lyellow_cards_home_all_time_away_itaway.add(0);
        }
        if (lyellow_cards_away_all_time_home_fora.isEmpty()) {
            lyellow_cards_away_all_time_home_fora.add(0);
        }
        if (lyellow_cards_away_all_time_total.isEmpty()) {
            lyellow_cards_away_all_time_total.add(0);
        }
        if (lyellow_cards_away_all_time_home_ithome.isEmpty()) {
            lyellow_cards_away_all_time_home_ithome.add(0);
        }
        if (lyellow_cards_away_all_time_home_itaway.isEmpty()) {
            lyellow_cards_away_all_time_home_itaway.add(0);
        }
        if (lyellow_cards_away_all_time_away_fora.isEmpty()) {
            lyellow_cards_away_all_time_away_fora.add(0);
        }
        if (lyellow_cards_away_all_time_away_ithome.isEmpty()) {
            lyellow_cards_away_all_time_away_ithome.add(0);
        }
        if (lyellow_cards_away_all_time_away_itaway.isEmpty()) {
            lyellow_cards_away_all_time_away_itaway.add(0);
        }
        if (lshots_on_target_home_first_time_home_fora.isEmpty()) {
            lshots_on_target_home_first_time_home_fora.add(0);
        }
        if (lshots_on_target_home_first_time_total.isEmpty()) {
            lshots_on_target_home_first_time_total.add(0);
        }
        if (lshots_on_target_home_first_time_home_ithome.isEmpty()) {
            lshots_on_target_home_first_time_home_ithome.add(0);
        }
        if (lshots_on_target_home_first_time_home_itaway.isEmpty()) {
            lshots_on_target_home_first_time_home_itaway.add(0);
        }
        if (lshots_on_target_home_first_time_away_fora.isEmpty()) {
            lshots_on_target_home_first_time_away_fora.add(0);
        }
        if (lshots_on_target_home_first_time_away_ithome.isEmpty()) {
            lshots_on_target_home_first_time_away_ithome.add(0);
        }
        if (lshots_on_target_home_first_time_away_itaway.isEmpty()) {
            lshots_on_target_home_first_time_away_itaway.add(0);
        }
        if (lshots_on_target_away_first_time_home_fora.isEmpty()) {
            lshots_on_target_away_first_time_home_fora.add(0);
        }
        if (lshots_on_target_away_first_time_total.isEmpty()) {
            lshots_on_target_away_first_time_total.add(0);
        }
        if (lshots_on_target_away_first_time_home_ithome.isEmpty()) {
            lshots_on_target_away_first_time_home_ithome.add(0);
        }
        if (lshots_on_target_away_first_time_home_itaway.isEmpty()) {
            lshots_on_target_away_first_time_home_itaway.add(0);
        }
        if (lshots_on_target_away_first_time_away_fora.isEmpty()) {
            lshots_on_target_away_first_time_away_fora.add(0);
        }
        if (lshots_on_target_away_first_time_away_ithome.isEmpty()) {
            lshots_on_target_away_first_time_away_ithome.add(0);
        }
        if (lshots_on_target_away_first_time_away_itaway.isEmpty()) {
            lshots_on_target_away_first_time_away_itaway.add(0);
        }
        if (lshots_on_target_home_second_time_home_fora.isEmpty()) {
            lshots_on_target_home_second_time_home_fora.add(0);
        }
        if (lshots_on_target_home_second_time_total.isEmpty()) {
            lshots_on_target_home_second_time_total.add(0);
        }
        if (lshots_on_target_home_second_time_home_ithome.isEmpty()) {
            lshots_on_target_home_second_time_home_ithome.add(0);
        }
        if (lshots_on_target_home_second_time_home_itaway.isEmpty()) {
            lshots_on_target_home_second_time_home_itaway.add(0);
        }
        if (lshots_on_target_home_second_time_away_fora.isEmpty()) {
            lshots_on_target_home_second_time_away_fora.add(0);
        }
        if (lshots_on_target_home_second_time_away_ithome.isEmpty()) {
            lshots_on_target_home_second_time_away_ithome.add(0);
        }
        if (lshots_on_target_home_second_time_away_itaway.isEmpty()) {
            lshots_on_target_home_second_time_away_itaway.add(0);
        }
        if (lshots_on_target_away_second_time_home_fora.isEmpty()) {
            lshots_on_target_away_second_time_home_fora.add(0);
        }
        if (lshots_on_target_away_second_time_total.isEmpty()) {
            lshots_on_target_away_second_time_total.add(0);
        }
        if (lshots_on_target_away_second_time_home_ithome.isEmpty()) {
            lshots_on_target_away_second_time_home_ithome.add(0);
        }
        if (lshots_on_target_away_second_time_home_itaway.isEmpty()) {
            lshots_on_target_away_second_time_home_itaway.add(0);
        }
        if (lshots_on_target_away_second_time_away_fora.isEmpty()) {
            lshots_on_target_away_second_time_away_fora.add(0);
        }
        if (lshots_on_target_away_second_time_away_ithome.isEmpty()) {
            lshots_on_target_away_second_time_away_ithome.add(0);
        }
        if (lshots_on_target_away_second_time_away_itaway.isEmpty()) {
            lshots_on_target_away_second_time_away_itaway.add(0);
        }
        if (lshots_on_target_home_all_time_home_fora.isEmpty()) {
            lshots_on_target_home_all_time_home_fora.add(0);
        }
        if (lshots_on_target_home_all_time_total.isEmpty()) {
            lshots_on_target_home_all_time_total.add(0);
        }
        if (lshots_on_target_home_all_time_home_ithome.isEmpty()) {
            lshots_on_target_home_all_time_home_ithome.add(0);
        }
        if (lshots_on_target_home_all_time_home_itaway.isEmpty()) {
            lshots_on_target_home_all_time_home_itaway.add(0);
        }
        if (lshots_on_target_home_all_time_away_fora.isEmpty()) {
            lshots_on_target_home_all_time_away_fora.add(0);
        }
        if (lshots_on_target_home_all_time_away_ithome.isEmpty()) {
            lshots_on_target_home_all_time_away_ithome.add(0);
        }
        if (lshots_on_target_home_all_time_away_itaway.isEmpty()) {
            lshots_on_target_home_all_time_away_itaway.add(0);
        }
        if (lshots_on_target_away_all_time_home_fora.isEmpty()) {
            lshots_on_target_away_all_time_home_fora.add(0);
        }
        if (lshots_on_target_away_all_time_total.isEmpty()) {
            lshots_on_target_away_all_time_total.add(0);
        }
        if (lshots_on_target_away_all_time_home_ithome.isEmpty()) {
            lshots_on_target_away_all_time_home_ithome.add(0);
        }
        if (lshots_on_target_away_all_time_home_itaway.isEmpty()) {
            lshots_on_target_away_all_time_home_itaway.add(0);
        }
        if (lshots_on_target_away_all_time_away_fora.isEmpty()) {
            lshots_on_target_away_all_time_away_fora.add(0);
        }
        if (lshots_on_target_away_all_time_away_ithome.isEmpty()) {
            lshots_on_target_away_all_time_away_ithome.add(0);
        }
        if (lshots_on_target_away_all_time_away_itaway.isEmpty()) {
            lshots_on_target_away_all_time_away_itaway.add(0);
        }
        if (loffsides_home_first_time_home_fora.isEmpty()) {
            loffsides_home_first_time_home_fora.add(0);
        }
        if (loffsides_home_first_time_total.isEmpty()) {
            loffsides_home_first_time_total.add(0);
        }
        if (loffsides_home_first_time_home_ithome.isEmpty()) {
            loffsides_home_first_time_home_ithome.add(0);
        }
        if (loffsides_home_first_time_home_itaway.isEmpty()) {
            loffsides_home_first_time_home_itaway.add(0);
        }
        if (loffsides_home_first_time_away_fora.isEmpty()) {
            loffsides_home_first_time_away_fora.add(0);
        }
        if (loffsides_home_first_time_away_ithome.isEmpty()) {
            loffsides_home_first_time_away_ithome.add(0);
        }
        if (loffsides_home_first_time_away_itaway.isEmpty()) {
            loffsides_home_first_time_away_itaway.add(0);
        }
        if (loffsides_away_first_time_home_fora.isEmpty()) {
            loffsides_away_first_time_home_fora.add(0);
        }
        if (loffsides_away_first_time_total.isEmpty()) {
            loffsides_away_first_time_total.add(0);
        }
        if (loffsides_away_first_time_home_ithome.isEmpty()) {
            loffsides_away_first_time_home_ithome.add(0);
        }
        if (loffsides_away_first_time_home_itaway.isEmpty()) {
            loffsides_away_first_time_home_itaway.add(0);
        }
        if (loffsides_away_first_time_away_fora.isEmpty()) {
            loffsides_away_first_time_away_fora.add(0);
        }
        if (loffsides_away_first_time_away_ithome.isEmpty()) {
            loffsides_away_first_time_away_ithome.add(0);
        }
        if (loffsides_away_first_time_away_itaway.isEmpty()) {
            loffsides_away_first_time_away_itaway.add(0);
        }
        if (loffsides_home_second_time_home_fora.isEmpty()) {
            loffsides_home_second_time_home_fora.add(0);
        }
        if (loffsides_home_second_time_total.isEmpty()) {
            loffsides_home_second_time_total.add(0);
        }
        if (loffsides_home_second_time_home_ithome.isEmpty()) {
            loffsides_home_second_time_home_ithome.add(0);
        }
        if (loffsides_home_second_time_home_itaway.isEmpty()) {
            loffsides_home_second_time_home_itaway.add(0);
        }
        if (loffsides_home_second_time_away_fora.isEmpty()) {
            loffsides_home_second_time_away_fora.add(0);
        }
        if (loffsides_home_second_time_away_ithome.isEmpty()) {
            loffsides_home_second_time_away_ithome.add(0);
        }
        if (loffsides_home_second_time_away_itaway.isEmpty()) {
            loffsides_home_second_time_away_itaway.add(0);
        }
        if (loffsides_away_second_time_home_fora.isEmpty()) {
            loffsides_away_second_time_home_fora.add(0);
        }
        if (loffsides_away_second_time_total.isEmpty()) {
            loffsides_away_second_time_total.add(0);
        }
        if (loffsides_away_second_time_home_ithome.isEmpty()) {
            loffsides_away_second_time_home_ithome.add(0);
        }
        if (loffsides_away_second_time_home_itaway.isEmpty()) {
            loffsides_away_second_time_home_itaway.add(0);
        }
        if (loffsides_away_second_time_away_fora.isEmpty()) {
            loffsides_away_second_time_away_fora.add(0);
        }
        if (loffsides_away_second_time_away_ithome.isEmpty()) {
            loffsides_away_second_time_away_ithome.add(0);
        }
        if (loffsides_away_second_time_away_itaway.isEmpty()) {
            loffsides_away_second_time_away_itaway.add(0);
        }
        if (loffsides_home_all_time_home_fora.isEmpty()) {
            loffsides_home_all_time_home_fora.add(0);
        }
        if (loffsides_home_all_time_total.isEmpty()) {
            loffsides_home_all_time_total.add(0);
        }
        if (loffsides_home_all_time_home_ithome.isEmpty()) {
            loffsides_home_all_time_home_ithome.add(0);
        }
        if (loffsides_home_all_time_home_itaway.isEmpty()) {
            loffsides_home_all_time_home_itaway.add(0);
        }
        if (loffsides_home_all_time_away_fora.isEmpty()) {
            loffsides_home_all_time_away_fora.add(0);
        }
        if (loffsides_home_all_time_away_ithome.isEmpty()) {
            loffsides_home_all_time_away_ithome.add(0);
        }
        if (loffsides_home_all_time_away_itaway.isEmpty()) {
            loffsides_home_all_time_away_itaway.add(0);
        }
        if (loffsides_away_all_time_home_fora.isEmpty()) {
            loffsides_away_all_time_home_fora.add(0);
        }
        if (loffsides_away_all_time_total.isEmpty()) {
            loffsides_away_all_time_total.add(0);
        }
        if (loffsides_away_all_time_home_ithome.isEmpty()) {
            loffsides_away_all_time_home_ithome.add(0);
        }
        if (loffsides_away_all_time_home_itaway.isEmpty()) {
            loffsides_away_all_time_home_itaway.add(0);
        }
        if (loffsides_away_all_time_away_fora.isEmpty()) {
            loffsides_away_all_time_away_fora.add(0);
        }
        if (loffsides_away_all_time_away_ithome.isEmpty()) {
            loffsides_away_all_time_away_ithome.add(0);
        }
        if (loffsides_away_all_time_away_itaway.isEmpty()) {
            loffsides_away_all_time_away_itaway.add(0);
        }
        if (lfouls_home_first_time_home_fora.isEmpty()) {
            lfouls_home_first_time_home_fora.add(0);
        }
        if (lfouls_home_first_time_total.isEmpty()) {
            lfouls_home_first_time_total.add(0);
        }
        if (lfouls_home_first_time_home_ithome.isEmpty()) {
            lfouls_home_first_time_home_ithome.add(0);
        }
        if (lfouls_home_first_time_home_itaway.isEmpty()) {
            lfouls_home_first_time_home_itaway.add(0);
        }
        if (lfouls_home_first_time_away_fora.isEmpty()) {
            lfouls_home_first_time_away_fora.add(0);
        }
        if (lfouls_home_first_time_away_ithome.isEmpty()) {
            lfouls_home_first_time_away_ithome.add(0);
        }
        if (lfouls_home_first_time_away_itaway.isEmpty()) {
            lfouls_home_first_time_away_itaway.add(0);
        }
        if (lfouls_away_first_time_home_fora.isEmpty()) {
            lfouls_away_first_time_home_fora.add(0);
        }
        if (lfouls_away_first_time_total.isEmpty()) {
            lfouls_away_first_time_total.add(0);
        }
        if (lfouls_away_first_time_home_ithome.isEmpty()) {
            lfouls_away_first_time_home_ithome.add(0);
        }
        if (lfouls_away_first_time_home_itaway.isEmpty()) {
            lfouls_away_first_time_home_itaway.add(0);
        }
        if (lfouls_away_first_time_away_fora.isEmpty()) {
            lfouls_away_first_time_away_fora.add(0);
        }
        if (lfouls_away_first_time_away_ithome.isEmpty()) {
            lfouls_away_first_time_away_ithome.add(0);
        }
        if (lfouls_away_first_time_away_itaway.isEmpty()) {
            lfouls_away_first_time_away_itaway.add(0);
        }
        if (lfouls_home_second_time_home_fora.isEmpty()) {
            lfouls_home_second_time_home_fora.add(0);
        }
        if (lfouls_home_second_time_total.isEmpty()) {
            lfouls_home_second_time_total.add(0);
        }
        if (lfouls_home_second_time_home_ithome.isEmpty()) {
            lfouls_home_second_time_home_ithome.add(0);
        }
        if (lfouls_home_second_time_home_itaway.isEmpty()) {
            lfouls_home_second_time_home_itaway.add(0);
        }
        if (lfouls_home_second_time_away_fora.isEmpty()) {
            lfouls_home_second_time_away_fora.add(0);
        }
        if (lfouls_home_second_time_away_ithome.isEmpty()) {
            lfouls_home_second_time_away_ithome.add(0);
        }
        if (lfouls_home_second_time_away_itaway.isEmpty()) {
            lfouls_home_second_time_away_itaway.add(0);
        }
        if (lfouls_away_second_time_home_fora.isEmpty()) {
            lfouls_away_second_time_home_fora.add(0);
        }
        if (lfouls_away_second_time_total.isEmpty()) {
            lfouls_away_second_time_total.add(0);
        }
        if (lfouls_away_second_time_home_ithome.isEmpty()) {
            lfouls_away_second_time_home_ithome.add(0);
        }
        if (lfouls_away_second_time_home_itaway.isEmpty()) {
            lfouls_away_second_time_home_itaway.add(0);
        }
        if (lfouls_away_second_time_away_fora.isEmpty()) {
            lfouls_away_second_time_away_fora.add(0);
        }
        if (lfouls_away_second_time_away_ithome.isEmpty()) {
            lfouls_away_second_time_away_ithome.add(0);
        }
        if (lfouls_away_second_time_away_itaway.isEmpty()) {
            lfouls_away_second_time_away_itaway.add(0);
        }
        if (lfouls_home_all_time_home_fora.isEmpty()) {
            lfouls_home_all_time_home_fora.add(0);
        }
        if (lfouls_home_all_time_total.isEmpty()) {
            lfouls_home_all_time_total.add(0);
        }
        if (lfouls_home_all_time_home_ithome.isEmpty()) {
            lfouls_home_all_time_home_ithome.add(0);
        }
        if (lfouls_home_all_time_home_itaway.isEmpty()) {
            lfouls_home_all_time_home_itaway.add(0);
        }
        if (lfouls_home_all_time_away_fora.isEmpty()) {
            lfouls_home_all_time_away_fora.add(0);
        }
        if (lfouls_home_all_time_away_ithome.isEmpty()) {
            lfouls_home_all_time_away_ithome.add(0);
        }
        if (lfouls_home_all_time_away_itaway.isEmpty()) {
            lfouls_home_all_time_away_itaway.add(0);
        }
        if (lfouls_away_all_time_home_fora.isEmpty()) {
            lfouls_away_all_time_home_fora.add(0);
        }
        if (lfouls_away_all_time_total.isEmpty()) {
            lfouls_away_all_time_total.add(0);
        }
        if (lfouls_away_all_time_home_ithome.isEmpty()) {
            lfouls_away_all_time_home_ithome.add(0);
        }
        if (lfouls_away_all_time_home_itaway.isEmpty()) {
            lfouls_away_all_time_home_itaway.add(0);
        }
        if (lfouls_away_all_time_away_fora.isEmpty()) {
            lfouls_away_all_time_away_fora.add(0);
        }
        if (lfouls_away_all_time_away_ithome.isEmpty()) {
            lfouls_away_all_time_away_ithome.add(0);
        }
        if (lfouls_away_all_time_away_itaway.isEmpty()) {
            lfouls_away_all_time_away_itaway.add(0);
        }

        model.addAttribute("corners_home_first_time_home_fora", lcorners_home_first_time_home_fora);
        model.addAttribute("corners_home_first_time_total", lcorners_home_first_time_total);
        model.addAttribute("corners_home_first_time_home_ithome", lcorners_home_first_time_home_ithome);
        model.addAttribute("corners_home_first_time_home_itaway", lcorners_home_first_time_home_itaway);
        model.addAttribute("corners_home_first_time_away_fora", lcorners_home_first_time_away_fora);
        model.addAttribute("corners_home_first_time_away_ithome", lcorners_home_first_time_away_ithome);
        model.addAttribute("corners_home_first_time_away_itaway", lcorners_home_first_time_away_itaway);
        model.addAttribute("corners_away_first_time_home_fora", lcorners_away_first_time_home_fora);
        model.addAttribute("corners_away_first_time_total", lcorners_away_first_time_total);
        model.addAttribute("corners_away_first_time_home_ithome", lcorners_away_first_time_home_ithome);
        model.addAttribute("corners_away_first_time_home_itaway", lcorners_away_first_time_home_itaway);
        model.addAttribute("corners_away_first_time_away_fora", lcorners_away_first_time_away_fora);
        model.addAttribute("corners_away_first_time_away_ithome", lcorners_away_first_time_away_ithome);
        model.addAttribute("corners_away_first_time_away_itaway", lcorners_away_first_time_away_itaway);
        model.addAttribute("corners_home_second_time_home_fora", lcorners_home_second_time_home_fora);
        model.addAttribute("corners_home_second_time_total", lcorners_home_second_time_total);
        model.addAttribute("corners_home_second_time_home_ithome", lcorners_home_second_time_home_ithome);
        model.addAttribute("corners_home_second_time_home_itaway", lcorners_home_second_time_home_itaway);
        model.addAttribute("corners_home_second_time_away_fora", lcorners_home_second_time_away_fora);
        model.addAttribute("corners_home_second_time_away_ithome", lcorners_home_second_time_away_ithome);
        model.addAttribute("corners_home_second_time_away_itaway", lcorners_home_second_time_away_itaway);
        model.addAttribute("corners_away_second_time_home_fora", lcorners_away_second_time_home_fora);
        model.addAttribute("corners_away_second_time_total", lcorners_away_second_time_total);
        model.addAttribute("corners_away_second_time_home_ithome", lcorners_away_second_time_home_ithome);
        model.addAttribute("corners_away_second_time_home_itaway", lcorners_away_second_time_home_itaway);
        model.addAttribute("corners_away_second_time_away_fora", lcorners_away_second_time_away_fora);
        model.addAttribute("corners_away_second_time_away_ithome", lcorners_away_second_time_away_ithome);
        model.addAttribute("corners_away_second_time_away_itaway", lcorners_away_second_time_away_itaway);
        model.addAttribute("corners_home_all_time_home_fora", lcorners_home_all_time_home_fora);
        model.addAttribute("corners_home_all_time_total", lcorners_home_all_time_total);
        model.addAttribute("corners_home_all_time_home_ithome", lcorners_home_all_time_home_ithome);
        model.addAttribute("corners_home_all_time_home_itaway", lcorners_home_all_time_home_itaway);
        model.addAttribute("corners_home_all_time_away_fora", lcorners_home_all_time_away_fora);
        model.addAttribute("corners_home_all_time_away_ithome", lcorners_home_all_time_away_ithome);
        model.addAttribute("corners_home_all_time_away_itaway", lcorners_home_all_time_away_itaway);
        model.addAttribute("corners_away_all_time_home_fora", lcorners_away_all_time_home_fora);
        model.addAttribute("corners_away_all_time_total", lcorners_away_all_time_total);
        model.addAttribute("corners_away_all_time_home_ithome", lcorners_away_all_time_home_ithome);
        model.addAttribute("corners_away_all_time_home_itaway", lcorners_away_all_time_home_itaway);
        model.addAttribute("corners_away_all_time_away_fora", lcorners_away_all_time_away_fora);
        model.addAttribute("corners_away_all_time_away_ithome", lcorners_away_all_time_away_ithome);
        model.addAttribute("corners_away_all_time_away_itaway", lcorners_away_all_time_away_itaway);
        model.addAttribute("yellow_cards_home_first_time_home_fora", lyellow_cards_home_first_time_home_fora);
        model.addAttribute("yellow_cards_home_first_time_total", lyellow_cards_home_first_time_total);
        model.addAttribute("yellow_cards_home_first_time_home_ithome", lyellow_cards_home_first_time_home_ithome);
        model.addAttribute("yellow_cards_home_first_time_home_itaway", lyellow_cards_home_first_time_home_itaway);
        model.addAttribute("yellow_cards_home_first_time_away_fora", lyellow_cards_home_first_time_away_fora);
        model.addAttribute("yellow_cards_home_first_time_away_ithome", lyellow_cards_home_first_time_away_ithome);
        model.addAttribute("yellow_cards_home_first_time_away_itaway", lyellow_cards_home_first_time_away_itaway);
        model.addAttribute("yellow_cards_away_first_time_home_fora", lyellow_cards_away_first_time_home_fora);
        model.addAttribute("yellow_cards_away_first_time_total", lyellow_cards_away_first_time_total);
        model.addAttribute("yellow_cards_away_first_time_home_ithome", lyellow_cards_away_first_time_home_ithome);
        model.addAttribute("yellow_cards_away_first_time_home_itaway", lyellow_cards_away_first_time_home_itaway);
        model.addAttribute("yellow_cards_away_first_time_away_fora", lyellow_cards_away_first_time_away_fora);
        model.addAttribute("yellow_cards_away_first_time_away_ithome", lyellow_cards_away_first_time_away_ithome);
        model.addAttribute("yellow_cards_away_first_time_away_itaway", lyellow_cards_away_first_time_away_itaway);
        model.addAttribute("yellow_cards_home_second_time_home_fora", lyellow_cards_home_second_time_home_fora);
        model.addAttribute("yellow_cards_home_second_time_total", lyellow_cards_home_second_time_total);
        model.addAttribute("yellow_cards_home_second_time_home_ithome", lyellow_cards_home_second_time_home_ithome);
        model.addAttribute("yellow_cards_home_second_time_home_itaway", lyellow_cards_home_second_time_home_itaway);
        model.addAttribute("yellow_cards_home_second_time_away_fora", lyellow_cards_home_second_time_away_fora);
        model.addAttribute("yellow_cards_home_second_time_away_ithome", lyellow_cards_home_second_time_away_ithome);
        model.addAttribute("yellow_cards_home_second_time_away_itaway", lyellow_cards_home_second_time_away_itaway);
        model.addAttribute("yellow_cards_away_second_time_home_fora", lyellow_cards_away_second_time_home_fora);
        model.addAttribute("yellow_cards_away_second_time_total", lyellow_cards_away_second_time_total);
        model.addAttribute("yellow_cards_away_second_time_home_ithome", lyellow_cards_away_second_time_home_ithome);
        model.addAttribute("yellow_cards_away_second_time_home_itaway", lyellow_cards_away_second_time_home_itaway);
        model.addAttribute("yellow_cards_away_second_time_away_fora", lyellow_cards_away_second_time_away_fora);
        model.addAttribute("yellow_cards_away_second_time_away_ithome", lyellow_cards_away_second_time_away_ithome);
        model.addAttribute("yellow_cards_away_second_time_away_itaway", lyellow_cards_away_second_time_away_itaway);
        model.addAttribute("yellow_cards_home_all_time_home_fora", lyellow_cards_home_all_time_home_fora);
        model.addAttribute("yellow_cards_home_all_time_total", lyellow_cards_home_all_time_total);
        model.addAttribute("yellow_cards_home_all_time_home_ithome", lyellow_cards_home_all_time_home_ithome);
        model.addAttribute("yellow_cards_home_all_time_home_itaway", lyellow_cards_home_all_time_home_itaway);
        model.addAttribute("yellow_cards_home_all_time_away_fora", lyellow_cards_home_all_time_away_fora);
        model.addAttribute("yellow_cards_home_all_time_away_ithome", lyellow_cards_home_all_time_away_ithome);
        model.addAttribute("yellow_cards_home_all_time_away_itaway", lyellow_cards_home_all_time_away_itaway);
        model.addAttribute("yellow_cards_away_all_time_home_fora", lyellow_cards_away_all_time_home_fora);
        model.addAttribute("yellow_cards_away_all_time_total", lyellow_cards_away_all_time_total);
        model.addAttribute("yellow_cards_away_all_time_home_ithome", lyellow_cards_away_all_time_home_ithome);
        model.addAttribute("yellow_cards_away_all_time_home_itaway", lyellow_cards_away_all_time_home_itaway);
        model.addAttribute("yellow_cards_away_all_time_away_fora", lyellow_cards_away_all_time_away_fora);
        model.addAttribute("yellow_cards_away_all_time_away_ithome", lyellow_cards_away_all_time_away_ithome);
        model.addAttribute("yellow_cards_away_all_time_away_itaway", lyellow_cards_away_all_time_away_itaway);
        model.addAttribute("shots_on_target_home_first_time_home_fora", lshots_on_target_home_first_time_home_fora);
        model.addAttribute("shots_on_target_home_first_time_total", lshots_on_target_home_first_time_total);
        model.addAttribute("shots_on_target_home_first_time_home_ithome", lshots_on_target_home_first_time_home_ithome);
        model.addAttribute("shots_on_target_home_first_time_home_itaway", lshots_on_target_home_first_time_home_itaway);
        model.addAttribute("shots_on_target_home_first_time_away_fora", lshots_on_target_home_first_time_away_fora);
        model.addAttribute("shots_on_target_home_first_time_away_ithome", lshots_on_target_home_first_time_away_ithome);
        model.addAttribute("shots_on_target_home_first_time_away_itaway", lshots_on_target_home_first_time_away_itaway);
        model.addAttribute("shots_on_target_away_first_time_home_fora", lshots_on_target_away_first_time_home_fora);
        model.addAttribute("shots_on_target_away_first_time_total", lshots_on_target_away_first_time_total);
        model.addAttribute("shots_on_target_away_first_time_home_ithome", lshots_on_target_away_first_time_home_ithome);
        model.addAttribute("shots_on_target_away_first_time_home_itaway", lshots_on_target_away_first_time_home_itaway);
        model.addAttribute("shots_on_target_away_first_time_away_fora", lshots_on_target_away_first_time_away_fora);
        model.addAttribute("shots_on_target_away_first_time_away_ithome", lshots_on_target_away_first_time_away_ithome);
        model.addAttribute("shots_on_target_away_first_time_away_itaway", lshots_on_target_away_first_time_away_itaway);
        model.addAttribute("shots_on_target_home_second_time_home_fora", lshots_on_target_home_second_time_home_fora);
        model.addAttribute("shots_on_target_home_second_time_total", lshots_on_target_home_second_time_total);
        model.addAttribute("shots_on_target_home_second_time_home_ithome", lshots_on_target_home_second_time_home_ithome);
        model.addAttribute("shots_on_target_home_second_time_home_itaway", lshots_on_target_home_second_time_home_itaway);
        model.addAttribute("shots_on_target_home_second_time_away_fora", lshots_on_target_home_second_time_away_fora);
        model.addAttribute("shots_on_target_home_second_time_away_ithome", lshots_on_target_home_second_time_away_ithome);
        model.addAttribute("shots_on_target_home_second_time_away_itaway", lshots_on_target_home_second_time_away_itaway);
        model.addAttribute("shots_on_target_away_second_time_home_fora", lshots_on_target_away_second_time_home_fora);
        model.addAttribute("shots_on_target_away_second_time_total", lshots_on_target_away_second_time_total);
        model.addAttribute("shots_on_target_away_second_time_home_ithome", lshots_on_target_away_second_time_home_ithome);
        model.addAttribute("shots_on_target_away_second_time_home_itaway", lshots_on_target_away_second_time_home_itaway);
        model.addAttribute("shots_on_target_away_second_time_away_fora", lshots_on_target_away_second_time_away_fora);
        model.addAttribute("shots_on_target_away_second_time_away_ithome", lshots_on_target_away_second_time_away_ithome);
        model.addAttribute("shots_on_target_away_second_time_away_itaway", lshots_on_target_away_second_time_away_itaway);
        model.addAttribute("shots_on_target_home_all_time_home_fora", lshots_on_target_home_all_time_home_fora);
        model.addAttribute("shots_on_target_home_all_time_total", lshots_on_target_home_all_time_total);
        model.addAttribute("shots_on_target_home_all_time_home_ithome", lshots_on_target_home_all_time_home_ithome);
        model.addAttribute("shots_on_target_home_all_time_home_itaway", lshots_on_target_home_all_time_home_itaway);
        model.addAttribute("shots_on_target_home_all_time_away_fora", lshots_on_target_home_all_time_away_fora);
        model.addAttribute("shots_on_target_home_all_time_away_ithome", lshots_on_target_home_all_time_away_ithome);
        model.addAttribute("shots_on_target_home_all_time_away_itaway", lshots_on_target_home_all_time_away_itaway);
        model.addAttribute("shots_on_target_away_all_time_home_fora", lshots_on_target_away_all_time_home_fora);
        model.addAttribute("shots_on_target_away_all_time_total", lshots_on_target_away_all_time_total);
        model.addAttribute("shots_on_target_away_all_time_home_ithome", lshots_on_target_away_all_time_home_ithome);
        model.addAttribute("shots_on_target_away_all_time_home_itaway", lshots_on_target_away_all_time_home_itaway);
        model.addAttribute("shots_on_target_away_all_time_away_fora", lshots_on_target_away_all_time_away_fora);
        model.addAttribute("shots_on_target_away_all_time_away_ithome", lshots_on_target_away_all_time_away_ithome);
        model.addAttribute("shots_on_target_away_all_time_away_itaway", lshots_on_target_away_all_time_away_itaway);
        model.addAttribute("offsides_home_first_time_home_fora", loffsides_home_first_time_home_fora);
        model.addAttribute("offsides_home_first_time_total", loffsides_home_first_time_total);
        model.addAttribute("offsides_home_first_time_home_ithome", loffsides_home_first_time_home_ithome);
        model.addAttribute("offsides_home_first_time_home_itaway", loffsides_home_first_time_home_itaway);
        model.addAttribute("offsides_home_first_time_away_fora", loffsides_home_first_time_away_fora);
        model.addAttribute("offsides_home_first_time_away_ithome", loffsides_home_first_time_away_ithome);
        model.addAttribute("offsides_home_first_time_away_itaway", loffsides_home_first_time_away_itaway);
        model.addAttribute("offsides_away_first_time_home_fora", loffsides_away_first_time_home_fora);
        model.addAttribute("offsides_away_first_time_total", loffsides_away_first_time_total);
        model.addAttribute("offsides_away_first_time_home_ithome", loffsides_away_first_time_home_ithome);
        model.addAttribute("offsides_away_first_time_home_itaway", loffsides_away_first_time_home_itaway);
        model.addAttribute("offsides_away_first_time_away_fora", loffsides_away_first_time_away_fora);
        model.addAttribute("offsides_away_first_time_away_ithome", loffsides_away_first_time_away_ithome);
        model.addAttribute("offsides_away_first_time_away_itaway", loffsides_away_first_time_away_itaway);
        model.addAttribute("offsides_home_second_time_home_fora", loffsides_home_second_time_home_fora);
        model.addAttribute("offsides_home_second_time_total", loffsides_home_second_time_total);
        model.addAttribute("offsides_home_second_time_home_ithome", loffsides_home_second_time_home_ithome);
        model.addAttribute("offsides_home_second_time_home_itaway", loffsides_home_second_time_home_itaway);
        model.addAttribute("offsides_home_second_time_away_fora", loffsides_home_second_time_away_fora);
        model.addAttribute("offsides_home_second_time_away_ithome", loffsides_home_second_time_away_ithome);
        model.addAttribute("offsides_home_second_time_away_itaway", loffsides_home_second_time_away_itaway);
        model.addAttribute("offsides_away_second_time_home_fora", loffsides_away_second_time_home_fora);
        model.addAttribute("offsides_away_second_time_total", loffsides_away_second_time_total);
        model.addAttribute("offsides_away_second_time_home_ithome", loffsides_away_second_time_home_ithome);
        model.addAttribute("offsides_away_second_time_home_itaway", loffsides_away_second_time_home_itaway);
        model.addAttribute("offsides_away_second_time_away_fora", loffsides_away_second_time_away_fora);
        model.addAttribute("offsides_away_second_time_away_ithome", loffsides_away_second_time_away_ithome);
        model.addAttribute("offsides_away_second_time_away_itaway", loffsides_away_second_time_away_itaway);
        model.addAttribute("offsides_home_all_time_home_fora", loffsides_home_all_time_home_fora);
        model.addAttribute("offsides_home_all_time_total", loffsides_home_all_time_total);
        model.addAttribute("offsides_home_all_time_home_ithome", loffsides_home_all_time_home_ithome);
        model.addAttribute("offsides_home_all_time_home_itaway", loffsides_home_all_time_home_itaway);
        model.addAttribute("offsides_home_all_time_away_fora", loffsides_home_all_time_away_fora);
        model.addAttribute("offsides_home_all_time_away_ithome", loffsides_home_all_time_away_ithome);
        model.addAttribute("offsides_home_all_time_away_itaway", loffsides_home_all_time_away_itaway);
        model.addAttribute("offsides_away_all_time_home_fora", loffsides_away_all_time_home_fora);
        model.addAttribute("offsides_away_all_time_total", loffsides_away_all_time_total);
        model.addAttribute("offsides_away_all_time_home_ithome", loffsides_away_all_time_home_ithome);
        model.addAttribute("offsides_away_all_time_home_itaway", loffsides_away_all_time_home_itaway);
        model.addAttribute("offsides_away_all_time_away_fora", loffsides_away_all_time_away_fora);
        model.addAttribute("offsides_away_all_time_away_ithome", loffsides_away_all_time_away_ithome);
        model.addAttribute("offsides_away_all_time_away_itaway", loffsides_away_all_time_away_itaway);
        model.addAttribute("fouls_home_first_time_home_fora", lfouls_home_first_time_home_fora);
        model.addAttribute("fouls_home_first_time_total", lfouls_home_first_time_total);
        model.addAttribute("fouls_home_first_time_home_ithome", lfouls_home_first_time_home_ithome);
        model.addAttribute("fouls_home_first_time_home_itaway", lfouls_home_first_time_home_itaway);
        model.addAttribute("fouls_home_first_time_away_fora", lfouls_home_first_time_away_fora);
        model.addAttribute("fouls_home_first_time_away_ithome", lfouls_home_first_time_away_ithome);
        model.addAttribute("fouls_home_first_time_away_itaway", lfouls_home_first_time_away_itaway);
        model.addAttribute("fouls_away_first_time_home_fora", lfouls_away_first_time_home_fora);
        model.addAttribute("fouls_away_first_time_total", lfouls_away_first_time_total);
        model.addAttribute("fouls_away_first_time_home_ithome", lfouls_away_first_time_home_ithome);
        model.addAttribute("fouls_away_first_time_home_itaway", lfouls_away_first_time_home_itaway);
        model.addAttribute("fouls_away_first_time_away_fora", lfouls_away_first_time_away_fora);
        model.addAttribute("fouls_away_first_time_away_ithome", lfouls_away_first_time_away_ithome);
        model.addAttribute("fouls_away_first_time_away_itaway", lfouls_away_first_time_away_itaway);
        model.addAttribute("fouls_home_second_time_home_fora", lfouls_home_second_time_home_fora);
        model.addAttribute("fouls_home_second_time_total", lfouls_home_second_time_total);
        model.addAttribute("fouls_home_second_time_home_ithome", lfouls_home_second_time_home_ithome);
        model.addAttribute("fouls_home_second_time_home_itaway", lfouls_home_second_time_home_itaway);
        model.addAttribute("fouls_home_second_time_away_fora", lfouls_home_second_time_away_fora);
        model.addAttribute("fouls_home_second_time_away_ithome", lfouls_home_second_time_away_ithome);
        model.addAttribute("fouls_home_second_time_away_itaway", lfouls_home_second_time_away_itaway);
        model.addAttribute("fouls_away_second_time_home_fora", lfouls_away_second_time_home_fora);
        model.addAttribute("fouls_away_second_time_total", lfouls_away_second_time_total);
        model.addAttribute("fouls_away_second_time_home_ithome", lfouls_away_second_time_home_ithome);
        model.addAttribute("fouls_away_second_time_home_itaway", lfouls_away_second_time_home_itaway);
        model.addAttribute("fouls_away_second_time_away_fora", lfouls_away_second_time_away_fora);
        model.addAttribute("fouls_away_second_time_away_ithome", lfouls_away_second_time_away_ithome);
        model.addAttribute("fouls_away_second_time_away_itaway", lfouls_away_second_time_away_itaway);
        model.addAttribute("fouls_home_all_time_home_fora", lfouls_home_all_time_home_fora);
        model.addAttribute("fouls_home_all_time_total", lfouls_home_all_time_total);
        model.addAttribute("fouls_home_all_time_home_ithome", lfouls_home_all_time_home_ithome);
        model.addAttribute("fouls_home_all_time_home_itaway", lfouls_home_all_time_home_itaway);
        model.addAttribute("fouls_home_all_time_away_fora", lfouls_home_all_time_away_fora);
        model.addAttribute("fouls_home_all_time_away_ithome", lfouls_home_all_time_away_ithome);
        model.addAttribute("fouls_home_all_time_away_itaway", lfouls_home_all_time_away_itaway);
        model.addAttribute("fouls_away_all_time_home_fora", lfouls_away_all_time_home_fora);
        model.addAttribute("fouls_away_all_time_total", lfouls_away_all_time_total);
        model.addAttribute("fouls_away_all_time_home_ithome", lfouls_away_all_time_home_ithome);
        model.addAttribute("fouls_away_all_time_home_itaway", lfouls_away_all_time_home_itaway);
        model.addAttribute("fouls_away_all_time_away_fora", lfouls_away_all_time_away_fora);
        model.addAttribute("fouls_away_all_time_away_ithome", lfouls_away_all_time_away_ithome);
        model.addAttribute("fouls_away_all_time_away_itaway", lfouls_away_all_time_away_itaway);
        return "match-analysis";
    }
    private void findSuccessEvent(event evs, coefficient_table coeffs, ArrayList<event> matchEvents, ArrayList<coefficient_table> matchCoefficient, Model model) {
        Optional<event> mEvent = eventRepository.findById(evs.getIdEvent());
        mEvent.ifPresent(matchEvents::add);
        System.out.println("Событие найдено! Его id: " + evs.getIdEvent());
        model.addAttribute("events", matchEvents);
        Optional<coefficient_table> mCoefficient = coefficientRepository.findById(coeffs.getIdCoefficient());
        mCoefficient.ifPresent(matchCoefficient::add);
        System.out.println("Коэффициент найден! Его id: " + coeffs.getIdCoefficient());
        model.addAttribute("coefficients", matchCoefficient);
    }

    private void analysSuccess(Double homeStat, Double awayStat, Double totalStat, event evs, coefficient_table coeffs, ArrayList<event> matchEvents, ArrayList<coefficient_table> matchCoefficient, Model model) {
        Double value = coeffs.getOutcomeValue();
        if (evs.getOccasion() == 3) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (awayStat + value > homeStat) {
                    findSuccessEvent(evs, coeffs, matchEvents, matchCoefficient, model);
                }
            } else {
                if (homeStat - value > awayStat) {
                    findSuccessEvent(evs, coeffs, matchEvents, matchCoefficient, model);
                }
            }
        } else if (evs.getOccasion() == 4) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (value > totalStat) {
                    findSuccessEvent(evs, coeffs, matchEvents, matchCoefficient, model);
                }
            } else {
                if (value < totalStat) {
                    findSuccessEvent(evs, coeffs, matchEvents, matchCoefficient, model);
                }
            }
        } else if (evs.getOccasion() == 5) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (value > homeStat) {
                    findSuccessEvent(evs, coeffs, matchEvents, matchCoefficient, model);
                }
            } else {
                if (value < homeStat) {
                    findSuccessEvent(evs, coeffs, matchEvents, matchCoefficient, model);
                }
            }
        } else if (evs.getOccasion() == 6) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (value > awayStat) {
                    findSuccessEvent(evs, coeffs, matchEvents, matchCoefficient, model);
                }
            } else {
                if (value < awayStat) {
                    findSuccessEvent(evs, coeffs, matchEvents, matchCoefficient, model);
                }
            }
        }
    }

    private void cornersCountMatches(int team, event evs, coefficient_table coeffs, ArrayList<match_table> lastMatchesTeamByLevel, ArrayList<Integer> lcorners_home_first_time_home_fora, ArrayList<Integer> lcorners_home_first_time_home_total, ArrayList<Integer> lcorners_home_first_time_home_ithome, ArrayList<Integer> lcorners_home_first_time_home_itaway) {
        Double value = coeffs.getOutcomeValue();
        int corners_home_first_time_home_fora = -1, corners_home_first_time_total = -1, corners_home_first_time_home_ithome = -1, corners_home_first_time_home_itaway = -1;
        int corners_home_first_time_away_fora = -1, corners_home_first_time_away_ithome = -1, corners_home_first_time_away_itaway = -1;
        int corners_home_first_time_home_fora2 = -1, corners_home_first_time_total2 = -1, corners_home_first_time_home_ithome2 = -1, corners_home_first_time_home_itaway2 = -1;
        int corners_home_first_time_away_fora2 = -1, corners_home_first_time_away_ithome2 = -1, corners_home_first_time_away_itaway2 = -1;
        for (match_table match : lastMatchesTeamByLevel) {
            if (evs.getGamePeriod() == 0) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getCornerFirstHalfGuest() + match.getCornerSecondHalfGuest() + value > match.getCornerFirstHalfHome() + match.getCornerSecondHalfHome()) {
                                corners_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getCornerFirstHalfHome() + match.getCornerSecondHalfHome() + value > match.getCornerFirstHalfGuest() + match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getCornerFirstHalfHome() + match.getCornerSecondHalfHome() - value > match.getCornerFirstHalfGuest() + match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getCornerFirstHalfGuest() + match.getCornerSecondHalfGuest() - value > match.getCornerFirstHalfHome() + match.getCornerSecondHalfHome()) {
                                corners_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getCornerFirstHalfHome() + match.getCornerSecondHalfHome() + match.getCornerFirstHalfGuest() + match.getCornerSecondHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            corners_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            corners_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getCornerFirstHalfHome() + match.getCornerSecondHalfHome()) {
                                corners_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getCornerFirstHalfGuest() + match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getCornerFirstHalfHome() + match.getCornerSecondHalfHome()) {
                                corners_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getCornerFirstHalfGuest() + match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getCornerFirstHalfGuest() + match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getCornerFirstHalfHome() + match.getCornerSecondHalfHome()) {
                                corners_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getCornerFirstHalfGuest() + match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getCornerFirstHalfHome() + match.getCornerSecondHalfHome()) {
                                corners_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            } else if (evs.getGamePeriod() == 1) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getCornerFirstHalfGuest() + value > match.getCornerFirstHalfHome()) {
                                corners_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getCornerFirstHalfHome() + value > match.getCornerFirstHalfGuest()) {
                                corners_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getCornerFirstHalfHome() - value > match.getCornerFirstHalfGuest()) {
                                corners_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getCornerFirstHalfGuest() - value > match.getCornerFirstHalfHome()) {
                                corners_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getCornerFirstHalfHome() + match.getCornerFirstHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            corners_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            corners_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getCornerFirstHalfHome()) {
                                corners_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getCornerFirstHalfGuest()) {
                                corners_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getCornerFirstHalfHome()) {
                                corners_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getCornerFirstHalfGuest()) {
                                corners_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getCornerFirstHalfGuest()) {
                                corners_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getCornerFirstHalfHome()) {
                                corners_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getCornerFirstHalfGuest()) {
                                corners_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getCornerFirstHalfHome()) {
                                corners_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            } else if (evs.getGamePeriod() == 2) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getCornerSecondHalfGuest() + value > match.getCornerSecondHalfHome()) {
                                corners_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getCornerSecondHalfHome() + value > match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getCornerSecondHalfHome() - value > match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getCornerSecondHalfGuest() - value > match.getCornerSecondHalfHome()) {
                                corners_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getCornerSecondHalfHome() + match.getCornerSecondHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            corners_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            corners_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getCornerSecondHalfHome()) {
                                corners_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getCornerSecondHalfHome()) {
                                corners_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getCornerSecondHalfHome()) {
                                corners_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getCornerSecondHalfGuest()) {
                                corners_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getCornerSecondHalfHome()) {
                                corners_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            }
        }
        if (team == 1) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (corners_home_first_time_home_fora > 6) {
                    lcorners_home_first_time_home_fora.add(corners_home_first_time_home_fora + 1);
                }
                if (corners_home_first_time_total > 6) {
                    lcorners_home_first_time_home_total.add(corners_home_first_time_total + 1);
                }
                if (corners_home_first_time_home_ithome > 6) {
                    lcorners_home_first_time_home_ithome.add(corners_home_first_time_home_ithome + 1);
                }
                if (corners_home_first_time_home_itaway > 6) {
                    lcorners_home_first_time_home_itaway.add(corners_home_first_time_home_itaway + 1);
                }
            } else {
                if (corners_home_first_time_home_fora2 > 6) {
                    lcorners_home_first_time_home_fora.add(corners_home_first_time_home_fora2 + 1);
                }
                if (corners_home_first_time_total2 > 6) {
                    lcorners_home_first_time_home_total.add(corners_home_first_time_total2 + 1);
                }
                if (corners_home_first_time_home_ithome2 > 6) {
                    lcorners_home_first_time_home_ithome.add(corners_home_first_time_home_ithome2 + 1);
                }
                if (corners_home_first_time_home_itaway2 > 6) {
                    lcorners_home_first_time_home_itaway.add(corners_home_first_time_home_itaway2 + 1);
                }
            }
        } else if (team == 2) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (corners_home_first_time_away_fora > 6) {
                    lcorners_home_first_time_home_fora.add(corners_home_first_time_away_fora + 1);
                }
                if (corners_home_first_time_total > 6) {
                    lcorners_home_first_time_home_total.add(corners_home_first_time_total + 1);
                }
                if (corners_home_first_time_away_ithome > 6) {
                    lcorners_home_first_time_home_ithome.add(corners_home_first_time_away_ithome + 1);
                }
                if (corners_home_first_time_away_itaway > 6) {
                    lcorners_home_first_time_home_itaway.add(corners_home_first_time_away_itaway + 1);
                }
            } else {
                if (corners_home_first_time_away_fora2 > 6) {
                    lcorners_home_first_time_home_fora.add(corners_home_first_time_away_fora2 + 1);
                }
                if (corners_home_first_time_total2 > 6) {
                    lcorners_home_first_time_home_total.add(corners_home_first_time_total2 + 1);
                }
                if (corners_home_first_time_away_ithome2 > 6) {
                    lcorners_home_first_time_home_ithome.add(corners_home_first_time_away_ithome2 + 1);
                }
                if (corners_home_first_time_away_itaway2 > 6) {
                    lcorners_home_first_time_home_itaway.add(corners_home_first_time_away_itaway2 + 1);
                }
            }
        }
    }
    private void yellowCardsCountMatches(int team, event evs, coefficient_table coeffs, ArrayList<match_table> lastMatchesTeamByLevel, ArrayList<Integer> lyellow_cards_home_first_time_home_fora, ArrayList<Integer> lyellow_cards_home_first_time_home_total, ArrayList<Integer> lyellow_cards_home_first_time_home_ithome, ArrayList<Integer> lyellow_cards_home_first_time_home_itaway) {
        Double value = coeffs.getOutcomeValue();
        int yellow_cards_home_first_time_home_fora = -1, yellow_cards_home_first_time_total = -1, yellow_cards_home_first_time_home_ithome = -1, yellow_cards_home_first_time_home_itaway = -1;
        int yellow_cards_home_first_time_away_fora = -1, yellow_cards_home_first_time_away_ithome = -1, yellow_cards_home_first_time_away_itaway = -1;
        int yellow_cards_home_first_time_home_fora2 = -1, yellow_cards_home_first_time_total2 = -1, yellow_cards_home_first_time_home_ithome2 = -1, yellow_cards_home_first_time_home_itaway2 = -1;
        int yellow_cards_home_first_time_away_fora2 = -1, yellow_cards_home_first_time_away_ithome2 = -1, yellow_cards_home_first_time_away_itaway2 = -1;
        for (match_table match : lastMatchesTeamByLevel) {
            if (evs.getGamePeriod() == 0) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getYellowCardFirstHalfGuest() + match.getYellowCardSecondHalfGuest() + value > match.getYellowCardFirstHalfHome() + match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getYellowCardFirstHalfHome() + match.getYellowCardSecondHalfHome() + value > match.getYellowCardFirstHalfGuest() + match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getYellowCardFirstHalfHome() + match.getYellowCardSecondHalfHome() - value > match.getYellowCardFirstHalfGuest() + match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getYellowCardFirstHalfGuest() + match.getYellowCardSecondHalfGuest() - value > match.getYellowCardFirstHalfHome() + match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getYellowCardFirstHalfHome() + match.getYellowCardSecondHalfHome() + match.getYellowCardFirstHalfGuest() + match.getYellowCardSecondHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            yellow_cards_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            yellow_cards_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getYellowCardFirstHalfHome() + match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getYellowCardFirstHalfGuest() + match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getYellowCardFirstHalfHome() + match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getYellowCardFirstHalfGuest() + match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getYellowCardFirstHalfGuest() + match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getYellowCardFirstHalfHome() + match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getYellowCardFirstHalfGuest() + match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getYellowCardFirstHalfHome() + match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            } else if (evs.getGamePeriod() == 1) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getYellowCardFirstHalfGuest() + value > match.getYellowCardFirstHalfHome()) {
                                yellow_cards_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getYellowCardFirstHalfHome() + value > match.getYellowCardFirstHalfGuest()) {
                                yellow_cards_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getYellowCardFirstHalfHome() - value > match.getYellowCardFirstHalfGuest()) {
                                yellow_cards_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getYellowCardFirstHalfGuest() - value > match.getYellowCardFirstHalfHome()) {
                                yellow_cards_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getYellowCardFirstHalfHome() + match.getYellowCardFirstHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            yellow_cards_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            yellow_cards_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getYellowCardFirstHalfHome()) {
                                yellow_cards_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getYellowCardFirstHalfGuest()) {
                                yellow_cards_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getYellowCardFirstHalfHome()) {
                                yellow_cards_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getYellowCardFirstHalfGuest()) {
                                yellow_cards_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getYellowCardFirstHalfGuest()) {
                                yellow_cards_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getYellowCardFirstHalfHome()) {
                                yellow_cards_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getYellowCardFirstHalfGuest()) {
                                yellow_cards_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getYellowCardFirstHalfHome()) {
                                yellow_cards_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            } else if (evs.getGamePeriod() == 2) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getYellowCardSecondHalfGuest() + value > match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getYellowCardSecondHalfHome() + value > match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getYellowCardSecondHalfHome() - value > match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getYellowCardSecondHalfGuest() - value > match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getYellowCardSecondHalfHome() + match.getYellowCardSecondHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            yellow_cards_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            yellow_cards_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getYellowCardSecondHalfGuest()) {
                                yellow_cards_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getYellowCardSecondHalfHome()) {
                                yellow_cards_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            }
        }
        if (team == 1) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (yellow_cards_home_first_time_home_fora != -1) {
                    lyellow_cards_home_first_time_home_fora.add(yellow_cards_home_first_time_home_fora + 1);
                }
                if (yellow_cards_home_first_time_total != -1) {
                    lyellow_cards_home_first_time_home_total.add(yellow_cards_home_first_time_total + 1);
                }
                if (yellow_cards_home_first_time_home_ithome != -1) {
                    lyellow_cards_home_first_time_home_ithome.add(yellow_cards_home_first_time_home_ithome + 1);
                }
                if (yellow_cards_home_first_time_home_itaway != -1) {
                    lyellow_cards_home_first_time_home_itaway.add(yellow_cards_home_first_time_home_itaway + 1);
                }
            } else {
                if (yellow_cards_home_first_time_home_fora2 != -1) {
                    lyellow_cards_home_first_time_home_fora.add(yellow_cards_home_first_time_home_fora2 + 1);
                }
                if (yellow_cards_home_first_time_total2 != -1) {
                    lyellow_cards_home_first_time_home_total.add(yellow_cards_home_first_time_total2 + 1);
                }
                if (yellow_cards_home_first_time_home_ithome2 != -1) {
                    lyellow_cards_home_first_time_home_ithome.add(yellow_cards_home_first_time_home_ithome2 + 1);
                }
                if (yellow_cards_home_first_time_home_itaway2 != -1) {
                    lyellow_cards_home_first_time_home_itaway.add(yellow_cards_home_first_time_home_itaway2 + 1);
                }
            }
        } else if (team == 2) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (yellow_cards_home_first_time_away_fora != -1) {
                    lyellow_cards_home_first_time_home_fora.add(yellow_cards_home_first_time_away_fora + 1);
                }
                if (yellow_cards_home_first_time_total != -1) {
                    lyellow_cards_home_first_time_home_total.add(yellow_cards_home_first_time_total + 1);
                }
                if (yellow_cards_home_first_time_away_ithome != -1) {
                    lyellow_cards_home_first_time_home_ithome.add(yellow_cards_home_first_time_away_ithome + 1);
                }
                if (yellow_cards_home_first_time_away_itaway != -1) {
                    lyellow_cards_home_first_time_home_itaway.add(yellow_cards_home_first_time_away_itaway + 1);
                }
            } else {
                if (yellow_cards_home_first_time_away_fora2 != -1) {
                    lyellow_cards_home_first_time_home_fora.add(yellow_cards_home_first_time_away_fora2 + 1);
                }
                if (yellow_cards_home_first_time_total2 != -1) {
                    lyellow_cards_home_first_time_home_total.add(yellow_cards_home_first_time_total2 + 1);
                }
                if (yellow_cards_home_first_time_away_ithome2 != -1) {
                    lyellow_cards_home_first_time_home_ithome.add(yellow_cards_home_first_time_away_ithome2 + 1);
                }
                if (yellow_cards_home_first_time_away_itaway2 != -1) {
                    lyellow_cards_home_first_time_home_itaway.add(yellow_cards_home_first_time_away_itaway2 + 1);
                }
            }
        }
    }
    private void shotsOnTargetCountMatches(int team, event evs, coefficient_table coeffs, ArrayList<match_table> lastMatchesTeamByLevel, ArrayList<Integer> lshots_on_target_home_first_time_home_fora, ArrayList<Integer> lshots_on_target_home_first_time_home_total, ArrayList<Integer> lshots_on_target_home_first_time_home_ithome, ArrayList<Integer> lshots_on_target_home_first_time_home_itaway) {
        Double value = coeffs.getOutcomeValue();
        int shots_on_target_home_first_time_home_fora = -1, shots_on_target_home_first_time_total = -1, shots_on_target_home_first_time_home_ithome = -1, shots_on_target_home_first_time_home_itaway = -1;
        int shots_on_target_home_first_time_away_fora = -1, shots_on_target_home_first_time_away_ithome = -1, shots_on_target_home_first_time_away_itaway = -1;
        int shots_on_target_home_first_time_home_fora2 = -1, shots_on_target_home_first_time_total2 = -1, shots_on_target_home_first_time_home_ithome2 = -1, shots_on_target_home_first_time_home_itaway2 = -1;
        int shots_on_target_home_first_time_away_fora2 = -1, shots_on_target_home_first_time_away_ithome2 = -1, shots_on_target_home_first_time_away_itaway2 = -1;
        for (match_table match : lastMatchesTeamByLevel) {
            if (evs.getGamePeriod() == 0) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getShotOnTargetFirstHalfGuest() + match.getShotOnTargetSecondHalfGuest() + value > match.getShotOnTargetFirstHalfHome() + match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getShotOnTargetFirstHalfHome() + match.getShotOnTargetSecondHalfHome() + value > match.getShotOnTargetFirstHalfGuest() + match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getShotOnTargetFirstHalfHome() + match.getShotOnTargetSecondHalfHome() - value > match.getShotOnTargetFirstHalfGuest() + match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getShotOnTargetFirstHalfGuest() + match.getShotOnTargetSecondHalfGuest() - value > match.getShotOnTargetFirstHalfHome() + match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getShotOnTargetFirstHalfHome() + match.getShotOnTargetSecondHalfHome() + match.getShotOnTargetFirstHalfGuest() + match.getShotOnTargetSecondHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            shots_on_target_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            shots_on_target_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getShotOnTargetFirstHalfHome() + match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getShotOnTargetFirstHalfGuest() + match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getShotOnTargetFirstHalfHome() + match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getShotOnTargetFirstHalfGuest() + match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getShotOnTargetFirstHalfGuest() + match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getShotOnTargetFirstHalfHome() + match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getShotOnTargetFirstHalfGuest() + match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getShotOnTargetFirstHalfHome() + match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            } else if (evs.getGamePeriod() == 1) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getShotOnTargetFirstHalfGuest() + value > match.getShotOnTargetFirstHalfHome()) {
                                shots_on_target_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getShotOnTargetFirstHalfHome() + value > match.getShotOnTargetFirstHalfGuest()) {
                                shots_on_target_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getShotOnTargetFirstHalfHome() - value > match.getShotOnTargetFirstHalfGuest()) {
                                shots_on_target_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getShotOnTargetFirstHalfGuest() - value > match.getShotOnTargetFirstHalfHome()) {
                                shots_on_target_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getShotOnTargetFirstHalfHome() + match.getShotOnTargetFirstHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            shots_on_target_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            shots_on_target_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getShotOnTargetFirstHalfHome()) {
                                shots_on_target_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getShotOnTargetFirstHalfGuest()) {
                                shots_on_target_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getShotOnTargetFirstHalfHome()) {
                                shots_on_target_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getShotOnTargetFirstHalfGuest()) {
                                shots_on_target_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getShotOnTargetFirstHalfGuest()) {
                                shots_on_target_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getShotOnTargetFirstHalfHome()) {
                                shots_on_target_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getShotOnTargetFirstHalfGuest()) {
                                shots_on_target_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getShotOnTargetFirstHalfHome()) {
                                shots_on_target_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            } else if (evs.getGamePeriod() == 2) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getShotOnTargetSecondHalfGuest() + value > match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getShotOnTargetSecondHalfHome() + value > match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getShotOnTargetSecondHalfHome() - value > match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getShotOnTargetSecondHalfGuest() - value > match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getShotOnTargetSecondHalfHome() + match.getShotOnTargetSecondHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            shots_on_target_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            shots_on_target_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getShotOnTargetSecondHalfGuest()) {
                                shots_on_target_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getShotOnTargetSecondHalfHome()) {
                                shots_on_target_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            }
        }
        if (team == 1) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (shots_on_target_home_first_time_home_fora != -1) {
                    lshots_on_target_home_first_time_home_fora.add(shots_on_target_home_first_time_home_fora + 1);
                }
                if (shots_on_target_home_first_time_total != -1) {
                    lshots_on_target_home_first_time_home_total.add(shots_on_target_home_first_time_total + 1);
                }
                if (shots_on_target_home_first_time_home_ithome != -1) {
                    lshots_on_target_home_first_time_home_ithome.add(shots_on_target_home_first_time_home_ithome + 1);
                }
                if (shots_on_target_home_first_time_home_itaway != -1) {
                    lshots_on_target_home_first_time_home_itaway.add(shots_on_target_home_first_time_home_itaway + 1);
                }
            } else {
                if (shots_on_target_home_first_time_home_fora2 != -1) {
                    lshots_on_target_home_first_time_home_fora.add(shots_on_target_home_first_time_home_fora2 + 1);
                }
                if (shots_on_target_home_first_time_total2 != -1) {
                    lshots_on_target_home_first_time_home_total.add(shots_on_target_home_first_time_total2 + 1);
                }
                if (shots_on_target_home_first_time_home_ithome2 != -1) {
                    lshots_on_target_home_first_time_home_ithome.add(shots_on_target_home_first_time_home_ithome2 + 1);
                }
                if (shots_on_target_home_first_time_home_itaway2 != -1) {
                    lshots_on_target_home_first_time_home_itaway.add(shots_on_target_home_first_time_home_itaway2 + 1);
                }
            }
        } else if (team == 2) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (shots_on_target_home_first_time_away_fora != -1) {
                    lshots_on_target_home_first_time_home_fora.add(shots_on_target_home_first_time_away_fora + 1);
                }
                if (shots_on_target_home_first_time_total != -1) {
                    lshots_on_target_home_first_time_home_total.add(shots_on_target_home_first_time_total + 1);
                }
                if (shots_on_target_home_first_time_away_ithome != -1) {
                    lshots_on_target_home_first_time_home_ithome.add(shots_on_target_home_first_time_away_ithome + 1);
                }
                if (shots_on_target_home_first_time_away_itaway != -1) {
                    lshots_on_target_home_first_time_home_itaway.add(shots_on_target_home_first_time_away_itaway + 1);
                }
            } else {
                if (shots_on_target_home_first_time_away_fora2 != -1) {
                    lshots_on_target_home_first_time_home_fora.add(shots_on_target_home_first_time_away_fora2 + 1);
                }
                if (shots_on_target_home_first_time_total2 != -1) {
                    lshots_on_target_home_first_time_home_total.add(shots_on_target_home_first_time_total2 + 1);
                }
                if (shots_on_target_home_first_time_away_ithome2 != -1) {
                    lshots_on_target_home_first_time_home_ithome.add(shots_on_target_home_first_time_away_ithome2 + 1);
                }
                if (shots_on_target_home_first_time_away_itaway2 != -1) {
                    lshots_on_target_home_first_time_home_itaway.add(shots_on_target_home_first_time_away_itaway2 + 1);
                }
            }
        }
    }
    private void offsidesCountMatches(int team, event evs, coefficient_table coeffs, ArrayList<match_table> lastMatchesTeamByLevel, ArrayList<Integer> loffsides_home_first_time_home_fora, ArrayList<Integer> loffsides_home_first_time_home_total, ArrayList<Integer> loffsides_home_first_time_home_ithome, ArrayList<Integer> loffsides_home_first_time_home_itaway) {
        Double value = coeffs.getOutcomeValue();
        int offsides_home_first_time_home_fora = -1, offsides_home_first_time_total = -1, offsides_home_first_time_home_ithome = -1, offsides_home_first_time_home_itaway = -1;
        int offsides_home_first_time_away_fora = -1, offsides_home_first_time_away_ithome = -1, offsides_home_first_time_away_itaway = -1;
        int offsides_home_first_time_home_fora2 = -1, offsides_home_first_time_total2 = -1, offsides_home_first_time_home_ithome2 = -1, offsides_home_first_time_home_itaway2 = -1;
        int offsides_home_first_time_away_fora2 = -1, offsides_home_first_time_away_ithome2 = -1, offsides_home_first_time_away_itaway2 = -1;
        for (match_table match : lastMatchesTeamByLevel) {
            if (evs.getGamePeriod() == 0) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getOffsideFirstHalfGuest() + match.getOffsideSecondHalfGuest() + value > match.getOffsideFirstHalfHome() + match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getOffsideFirstHalfHome() + match.getOffsideSecondHalfHome() + value > match.getOffsideFirstHalfGuest() + match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getOffsideFirstHalfHome() + match.getOffsideSecondHalfHome() - value > match.getOffsideFirstHalfGuest() + match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getOffsideFirstHalfGuest() + match.getOffsideSecondHalfGuest() - value > match.getOffsideFirstHalfHome() + match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getOffsideFirstHalfHome() + match.getOffsideSecondHalfHome() + match.getOffsideFirstHalfGuest() + match.getOffsideSecondHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            offsides_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            offsides_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getOffsideFirstHalfHome() + match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getOffsideFirstHalfGuest() + match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getOffsideFirstHalfHome() + match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getOffsideFirstHalfGuest() + match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getOffsideFirstHalfGuest() + match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getOffsideFirstHalfHome() + match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getOffsideFirstHalfGuest() + match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getOffsideFirstHalfHome() + match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            } else if (evs.getGamePeriod() == 1) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getOffsideFirstHalfGuest() + value > match.getOffsideFirstHalfHome()) {
                                offsides_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getOffsideFirstHalfHome() + value > match.getOffsideFirstHalfGuest()) {
                                offsides_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getOffsideFirstHalfHome() - value > match.getOffsideFirstHalfGuest()) {
                                offsides_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getOffsideFirstHalfGuest() - value > match.getOffsideFirstHalfHome()) {
                                offsides_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getOffsideFirstHalfHome() + match.getOffsideFirstHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            offsides_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            offsides_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getOffsideFirstHalfHome()) {
                                offsides_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getOffsideFirstHalfGuest()) {
                                offsides_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getOffsideFirstHalfHome()) {
                                offsides_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getOffsideFirstHalfGuest()) {
                                offsides_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getOffsideFirstHalfGuest()) {
                                offsides_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getOffsideFirstHalfHome()) {
                                offsides_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getOffsideFirstHalfGuest()) {
                                offsides_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getOffsideFirstHalfHome()) {
                                offsides_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            } else if (evs.getGamePeriod() == 2) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getOffsideSecondHalfGuest() + value > match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getOffsideSecondHalfHome() + value > match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getOffsideSecondHalfHome() - value > match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getOffsideSecondHalfGuest() - value > match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getOffsideSecondHalfHome() + match.getOffsideSecondHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            offsides_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            offsides_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getOffsideSecondHalfGuest()) {
                                offsides_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getOffsideSecondHalfHome()) {
                                offsides_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            }
        }
        if (team == 1) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (offsides_home_first_time_home_fora != -1) {
                    loffsides_home_first_time_home_fora.add(offsides_home_first_time_home_fora + 1);
                }
                if (offsides_home_first_time_total != -1) {
                    loffsides_home_first_time_home_total.add(offsides_home_first_time_total + 1);
                }
                if (offsides_home_first_time_home_ithome != -1) {
                    loffsides_home_first_time_home_ithome.add(offsides_home_first_time_home_ithome + 1);
                }
                if (offsides_home_first_time_home_itaway != -1) {
                    loffsides_home_first_time_home_itaway.add(offsides_home_first_time_home_itaway + 1);
                }
            } else {
                if (offsides_home_first_time_home_fora2 != -1) {
                    loffsides_home_first_time_home_fora.add(offsides_home_first_time_home_fora2 + 1);
                }
                if (offsides_home_first_time_total2 != -1) {
                    loffsides_home_first_time_home_total.add(offsides_home_first_time_total2 + 1);
                }
                if (offsides_home_first_time_home_ithome2 != -1) {
                    loffsides_home_first_time_home_ithome.add(offsides_home_first_time_home_ithome2 + 1);
                }
                if (offsides_home_first_time_home_itaway2 != -1) {
                    loffsides_home_first_time_home_itaway.add(offsides_home_first_time_home_itaway2 + 1);
                }
            }
        } else if (team == 2) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (offsides_home_first_time_away_fora != -1) {
                    loffsides_home_first_time_home_fora.add(offsides_home_first_time_away_fora + 1);
                }
                if (offsides_home_first_time_total != -1) {
                    loffsides_home_first_time_home_total.add(offsides_home_first_time_total + 1);
                }
                if (offsides_home_first_time_away_ithome != -1) {
                    loffsides_home_first_time_home_ithome.add(offsides_home_first_time_away_ithome + 1);
                }
                if (offsides_home_first_time_away_itaway != -1) {
                    loffsides_home_first_time_home_itaway.add(offsides_home_first_time_away_itaway + 1);
                }
            } else {
                if (offsides_home_first_time_away_fora2 != -1) {
                    loffsides_home_first_time_home_fora.add(offsides_home_first_time_away_fora2 + 1);
                }
                if (offsides_home_first_time_total2 != -1) {
                    loffsides_home_first_time_home_total.add(offsides_home_first_time_total2 + 1);
                }
                if (offsides_home_first_time_away_ithome2 != -1) {
                    loffsides_home_first_time_home_ithome.add(offsides_home_first_time_away_ithome2 + 1);
                }
                if (offsides_home_first_time_away_itaway2 != -1) {
                    loffsides_home_first_time_home_itaway.add(offsides_home_first_time_away_itaway2 + 1);
                }
            }
        }
    }
    private void foulsCountMatches(int team, event evs, coefficient_table coeffs, ArrayList<match_table> lastMatchesTeamByLevel, ArrayList<Integer> lfouls_home_first_time_home_fora, ArrayList<Integer> lfouls_home_first_time_home_total, ArrayList<Integer> lfouls_home_first_time_home_ithome, ArrayList<Integer> lfouls_home_first_time_home_itaway) {
        Double value = coeffs.getOutcomeValue();
        int fouls_home_first_time_home_fora = -1, fouls_home_first_time_total = -1, fouls_home_first_time_home_ithome = -1, fouls_home_first_time_home_itaway = -1;
        int fouls_home_first_time_away_fora = -1, fouls_home_first_time_away_ithome = -1, fouls_home_first_time_away_itaway = -1;
        int fouls_home_first_time_home_fora2 = -1, fouls_home_first_time_total2 = -1, fouls_home_first_time_home_ithome2 = -1, fouls_home_first_time_home_itaway2 = -1;
        int fouls_home_first_time_away_fora2 = -1, fouls_home_first_time_away_ithome2 = -1, fouls_home_first_time_away_itaway2 = -1;
        for (match_table match : lastMatchesTeamByLevel) {
            if (evs.getGamePeriod() == 0) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getFoulFirstHalfGuest() + match.getFoulSecondHalfGuest() + value > match.getFoulFirstHalfHome() + match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getFoulFirstHalfHome() + match.getFoulSecondHalfHome() + value > match.getFoulFirstHalfGuest() + match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getFoulFirstHalfHome() + match.getFoulSecondHalfHome() - value > match.getFoulFirstHalfGuest() + match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getFoulFirstHalfGuest() + match.getFoulSecondHalfGuest() - value > match.getFoulFirstHalfHome() + match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getFoulFirstHalfHome() + match.getFoulSecondHalfHome() + match.getFoulFirstHalfGuest() + match.getFoulSecondHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            fouls_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            fouls_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getFoulFirstHalfHome() + match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getFoulFirstHalfGuest() + match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getFoulFirstHalfHome() + match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getFoulFirstHalfGuest() + match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getFoulFirstHalfGuest() + match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getFoulFirstHalfHome() + match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getFoulFirstHalfGuest() + match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getFoulFirstHalfHome() + match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            } else if (evs.getGamePeriod() == 1) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getFoulFirstHalfGuest() + value > match.getFoulFirstHalfHome()) {
                                fouls_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getFoulFirstHalfHome() + value > match.getFoulFirstHalfGuest()) {
                                fouls_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getFoulFirstHalfHome() - value > match.getFoulFirstHalfGuest()) {
                                fouls_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getFoulFirstHalfGuest() - value > match.getFoulFirstHalfHome()) {
                                fouls_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getFoulFirstHalfHome() + match.getFoulFirstHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            fouls_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            fouls_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getFoulFirstHalfHome()) {
                                fouls_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getFoulFirstHalfGuest()) {
                                fouls_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getFoulFirstHalfHome()) {
                                fouls_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getFoulFirstHalfGuest()) {
                                fouls_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getFoulFirstHalfGuest()) {
                                fouls_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value > match.getFoulFirstHalfHome()) {
                                fouls_home_first_time_away_itaway2++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getFoulFirstHalfGuest()) {
                                fouls_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getFoulFirstHalfHome()) {
                                fouls_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            } else if (evs.getGamePeriod() == 2) {
                if (evs.getOccasion() == 3) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (match.getFoulSecondHalfGuest() + value > match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_home_fora++;
                            }
                        } else if (team == 2) {
                            if (match.getFoulSecondHalfHome() + value > match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_away_fora++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (match.getFoulSecondHalfHome() - value > match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_home_fora2++;
                            }
                        } else if (team == 2) {
                            if (match.getFoulSecondHalfGuest() - value > match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_away_fora2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 4) {
                    int sum = match.getFoulSecondHalfHome() + match.getFoulSecondHalfGuest();
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (value > sum) {
                            fouls_home_first_time_total++;
                        }
                    } else {
                        if (value < sum) {
                            fouls_home_first_time_total2++;
                        }
                    }
                } else if (evs.getOccasion() == 5) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_home_ithome++;
                            }
                        } else if (team == 2) {
                            if (value > match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_away_ithome++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_home_ithome2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_away_ithome2++;
                            }
                        }
                    }
                } else if (evs.getOccasion() == 6) {
                    if (coeffs.getIdCoefficient() % 2 == 0) {
                        if (team == 1) {
                            if (value > match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_home_itaway++;
                            }
                        } else if (team == 2) {
                            if (value > match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_away_itaway++;
                            }
                        }
                    } else {
                        if (team == 1) {
                            if (value < match.getFoulSecondHalfGuest()) {
                                fouls_home_first_time_home_itaway2++;
                            }
                        } else if (team == 2) {
                            if (value < match.getFoulSecondHalfHome()) {
                                fouls_home_first_time_away_itaway2++;
                            }
                        }
                    }
                }
            }
        }
        if (team == 1) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (fouls_home_first_time_home_fora != -1) {
                    lfouls_home_first_time_home_fora.add(fouls_home_first_time_home_fora + 1);
                }
                if (fouls_home_first_time_total != -1) {
                    lfouls_home_first_time_home_total.add(fouls_home_first_time_total + 1);
                }
                if (fouls_home_first_time_home_ithome != -1) {
                    lfouls_home_first_time_home_ithome.add(fouls_home_first_time_home_ithome + 1);
                }
                if (fouls_home_first_time_home_itaway != -1) {
                    lfouls_home_first_time_home_itaway.add(fouls_home_first_time_home_itaway + 1);
                }
            } else {
                if (fouls_home_first_time_home_fora2 != -1) {
                    lfouls_home_first_time_home_fora.add(fouls_home_first_time_home_fora2 + 1);
                }
                if (fouls_home_first_time_total2 != -1) {
                    lfouls_home_first_time_home_total.add(fouls_home_first_time_total2 + 1);
                }
                if (fouls_home_first_time_home_ithome2 != -1) {
                    lfouls_home_first_time_home_ithome.add(fouls_home_first_time_home_ithome2 + 1);
                }
                if (fouls_home_first_time_home_itaway2 != -1) {
                    lfouls_home_first_time_home_itaway.add(fouls_home_first_time_home_itaway2 + 1);
                }
            }
        } else if (team == 2) {
            if (coeffs.getIdCoefficient() % 2 == 0) {
                if (fouls_home_first_time_away_fora != -1) {
                    lfouls_home_first_time_home_fora.add(fouls_home_first_time_away_fora + 1);
                }
                if (fouls_home_first_time_total != -1) {
                    lfouls_home_first_time_home_total.add(fouls_home_first_time_total + 1);
                }
                if (fouls_home_first_time_away_ithome != -1) {
                    lfouls_home_first_time_home_ithome.add(fouls_home_first_time_away_ithome + 1);
                }
                if (fouls_home_first_time_away_itaway != -1) {
                    lfouls_home_first_time_home_itaway.add(fouls_home_first_time_away_itaway + 1);
                }
            } else {
                if (fouls_home_first_time_away_fora2 != -1) {
                    lfouls_home_first_time_home_fora.add(fouls_home_first_time_away_fora2 + 1);
                }
                if (fouls_home_first_time_total2 != -1) {
                    lfouls_home_first_time_home_total.add(fouls_home_first_time_total2 + 1);
                }
                if (fouls_home_first_time_away_ithome2 != -1) {
                    lfouls_home_first_time_home_ithome.add(fouls_home_first_time_away_ithome2 + 1);
                }
                if (fouls_home_first_time_away_itaway2 != -1) {
                    lfouls_home_first_time_home_itaway.add(fouls_home_first_time_away_itaway2 + 1);
                }
            }
        }
    }
}
