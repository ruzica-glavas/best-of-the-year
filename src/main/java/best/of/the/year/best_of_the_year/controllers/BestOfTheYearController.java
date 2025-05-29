package best.of.the.year.best_of_the_year.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/")

public class BestOfTheYearController {

    @GetMapping("/home")
    public String home(Model model, @RequestParam (name="name") String name) {
        model.addAttribute("name" , name);
        return "index";
    }
    

}
