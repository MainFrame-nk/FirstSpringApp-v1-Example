package nk.mframe.demo.controller;

import nk.mframe.demo.dao.LeagueRepository;
import nk.mframe.demo.dao.MatchRepository;
import nk.mframe.demo.model.league;
import nk.mframe.demo.model.match_table;
import nk.mframe.demo.model.team;
import nk.mframe.demo.dao.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private MatchRepository matchRepository;
    @GetMapping("/team")
    public String teamMain(Model model) {
        Iterable<team> teams = teamRepository.findAll();
        model.addAttribute("team", teams);

        ArrayList<league> lg = new ArrayList<>();
        for (team tm : teams) {
            Optional<league> league = leagueRepository.findById(tm.getLeagueTeam());

            league.ifPresent(lg::add);
            model.addAttribute("league_team", lg);
        }
        return "team-index";
    }

    @GetMapping("/team/add")
    public String teamAdd(Model model) {
        Iterable<league> league = leagueRepository.findAll();
        model.addAttribute("league", league);
        return "team-add";
    }

    @PostMapping("/team/add")
    public String teamAdd(@RequestParam String name_team, @RequestParam Integer league_team, @RequestParam Byte level_team, Model model) {
        team team = new team(name_team, league_team, level_team);
        teamRepository.save(team);
        return "redirect:/team";
    }

    @GetMapping("/team/{id}")
    public String teamDetails(@PathVariable(value = "id") int idTeam, Model model) {
        if(!teamRepository.existsById(idTeam)) {
            return "redirect:/team";
        }

        Optional<team> team = teamRepository.findById(idTeam);
        ArrayList<team> res = new ArrayList<>();
        team.ifPresent(res::add);
        model.addAttribute("team", res);
        return "team-details";
    }

    @GetMapping("/team/{id}/matches")
    public String teamMatchDetails(@PathVariable(value = "id") int idTeam, Model model) {
        if(!teamRepository.existsById(idTeam)) {
            return "redirect:/team";
        }
        Iterable<match_table> matches = matchRepository.findAll();

        ArrayList<team> th = new ArrayList<>();
        ArrayList<team> tg = new ArrayList<>();
        ArrayList<match_table> m = new ArrayList<>();
        for (match_table mt : matches) {
            if (mt.getTeamHome() == idTeam || mt.getTeamGuest() == idTeam) {
                Optional<match_table> mtm = matchRepository.findById(mt.getIdMatch());
                Optional<team> team_home = teamRepository.findById(mt.getTeamHome());
                Optional<team> team_guest = teamRepository.findById(mt.getTeamGuest());

                mtm.ifPresent(m::add);
                model.addAttribute("matches", m);

                team_home.ifPresent(th::add);
                team_guest.ifPresent(tg::add);
                model.addAttribute("team_home", th);
                model.addAttribute("team_guest", tg);
            }
        }
        return "team-calendar";
    }

    @GetMapping("/team/{id}/edit")
    public String teamEdit(@PathVariable(value = "id") int idTeam, Model model) {
        if(!teamRepository.existsById(idTeam)) {
            return "redirect:/team";
        }

        Optional<team> team = teamRepository.findById(idTeam);
        Iterable<league> league = leagueRepository.findAll();
        ArrayList<team> res = new ArrayList<>();
        team.ifPresent(res::add);
        model.addAttribute("team", res);
        model.addAttribute("league", league);
        return "team-edit";
    }

    @PostMapping("/team/{id}/edit")
    public String teamUpdate(@PathVariable(value = "id") int idTeam, @RequestParam String name_team, @RequestParam Integer team_league, @RequestParam Byte level_team, Model model) {
        team team = teamRepository.findById(idTeam).orElseThrow(RuntimeException::new);
        team.setNameTeam(name_team);
        team.setLeagueTeam(team_league);
        team.setLevelTeam(level_team);
        teamRepository.save(team);
        return "redirect:/team";
    }

    @PostMapping("/team/{id}/delete")
    public String teamDelete(@PathVariable(value = "id") int idTeam, Model model) {
        team team = teamRepository.findById(idTeam).orElseThrow(RuntimeException::new);
        teamRepository.delete(team);
        return "redirect:/team";
    }
}
