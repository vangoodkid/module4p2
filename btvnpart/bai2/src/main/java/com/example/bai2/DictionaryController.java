package com.example.bai2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
        dictionary.put("student", "sinh viên");
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam String word, Model model) {

        String meaning = dictionary.get(word.toLowerCase());

        if (meaning != null) {
            model.addAttribute("result", meaning);
        } else {
            model.addAttribute("result", "Không tìm thấy từ");
        }

        return "result";
    }
}
