import React, { useState } from 'react';
import '../styles/AuthPage.css';
import axios from 'axios';
import { useAuth } from '../contexts/AuthContext';
import { toast } from 'react-toastify';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTimes } from '@fortawesome/free-solid-svg-icons';

const AuthPage = ({ onClose }) => {

  console.log("AuthPage is rendering");


  const initialFormData = { name: '', email: '', password: '' };
  const [isLogin, setIsLogin] = useState(true);
  const [formData, setFormData] = useState(initialFormData);
  const { login } = useAuth();



  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };


  const handleLoginSubmit = async (e) => {
    e.preventDefault();

    let res = axios.post("http://localhost:8080/api/users/user", {
      name: formData.name,
      password: formData.password,
      email: formData.email
    });

    if ((await res).data === true) {
      login();
      localStorage.setItem("isLoggedIn", true);
      onClose();
    }

  };

  const handleSignupSubmit = async (e) => {
    e.preventDefault();

    let res = axios.post("http://localhost:8080/api/users/newuser", {
      name: formData.name,
      password: formData.password,
      email: formData.email
    })

    console.log((await res).data);

    if ((await res).data === "User created successfully") {
      setFormData(initialFormData);
      toast.success("Account Created Successfully!!", { theme: "dark" });
    }
  };

  return (
    <>
    <div>
      <button onClick={onClose} className="close-button">
        <FontAwesomeIcon icon={faTimes} />
      </button>
      </div>
      <div className="auth-container">
        <div className="auth-box">
          <h2>{isLogin ? 'Login' : 'Sign Up'}</h2>
          <form onSubmit={isLogin ? handleLoginSubmit : handleSignupSubmit}>
            {!isLogin && (
              <div className="form-group">
                <label htmlFor="name">Name</label>
                <input
                  type="text"
                  id="name"
                  name="name"
                  value={formData.name}
                  onChange={handleInputChange}
                  required={!isLogin}
                  placeholder="Enter your name"
                />
              </div>
            )}

            <div className="form-group">
              <label htmlFor="email">Email</label>
              <input
                type="email"
                id="email"
                name="email"
                value={formData.email}
                onChange={handleInputChange}
                required
                placeholder="Enter your email"
              />
            </div>

            <div className="form-group">
              <label htmlFor="password">Password</label>
              <input
                type="password"
                id="password"
                name="password"
                value={formData.password}
                onChange={handleInputChange}
                required
                placeholder="Enter your password"
              />
            </div>

            <button type="submit" className="submit-btn">
              {isLogin ? 'Login' : 'Sign Up'}
            </button>
          </form>

          <p className="toggle-text">
            {isLogin ? "Don't have an account? " : "Already have an account? "}
            <span
              className="toggle-link"
              onClick={() => {
                setIsLogin(!isLogin);
                setFormData({ name: '', email: '', password: '' });
              }}
            >
              {isLogin ? 'Sign Up' : 'Login'}
            </span>
          </p>
        </div>
      </div>
    </>
  );
};

export default AuthPage;