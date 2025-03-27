import { Link, useNavigate, useLocation } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSignOutAlt, faPlus } from '@fortawesome/free-solid-svg-icons';
import '../styles/Navbar.css';
import AuthPage from '../pages/AuthPage';
import AddSong from "../pages/AddSong";
import getAllSongs from "../utils/getAllSongs";

import { useState } from 'react';
import getLikesCount from '../utils/getLikesCount';

function Navbar() {
    const { logout, isLoggedIn } = useAuth();
    const navigate = useNavigate();
    const [isAuthOpen, setIsAuthOpen] = useState(false);
    const [isOpen, setIsOpen] = useState(false);


    const location = useLocation();

    const handleLogout = () => {
        logout();
        navigate('/home');
    };

    const handleLoginClick = () => {
        setIsAuthOpen(true);
    };

    const handleAuthClose = () => {
        setIsAuthOpen(false);
    };

    const handleClick = () => {
        setIsOpen(true);
    };

    const handleClose = () => {
        setIsOpen(false);
    };

    return (
        <>
            <nav className="navbar">
                <div className="navbar-left">
                    <Link to="/" className="logo">
                        MusicLib
                    </Link>
                </div>
                <div className="navbar-right">
                    {location.pathname === "/" ? null : (
                        <>
                            {location.pathname === "/profile" ? null :
                                isLoggedIn ? (
                                    <>
                                        <button onClick={handleClick} className='nav-button add-song'>
                                            <FontAwesomeIcon icon={faPlus} />&nbsp;Add Song
                                        </button>
                                        <Link to="/profile" className="nav-button">
                                            Profile
                                        </Link>
                                    </>
                                ) : null
                            }

                            {isLoggedIn ? (
                                location.pathname !== "/profile" ? null :
                                    <button onClick={handleLogout} className="nav-button login-button">
                                        <FontAwesomeIcon icon={faSignOutAlt} />&nbsp;Logout
                                    </button>
                            ) : location.pathname === "/" ? null : (
                                <button onClick={handleLoginClick} className="nav-button login-button">
                                    Login
                                </button>
                            )}
                        </>
                    )}
                </div>
            </nav>

            {isAuthOpen && (
                <div className="modal-overlay">
                    <div className="modal-content">
                        <AuthPage onClose={handleAuthClose} />
                    </div>
                </div>
            )}

            {isOpen && (
                <div className="modal-overlay">
                    <div className="modal-content">
                        <AddSong onClose={handleClose} />
                    </div>
                </div>
            )}
        </>
    );
}

export default Navbar;