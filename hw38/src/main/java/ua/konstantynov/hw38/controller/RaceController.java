package ua.konstantynov.hw38.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.konstantynov.hw38.entities.Race;
import ua.konstantynov.hw38.repos.RaceRepo;
import ua.konstantynov.hw38.service.RacesService;

@Controller
public class RaceController {
    private static final RacesService RACES_SERVICE = new RacesService();
    private static Race race;

    @Autowired
    private RaceRepo raceRepo;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String main() {
        return "main.html";
    }

    @GetMapping("/list")
    public String listGetAll(Model model) {
        model.addAttribute("races", raceRepo.findAll());
        return "list";
    }

    @PostMapping("list")
    public String listClear(@RequestParam String clear) {
        if (clear.equals("Accept")) {
            raceRepo.deleteAll();
        }
        return "redirect:/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/race/start")
    public String raceStart() {
        return "start";
    }

    @GetMapping("/stats")
    public String getStats(Model model) {
        model.addAttribute("race", race);
        return "stats";
    }

    @PostMapping("stats")
    public String postStats(@RequestParam int number, @RequestParam int count) {
        race = RACES_SERVICE.startRace(count, number);
        raceRepo.save(race);
        return "redirect:/stats";
    }
}