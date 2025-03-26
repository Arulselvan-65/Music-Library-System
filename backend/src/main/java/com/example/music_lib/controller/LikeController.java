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
    public long toggleLike(@RequestParam long user_id, @RequestParam long song_id) {
        long likeCount = likeService.toggleLike(user_id, song_id);
        return likeCount;
    }
}