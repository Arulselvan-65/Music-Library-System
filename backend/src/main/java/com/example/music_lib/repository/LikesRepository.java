package com.example.music_lib.repository;

import com.example.music_lib.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    boolean existsByUserUidAndSongSid(long userId, long songId);

    void deleteByUserUidAndSongSid(long userId, long songId);

    @Query("SELECT COUNT(l) FROM Likes l WHERE l.song.sid = :songId")
    int getLikeCountBySongId(@Param("songId") long songId);
}