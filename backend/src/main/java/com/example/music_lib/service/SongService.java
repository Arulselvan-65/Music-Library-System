package com.example.music_lib.service;

import com.example.music_lib.entity.Song;
import com.example.music_lib.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class   SongService {

    @Autowired
    private SongRepository songRepository;

    public Optional<Song> getSong(long id){
        return songRepository.findById(id);
    }

    public String addSong(Song song){
        songRepository.save(song);
        return "Song added Successfully";
    }

    public String updateSong(long id, Song song){
        Optional<Song> s = songRepository.findById(id);

        Song es = s.get();

        es.setTitle(song.getTitle());
        es.setArtist(song.getArtist());
        es.setGenre(song.getGenre());

        songRepository.save(es);

        return "Song updated Successfully";
    }

    public String deleteSong(long id){
        songRepository.deleteById(id);
        return "Song with id " + id + " is deleted successfully";
    }

    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

}
