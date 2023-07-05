package com.example.demo.controllers;

import com.example.demo.models.team;
import com.example.demo.dao.TeamRepository;
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

    @GetMapping("/team")
    public String teamMain(Model model) {
        Iterable<team> team = teamRepository.findAll();
        model.addAttribute("team", team);
        return "team-index";
    }

    @GetMapping("/team/add")
    public String teamAdd(Model model) {
        return "team-add";
    }

    @PostMapping("/team/add")
    public String teamAdd(@RequestParam String name_team, @RequestParam Byte level_team, Model model) {
        team team = new team(name_team, level_team);
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

    @GetMapping("/team/{id}/edit")
    public String teamEdit(@PathVariable(value = "id") int idTeam, Model model) {
        if(!teamRepository.existsById(idTeam)) {
            return "redirect:/team";
        }

        Optional<team> team = teamRepository.findById(idTeam);
        ArrayList<team> res = new ArrayList<>();
        team.ifPresent(res::add);
        model.addAttribute("team", res);
        return "team-edit";
    }

    @PostMapping("/team/{id}/edit")
    public String teamUpdate(@PathVariable(value = "id") int idTeam, @RequestParam String name_team, @RequestParam Byte level_team, Model model) {
        team team = teamRepository.findById(idTeam).orElseThrow(RuntimeException::new);
        team.setNameTeam(name_team);
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
