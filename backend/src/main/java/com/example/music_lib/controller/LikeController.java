package com.example.music_lib.controller;

import com.example.music_lib.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LikeController {

    @Autowired
    private LikesService likeService;

    @PostMapping("/like")
    public long toggleLike(@RequestParam("user_id") long userId, @RequestParam("song_id") long songId) {
        long likeCount = likeService.toggleLike(userId, songId);
        return likeCount;
    }
}