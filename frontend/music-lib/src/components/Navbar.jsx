import { Link, useNavigate } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSignOutAlt } from '@fortawesome/free-solid-svg-icons';
import '../styles/Navbar.css';
import AuthPage from '../pages/AuthPage';
import { useState } from 'react';

function Navbar() {
    const { logout, isLoggedIn } = useAuth();
    const navigate = useNavigate();
    const [isAuthOpen, setIsAuthOpen] = useState(false);

    const handleLogout = () => {
        logout();
        navigate('/');
    };

    const handleLoginClick = () => {
        setIsAuthOpen(true);
    };

    const handleAuthClose = () => {
        setIsAuthOpen(false);
    };

    return (
        <>
        <nav className="navbar">
            <div className="navbar-left">
                <Link to="/home" className="logo">
                    MusicLib
                </Link>
            </div>
            <div className="navbar-right">
                <Link to="/profile" className="nav-button">
                    {isLoggedIn ? " Profile" : ""}
                </Link>
                {isLoggedIn ? (
                    <button onClick={handleLogout} className="nav-button login-button">
                        <FontAwesomeIcon icon={faSignOutAlt} />&nbsp;Logout
                    </button>
                ) : (
                    <button onClick={handleLoginClick} className="nav-button login-button">
                        Login
                    </button>
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
        </>
    );
}

export default Navbar;