package com.example.music_lib.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="userId")
    private Long userId;

    @Column(name="songId")
    private Long songId;

    public Playlist() {}

    public Playlist(String name, long userId, long songId) {
        this.name = name;
        this.userId = userId;
        this.songId = songId;
    }

    public int getPid() {
        return Math.toIntExact(pid);
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }
}