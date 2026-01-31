package com.example.bai7.service;


import com.example.bai7.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    private final List<Song> songs = new ArrayList<>();
    private Long currentId = 1L;

    public List<Song> findAll() {
        return songs;
    }

    public void add(Song song) {
        song.setId(currentId++);
        songs.add(song);
    }

    public Song findById(Long id) {
        return songs.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void update(Long id, Song newSong) {
        Song song = findById(id);
        if (song != null) {
            song.setTitle(newSong.getTitle());
            song.setArtist(newSong.getArtist());
            song.setGenre(newSong.getGenre());
        }
    }

    public void delete(Long id) {
        songs.removeIf(s -> s.getId().equals(id));
    }
}
