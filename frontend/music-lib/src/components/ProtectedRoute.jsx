import { useAuth } from '../contexts/AuthContext';
import { Navigate } from 'react-router-dom';

export function ProtectedRoute({ children }) {
    const { isLoggedIn } = useAuth();

    return isLoggedIn ? children : <Navigate to="/home" />;
}