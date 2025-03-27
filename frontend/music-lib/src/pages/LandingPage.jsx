import React from 'react';
import '../styles/LandingPage.css';
import { useNavigate } from 'react-router-dom';


function LandingPage() {

    const navigate = useNavigate();
    
    const handleClick = () =>{
        navigate("/home");
    }

    return (
        <div className="home-container">
            <div className="home-content">
                <p className="home-title">Discover Your Perfect Sound</p>
                
                <p className="home-description">
                    Access millions of songs, create personalized playlists, and explore new music 
                    tailored to your unique taste. Your entire music world, all in one place.
                </p>
                
                
                <div className="home-cta">

                    <button className="get-started-button" onClick={handleClick}> Get Started </button>
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

export default LandingPage;