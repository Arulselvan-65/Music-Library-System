import { createContext, useContext, useState } from "react";
import { toast } from "react-toastify";

const AuthContext = createContext();


export const AuthProvider = ({children}) =>{
    const [isLoggedIn, setIsLoggedIn] = useState(()=>{
        return localStorage.getItem("isLoggedIn") === "true";
    });

    const login = () => {
        setIsLoggedIn(true);
        localStorage.setItem("isLoggedIn", true);
        toast.success("Logged in Successfully!", {theme: "dark", autoClose: 1000, pauseOnHover: false})
    }

    const logout = () => {
        setIsLoggedIn(false);
        toast.error("Logged out Successfully!", {theme: "dark", autoClose: 1000, pauseOnHover: false})
        localStorage.removeItem("isLoggedIn");
        localStorage.removeItem("userId");
    }

    return (
        <AuthContext.Provider value={{isLoggedIn, login, logout}}>
            {children}
        </AuthContext.Provider>
    )
}

export const useAuth = () => useContext(AuthContext);