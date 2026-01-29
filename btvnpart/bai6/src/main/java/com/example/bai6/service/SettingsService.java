package com.example.bai6.service;


import com.example.bai6.model.MailSettings;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {

    private MailSettings settings = new MailSettings(
            "English",
            25,
            true,
            "Thor\nKing, Asgard"
    );

    public MailSettings getSettings() {
        return settings;
    }

    public void update(MailSettings mailSettings) {
        this.settings = mailSettings;
    }
}
