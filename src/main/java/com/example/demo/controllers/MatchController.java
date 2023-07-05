package com.example.demo.controllers;

import com.example.demo.models.match_table;
import com.example.demo.models.team;
import com.example.demo.dao.MatchRepository;
import com.example.demo.dao.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        model.addAttribute("match", matches);

        Iterable<team> team = teamRepository.findAll();
        model.addAttribute("team", team);
        return "match-index";
    }

    @GetMapping("/match/add")
    public String matchAdd(Model model) {
        Iterable<team> team = teamRepository.findAll();
        model.addAttribute("team", team);
        return "match-add";
    }
    @PostMapping("/match/add")
    public String matchPostAdd(@RequestParam int team_home, @RequestParam int team_guest, Model model) {
        match_table matches = new match_table(team_home, team_guest, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0,
                -1, 0, 0, -1, 0, 0, -1, 0, 0, -1,
                0, 0, 0, 0, 0, -1, 0, 0, -1, 0,
                0, -1, 0, 0, -1, 0, 0, -1, 0, 0,
                -1, 0, 0, -1, 0, 0, -1, 0, 0, -1,
                0, 0, -1, 0, 0, -1);
        matchRepository.save(matches);
        return "redirect:/match";
    }

    @GetMapping("/match/{id}/0")
    public String matchDetailsMatch(@PathVariable(value = "id") long idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        //matches match1 = matchRepository.findById(idMatch).orElse(null);
        Optional<match_table> match = matchRepository.findById(idMatch);
        //Optional<statmatch> statmatch = statMatchRepository.findById(match.get().getId());
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);
        return "match-details-0";
    }

    @GetMapping("/match/{id}/1")
    public String matchDetailsFirst(@PathVariable(value = "id") long idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        //matches match1 = matchRepository.findById(idMatch).orElse(null);
        Optional<match_table> match = matchRepository.findById(idMatch);
        //Optional<statmatch> statmatch = statMatchRepository.findById(match.get().getId());
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);
        return "match-details-1";
    }

    @GetMapping("/match/{id}/2")
    public String matchDetailsSecond(@PathVariable(value = "id") long idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        //matches match1 = matchRepository.findById(idMatch).orElse(null);
        Optional<match_table> match = matchRepository.findById(idMatch);
        //Optional<statmatch> statmatch = statMatchRepository.findById(match.get().getId());
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);
        return "match-details-2";
    }

    @GetMapping("/match/{id}/3")
    public String matchDetailsExtra(@PathVariable(value = "id") long idMatch, Model model) {
        if(!matchRepository.existsById(idMatch)) {
            return "redirect:/match";
        }

        //matches match1 = matchRepository.findById(idMatch).orElse(null);
        Optional<match_table> match = matchRepository.findById(idMatch);
        //Optional<statmatch> statmatch = statMatchRepository.findById(match.get().getId());
        ArrayList<match_table> res = new ArrayList<>();
        match.ifPresent(res::add);
        model.addAttribute("match", res);
        return "match-details-3";
    }

    @GetMapping("/match/{id}/edit/0")
    public String matchEditMatch(@PathVariable(value = "id") long idMatch, Model model) {
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
    public String matchEditFirst(@PathVariable(value = "id") long idMatch, Model model) {
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
    public String matchEditSecond(@PathVariable(value = "id") long idMatch, Model model) {
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
    public String matchEditExtra(@PathVariable(value = "id") long idMatch, Model model) {
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
    public String matchUpdateMatch(@PathVariable(value = "id") long idMatch, @RequestParam int team_home, @RequestParam int team_guest,
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
    public String matchUpdateFirst(@PathVariable(value = "id") long idMatch,
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
    public String matchUpdateSecond(@PathVariable(value = "id") long idMatch,
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
    public String matchUpdateExtra(@PathVariable(value = "id") long idMatch,
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
    public String matchDelete(@PathVariable(value = "id") long idMatch, Model model) {
        match_table match = matchRepository.findById(idMatch).orElseThrow(RuntimeException::new);
        matchRepository.delete(match);
        return "redirect:/match";
    }

}
