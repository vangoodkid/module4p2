package com.example.bai4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/convert")
    public String convert(
            @RequestParam double rate,
            @RequestParam double usd,
            Model model) {

        double vnd = rate * usd;
        model.addAttribute("vnd", vnd);
        model.addAttribute("rate", rate);
        model.addAttribute("usd", usd);

        return "result";
    }
}
