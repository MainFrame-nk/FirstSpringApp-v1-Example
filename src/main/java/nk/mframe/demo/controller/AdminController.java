package nk.mframe.demo.controller;

import nk.mframe.demo.dao.LeagueRepository;
import nk.mframe.demo.dao.SeasonRepository;
import nk.mframe.demo.dao.TeamRepository;
import nk.mframe.demo.model.league;
import nk.mframe.demo.model.team;
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
public class AdminController {

    @Autowired
    private LeagueRepository leagueRepository;

    @GetMapping("/admin")
    public String adminMain(Model model) {
        Iterable<league> league = leagueRepository.findAll();
        model.addAttribute("league", league);
        return "admin-index";
    }
}
