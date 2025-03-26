import './App.css';
import { Routes, Route, BrowserRouter as Router } from "react-router-dom";
import { AuthProvider } from './contexts/AuthContext';
import { ProtectedRoute } from './components/ProtectedRoute';
import { ToastContainer } from 'react-toastify';
import Home from "./pages/Home";
import SharedLayout from './components/SharedLayout';

function App() {
  console.log("App is rendering");

  return (
    <div className="App">
      <AuthProvider>

        <Router>
          <SharedLayout />
          <ToastContainer />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route
              path="/home"
              element={
                <ProtectedRoute>
                  <Home />
                </ProtectedRoute>
              }
            />
          </Routes>
        </Router>
      </AuthProvider>
    </div>
  );
}

export default App;