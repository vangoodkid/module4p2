package com.example.btvnpart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @PostMapping("/convert")
    public String convert(
            @RequestParam double rate,
            @RequestParam double usd,
            Model model) {

        double vnd = rate * usd;
        model.addAttribute("vnd", vnd);

        return "result";
    }
}

