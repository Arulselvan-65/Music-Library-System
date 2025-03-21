package com.example.music_lib.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sid;

    private String title;
    private String artist;
    private String genre;

    public Song(){}

    public Song(String _title,String _artist,String _genre) {
        this.title = _title;
        this.artist = _artist;
        this.genre = _genre;
    }

    public long getSid(){
        return this.sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
