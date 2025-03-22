package com.example.music_lib.service;

import com.example.music_lib.entity.Playlist;
import com.example.music_lib.entity.Song;
import com.example.music_lib.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playRepository;

    public Optional<Playlist> getPlaylist(long id){
        return playRepository.findById(id);
    }

    public String createPlaylist(Playlist playlist){
        playRepository.save(playlist);
        return "Playlist created Successfully";
    }

    public String updatePlaylist(long id, Playlist playlist){
        Optional<Playlist> p = playRepository.findById(id);

        Playlist ep = p.get();

        ep.setName(playlist.getName());
        ep.setSongid(playlist.getSongid());
        ep.setUserid(playlist.getUserid());

        playRepository.save(ep);

        return "Playlist updated Successfully";
    }

    public String deletePlaylist(long id){
        playRepository.deleteById(id);
        return "playlist with id " + id + " is deleted successfully";
    }

    public List<Playlist> getAllPlaylists() {
        return playRepository.findAll();
    }

}
