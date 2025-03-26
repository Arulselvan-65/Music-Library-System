package com.example.music_lib.repository;

import com.example.music_lib.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findBySidIn(List<Integer> songIds);
}