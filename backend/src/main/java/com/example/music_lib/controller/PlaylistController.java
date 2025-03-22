package com.example.music_lib.controller;

import com.example.music_lib.entity.Playlist;
import com.example.music_lib.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playService;

    @GetMapping("/")
    public List<Playlist> getAllPlaylists(){
        return playService.getAllPlaylists();
    }

    @GetMapping("/playlist/{id}")
    public Optional<Playlist> getPlaylist(@PathVariable("id") long id){
        return playService.getPlaylist(id);
    }

    @PostMapping("/addplaylist")
    public String createPlaylist(@RequestBody Playlist playlist){
        return playService.createPlaylist(playlist);
    }

    @PutMapping("/{id}")
    public String updatePlaylist(@PathVariable("id") long id,@RequestBody Playlist playlist){
        return playService.updatePlaylist(id, playlist);
    }

    @DeleteMapping("/playlist/{id}")
    public String deletePlaylist(@PathVariable("id") long id){
        return playService.deletePlaylist(id);
    }

}
