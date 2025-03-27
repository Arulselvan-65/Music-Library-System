import React, { useState } from 'react';
import { Play, Pause, SkipForward, SkipBack, Heart, Clock, Music } from 'lucide-react';
import "../styles/Home.css";

function Home() {
    const [currentSong, setCurrentSong] = useState(null);
    const [isPlaying, setIsPlaying] = useState(false);

    const songs = [
        { id: 1, title: "Midnight City", artist: "The Echoes", album: "Urban Dreams", duration: "3:45", liked: true },
        { id: 2, title: "Ocean Waves", artist: "Coral Reef", album: "Deep Blue", duration: "4:12", liked: false },
        { id: 3, title: "Mountain High", artist: "Peak Climbers", album: "Summit", duration: "3:28", liked: true },
        { id: 4, title: "Desert Storm", artist: "Sand Dunes", album: "Mirage", duration: "5:01", liked: false },
        { id: 5, title: "Forest Echo", artist: "Woodland Sprites", album: "Ancient Trees", duration: "4:33", liked: true },
        { id: 6, title: "City Lights", artist: "Urban Dwellers", album: "Neon Signs", duration: "3:55", liked: false },
        { id: 7, title: "River Flow", artist: "Water Current", album: "Downstream", duration: "4:19", liked: true },
        { id: 4, title: "Desert Storm", artist: "Sand Dunes", album: "Mirage", duration: "5:01", liked: false },
        { id: 2, title: "Ocean Waves", artist: "Coral Reef", album: "Deep Blue", duration: "4:12", liked: false },
        
    ];

    const playSong = (songId) => {
        setCurrentSong(songId);
        setIsPlaying(true);
    };

    const togglePlayPause = () => {
        setIsPlaying(!isPlaying);
    };

    const toggleLike = (songId) => {
        // In a real app, this would update the state
        console.log(`Toggled like for song ${songId}`);
    };

    return (
        <div className="music-library-container">
            <div className="main-content">


                <div className="song-list-container">
                    <div className="song-list-header">
                        <div>#</div>
                        <div>TITLE</div>
                        <div>ARTIST</div>
                        <div className="song-duration">
                            <Clock size={16} className="icon" />
                        </div>
                        <div></div>
                    </div>

                    <div className="song-list">
                        {songs.map((song) => (
                            <div
                                key={song.id}
                                className={`song-item ${currentSong === song.id ? 'active' : ''}`}
                                onClick={() => playSong(song.id)}
                            >
                                <div className="song-number">
                                    {currentSong === song.id ?
                                        <Music size={16} className="icon music-icon-active" /> :
                                        <span>{song.id}</span>
                                    }
                                </div>
                                <div className="song-title-artist">
                                    <div className="song-title">{song.title}</div>
                                    <div className="song-artist">{song.artist}</div>
                                </div>
                                <div className="song-album">{song.album}</div>
                                <div className="song-duration">{song.duration}</div>
                                <div>
                                    <button
                                        onClick={(e) => {
                                            e.stopPropagation();
                                            toggleLike(song.id);
                                        }}
                                        className={`like-button ${song.liked ? 'active' : ''}`}
                                    >
                                        <Heart size={16} fill={song.liked ? "currentColor" : "none"} className="icon" />
                                    </button>
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
            </div>


            <div className="player-bar">
                <div className="now-playing">
                    {currentSong && (
                        <>
                            <div className="song-thumbnail">
                                <Music size={20} className="icon" />
                            </div>
                            <div className="playing-song-info">
                                <div className="playing-song-title">{songs.find(s => s.id === currentSong)?.title}</div>
                                <div className="playing-song-artist">{songs.find(s => s.id === currentSong)?.artist}</div>
                            </div>
                        </>
                    )}
                </div>

                <div className="player-controls">
                    <button className="control-button">
                        <SkipBack size={20} className="icon" />
                    </button>
                    <button
                        className="play-pause-button"
                        onClick={togglePlayPause}
                    >
                        {isPlaying ? <Pause size={20} className="icon" /> : <Play size={20} className="icon" style={{ marginLeft: '2px' }} />}
                    </button>
                    <button className="control-button">
                        <SkipForward size={20} className="icon" />
                    </button>
                </div>

                <div className="progress-container">
                    
                </div>
            </div>
        </div>
    );
}

export default Home;