package com.example.music_lib.service;

import com.example.music_lib.entity.Likes;
import com.example.music_lib.entity.Song;
import com.example.music_lib.entity.User;
import com.example.music_lib.repository.LikesRepository;
import com.example.music_lib.repository.SongRepository;
import com.example.music_lib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikesService {
    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public long toggleLike(long userId, long songId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("No user found with ID: " + userId));
        Song song = songRepository.findById(songId).orElseThrow(() -> new RuntimeException("No song found with ID: " + songId));

        if (likesRepository.existsByUserUidAndSongSid(userId, songId)) {
            likesRepository.deleteByUserUidAndSongSid(userId, songId);
            return likesRepository.getLikeCountBySongId(songId);
        } else {
            Likes like = new Likes();
            like.setUser(user);
            like.setSong(song);
            likesRepository.save(like);

            return likesRepository.getLikeCountBySongId(songId);
        }
    }

    public int getLikeCount(long songId) {
        songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));
        return likesRepository.getLikeCountBySongId(songId);
    }
}