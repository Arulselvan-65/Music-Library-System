package com.example.music_lib.service;

import com.example.music_lib.entity.Playlist;
import com.example.music_lib.repository.PlaylistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;


    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Transactional
    public void deletePlaylist(String _name, long _userid) {
        playlistRepository.deleteByNameAndUserId(_name, _userid);
    }

    public Playlist updatePlaylist(long _pid, long _userid, String newName) {
        Playlist playlist = playlistRepository.findByPidAndUserId(_pid, _userid);

        if (playlist != null) {
            playlist.setName(newName);
            return playlistRepository.save(playlist);
        }
        return null;
    }

    public List<Playlist> getUserPlaylists(Integer userId) {
        return playlistRepository.findByUserId(userId);
    }

    public List<Playlist> getAllPlaylists(){
        return playlistRepository.findAll();
    }
}