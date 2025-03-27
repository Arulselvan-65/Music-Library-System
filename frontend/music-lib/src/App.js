import './App.css';
import { Routes, Route, BrowserRouter as Router } from "react-router-dom";
import { AuthProvider } from './contexts/AuthContext';
import { ProtectedRoute } from './components/ProtectedRoute';
import { ToastContainer } from 'react-toastify';
import LandingPage from "./pages/LandingPage";
import Home from "./pages/Home";
import SharedLayout from './components/SharedLayout';
import Profile from './pages/Profile';

function App() {
  console.log("App is rendering");

  return (
    <div className="App">
      <AuthProvider>
        <Router>
          <SharedLayout />
          <ToastContainer />
          <Routes>
            <Route path="/" element={<LandingPage />} />
            <Route path="/home" element={<Home />} />
            <Route path="/profile" element={
              <ProtectedRoute>
                <Profile />
              </ProtectedRoute>
            } />
          </Routes>
        </Router>
      </AuthProvider>
    </div>
  );
}

export default App;