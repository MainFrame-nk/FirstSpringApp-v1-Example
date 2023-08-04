package nk.mframe.demo.controller;

import nk.mframe.demo.dao.CountryRepository;
import nk.mframe.demo.dao.LeagueRepository;
import nk.mframe.demo.model.country;
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
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/country")
    public String countryMain(Model model) {
        Iterable<country> country = countryRepository.findAll();
        model.addAttribute("country", country);
        return "country-index";
    }

    @GetMapping("/country/add")
    public String countryAdd(Model model) {
        return "country-add";
    }

    @PostMapping("/country/add")
    public String countryAdd(@RequestParam String name_country, Model model) {
        country country = new country(name_country);
        countryRepository.save(country);
        return "redirect:/country";
    }

    @GetMapping("/country/{id}")
    public String countryDetails(@PathVariable(value = "id") int idCountry, Model model) {
        if(!countryRepository.existsById(idCountry)) {
            return "redirect:/country";
        }

        Optional<country> country = countryRepository.findById(idCountry);
        ArrayList<country> res = new ArrayList<>();
        country.ifPresent(res::add);
        model.addAttribute("country", res);
        return "country-details";
    }

    @GetMapping("/country/{id}/edit")
    public String countryEdit(@PathVariable(value = "id") int idCountry, Model model) {
        if(!countryRepository.existsById(idCountry)) {
            return "redirect:/country";
        }

        Optional<country> country = countryRepository.findById(idCountry);
        ArrayList<country> res = new ArrayList<>();
        country.ifPresent(res::add);
        model.addAttribute("country", res);
        return "country-edit";
    }

    @PostMapping("/country/{id}/edit")
    public String countryUpdate(@PathVariable(value = "id") int idCountry, @RequestParam String name_country, Model model) {
        country country = countryRepository.findById(idCountry).orElseThrow(RuntimeException::new);
        country.setNameCountry(name_country);
        countryRepository.save(country);
        return "redirect:/country";
    }

    @PostMapping("/country/{id}/delete")
    public String countryDelete(@PathVariable(value = "id") int idCountry, Model model) {
        country country = countryRepository.findById(idCountry).orElseThrow(RuntimeException::new);
        countryRepository.delete(country);
        return "redirect:/country";
    }
}
