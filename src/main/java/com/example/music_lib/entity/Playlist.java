package com.example.music_lib.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    private String name;
    private long userid;
    private long songid;

    public Playlist(){}

    public Playlist(String _name,long _userid,long _songid) {
        this.name = _name;
        this.userid = _userid;
        this.songid = _songid;
    }


}
