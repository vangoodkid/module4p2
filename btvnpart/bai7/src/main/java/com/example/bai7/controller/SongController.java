package com.example.bai7.controller;



import com.example.bai7.model.Song;
import com.example.bai7.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final String UPLOAD_DIR = "src/main/resources/static/music/";

    public SongController(SongService songService) {
        this.songService = songService;
    }

    // Danh sách bài hát
    @GetMapping
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "songs";
    }

    // Form thêm bài hát
    @GetMapping("/add")
    public String addForm() {
        return "add-song";
    }

    // Xử lý thêm bài hát
    @PostMapping("/add")
    public String addSong(@RequestParam String title,
                          @RequestParam String artist,
                          @RequestParam String genre,
                          @RequestParam MultipartFile file) throws IOException {

        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) dir.mkdirs();

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        file.transferTo(new File(UPLOAD_DIR + fileName));

        Song song = new Song(null, title, artist, genre, "/music/" + fileName);
        songService.add(song);

        return "redirect:/songs";
    }

    // Form sửa
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "edit-song";
    }

    // Xử lý sửa
    @PostMapping("/edit/{id}")
    public String editSong(@PathVariable Long id, Song song) {
        songService.update(id, song);
        return "redirect:/songs";
    }

    // Xóa bài hát
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        songService.delete(id);
        return "redirect:/songs";
    }
}
