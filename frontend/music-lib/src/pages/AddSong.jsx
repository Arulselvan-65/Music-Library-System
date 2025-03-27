import React, { useState } from 'react';
import '../styles/AuthPage.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTimes } from '@fortawesome/free-solid-svg-icons';
import addSong from '../utils/addSong';

const AddSongPage = ({ onClose }) => {
  const initialFormData = { title: '', artist: '', genre: '', slink: '' };
  const [formData, setFormData] = useState(initialFormData);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    addSong(formData);
  }

  return (
    <>
      <div>
        <button onClick={onClose} className="close-button">
          <FontAwesomeIcon icon={faTimes} />
        </button>
      </div>
      <div className="auth-container">
        <div className="auth-box">
          <h2>Add Song</h2>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="title">Title</label>
              <input
                type="text"
                id="title"
                name="title"
                value={formData.title}
                onChange={handleInputChange}
                placeholder="Enter song title"
              />
            </div>

            <div className="form-group">
              <label htmlFor="artist">Artist</label>
              <input
                type="text"
                id="artist"
                name="artist"
                value={formData.artist}
                onChange={handleInputChange}
                placeholder="Enter song artist"
              />
            </div>

            <div className="form-group">
              <label htmlFor="genre">Genre</label>
              <input
                type="text"
                id="genre"
                name="genre"
                value={formData.genre}
                onChange={handleInputChange}
                placeholder="Enter song genre"
              />
            </div>



            <div className="form-group">
              <label htmlFor="slink">Song Link</label>
              <input
                type="text"
                id="slink"
                name="slink"
                value={formData.slink}
                onChange={handleInputChange}
                required
                placeholder="Enter song link"
              />
            </div>



            <button type="submit" className="submit-btn">
              Add Song
            </button>
          </form>
        </div>
      </div>
    </>
  );
};

export default AddSongPage;