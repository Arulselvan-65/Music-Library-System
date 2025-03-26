import React from 'react';
import '../styles/Home.css';

function Home() {
    console.log("Home is rendering!!");

    return (
        <div className="home-container">
            <div className="home-content">
                <p className="home-title">Discover Your Perfect Sound</p>
                
                <p className="home-description">
                    Access millions of songs, create personalized playlists, and explore new music 
                    tailored to your unique taste. Your entire music world, all in one place.
                </p>
                
                
                <div className="home-cta">
                    <button className="get-started-button"> Get Started </button>
                </div>
            </div>
            

            <div className="home-image-container">
                <img 
                    src="/pic.jpg" 
                    alt="Music Library" 
                    className="home-image"
                />
            </div>
        </div>
    );
}

export default Home;