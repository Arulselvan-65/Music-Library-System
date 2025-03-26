package com.example.music_lib.controller;

import com.example.music_lib.entity.Playlist;
import com.example.music_lib.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
@CrossOrigin(origins = "http://localhost:3000")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/")
    public List<Playlist> getAllPlaylists(){
        return playlistService.getAllPlaylists();
    }

    @PostMapping("/create")
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        Playlist created = playlistService.createPlaylist(playlist);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/playlist")
    public String deletePlaylist(
            @RequestParam long userId,
            @RequestParam String name) {
        playlistService.deletePlaylist(name, userId);
        return "Playlist with name " + name + " and userid " + userId + " is deleted successfully";
    }

    @PutMapping("/update")
    public ResponseEntity<Playlist> updatePlaylist(
            @RequestParam long userId,
            @RequestParam long pid,
            @RequestParam String newName) {
        Playlist updated = playlistService.updatePlaylist(pid, userId, newName);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Playlist>> getUserPlaylists(@PathVariable Integer userId) {
        List<Playlist> playlists = playlistService.getUserPlaylists(userId);
        return ResponseEntity.ok(playlists);
    }
}