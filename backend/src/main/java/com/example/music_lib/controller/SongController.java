package com.example.music_lib.controller;

import com.example.music_lib.entity.Song;
import com.example.music_lib.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongService songService;


    @GetMapping("/")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }


    @GetMapping("/song/{id}")
    public Optional<Song> getSong(@PathVariable("id") long id){
        return songService.getSong(id);
    }

    @PostMapping("/addsong")
    public String addSong(@RequestBody Song song){
        return songService.addSong(song);
    }

    @PutMapping("/{id}")
    public String updateSong(@PathVariable("id") long id,@RequestBody Song song){
        return songService.updateSong(id, song);
    }

    @DeleteMapping("/song/{id}")
    public String deleteSong(@PathVariable("id") long id){
        return songService.deleteSong(id);
    }

}
