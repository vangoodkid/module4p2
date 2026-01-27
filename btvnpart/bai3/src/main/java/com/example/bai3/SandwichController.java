package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    private static final String[] CONDIMENTS = {
            "Lettuce",
            "Tomato",
            "Mustard",
            "Sprouts"
    };

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("condiments", CONDIMENTS);
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(required = false) String[] condiment,
                       Model model) {

        model.addAttribute("selectedCondiments", condiment);
        return "result";
    }
}
