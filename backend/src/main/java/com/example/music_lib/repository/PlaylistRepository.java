package com.example.music_lib.repository;

import com.example.music_lib.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findByUserId(long userId);

    Playlist findByPidAndUserId(long pid, long userId);
    void deleteByNameAndUserId(String name, long userId);
}