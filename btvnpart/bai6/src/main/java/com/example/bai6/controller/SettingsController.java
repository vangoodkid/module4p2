package com.example.bai6.controller;



import com.example.bai6.model.MailSettings;
import com.example.bai6.service.SettingsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingsController {

    private final SettingsService service;

    public SettingsController(SettingsService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("settings", service.getSettings());
        return "settings";
    }

    @PostMapping("/update")
    public String update(MailSettings settings, Model model) {
        service.update(settings);
        model.addAttribute("settings", service.getSettings());
        return "settings";
    }
}

