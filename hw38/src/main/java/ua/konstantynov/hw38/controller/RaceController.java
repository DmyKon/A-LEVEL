package ua.konstantynov.hw38.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.konstantynov.hw38.entities.Horse;
import ua.konstantynov.hw38.entities.Race;
import ua.konstantynov.hw38.repos.RaceRepo;
import ua.konstantynov.hw38.service.RacesService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RaceController {
    private static final RacesService RACES_SERVICE = new RacesService();
    private static String exceptionMessage;

    @Autowired
    private RaceRepo raceRepo;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String main() {
        return "main";
    }

    @GetMapping("/list")
    public String listGet(Model model) {
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

    @GetMapping("/race/start")
    public String raceStart(Model model) {
        if (exceptionMessage != null) {
            model.addAttribute("exceptionMessage", exceptionMessage);
            exceptionMessage = null;
        }
        return "start";
    }

    @GetMapping("/stats")
    public String getStats(Model model) {
        return "stats";
    }

    @PostMapping("stats")
    public String postStats(@RequestParam String number, @RequestParam String count, Model model) {
        try {
            Race race = RACES_SERVICE.startRace(Integer.parseInt(count), Integer.parseInt(number));
            raceRepo.save(race);
            Integer horsePlace = race.getHorses().stream()
                    .filter(x -> x.getNumber() == Integer.parseInt(number))
                    .findFirst()
                    .map(Horse::getPlace)
                    .orElse(null);
            model.addAttribute("race", race);
            model.addAttribute("horsePlace", horsePlace);
            model.addAttribute("racesCount", raceRepo.count());
            return "stats";
        } catch (NumberFormatException e) {
            exceptionMessage = "Enter race parameters!";
            return "redirect:/race/start";
        } catch (IllegalArgumentException e) {
            exceptionMessage = e.getMessage();
            return "redirect:/race/start";
        }
    }

    @GetMapping("/race/*")
    public String getId(HttpServletRequest request, Model model) {
        try {
            Race race = raceRepo.findByIdentifier(Long.parseLong(request.getRequestURI().replaceAll("[^0-9]", "")));
            model.addAttribute("race", race);
        } catch (NumberFormatException ignored) {
        }
        return "race";
    }

    @PostMapping("/race")
    public String postId(@RequestParam String id, Model model) {
        model.addAttribute("race", raceRepo.findByIdentifier(Long.parseLong(id)));
        return "race";
    }
}