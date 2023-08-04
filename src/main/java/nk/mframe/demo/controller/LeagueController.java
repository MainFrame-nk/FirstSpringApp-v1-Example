package nk.mframe.demo.controller;

import nk.mframe.demo.dao.CountryRepository;
import nk.mframe.demo.model.country;
import nk.mframe.demo.model.league;
import nk.mframe.demo.dao.LeagueRepository;
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
public class LeagueController {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/league")
    public String leagueMain(Model model) {
        Iterable<league> league = leagueRepository.findAll();
        model.addAttribute("league", league);

        ArrayList<country> ct = new ArrayList<>();
        for (league ls : league) {
            Optional<country> country = countryRepository.findById(ls.getCountryLeague());

            country.ifPresent(ct::add);
            model.addAttribute("country", ct);
        }
        return "league-index";
    }

    @GetMapping("/league/add")
    public String leagueAdd(Model model) {
        Iterable<country> country = countryRepository.findAll();
        model.addAttribute("country", country);
        return "league-add";
    }

    @PostMapping("/league/add")
    public String leagueAdd(@RequestParam String name_league, @RequestParam Integer country_league, Model model) {
        league league = new league(name_league, country_league);
        leagueRepository.save(league);
        return "redirect:/league";
    }

    @GetMapping("/league/{id}")
    public String leagueDetails(@PathVariable(value = "id") int idLeague, Model model) {
        if(!leagueRepository.existsById(idLeague)) {
            return "redirect:/league";
        }

        Optional<league> league = leagueRepository.findById(idLeague);
        ArrayList<league> res = new ArrayList<>();
        league.ifPresent(res::add);
        model.addAttribute("league", res);

        Optional<country> country = countryRepository.findById(league.get().getCountryLeague());
        ArrayList<country> ct = new ArrayList<>();
        country.ifPresent(ct::add);
        model.addAttribute("country", ct);
        return "league-details";
    }

    @GetMapping("/league/{id}/edit")
    public String leagueEdit(@PathVariable(value = "id") int idLeague, Model model) {
        if(!leagueRepository.existsById(idLeague)) {
            return "redirect:/league";
        }

        Optional<league> league = leagueRepository.findById(idLeague);
        ArrayList<league> res = new ArrayList<>();
        league.ifPresent(res::add);
        model.addAttribute("league", res);

        Iterable<country> country = countryRepository.findAll();
        model.addAttribute("country", country);
        return "league-edit";
    }

    @PostMapping("/league/{id}/edit")
    public String leagueUpdate(@PathVariable(value = "id") int idLeague, @RequestParam String name_league, @RequestParam Integer country_league, Model model) {
        league league = leagueRepository.findById(idLeague).orElseThrow(RuntimeException::new);
        league.setNameLeague(name_league);
        league.setCountryLeague(country_league);
        leagueRepository.save(league);
        return "redirect:/league";
    }

    @PostMapping("/league/{id}/delete")
    public String leagueDelete(@PathVariable(value = "id") int idLeague, Model model) {
        league league = leagueRepository.findById(idLeague).orElseThrow(RuntimeException::new);
        leagueRepository.delete(league);
        return "redirect:/league";
    }
}
