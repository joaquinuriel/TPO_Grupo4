// WelcomeScreen.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import SplashScreen from './SplashScreen';
import './WelcomeScreen.css';

function WelcomeScreen() {
    const [fadeOut, setFadeOut] = useState(false); // Declaramos el estado fadeOut
    const [showSplash, setShowSplash] = useState(false);
    const navigate = useNavigate();

    const handleToggleClick = () => {
        setFadeOut(true); // Activa el efecto de desvanecimiento
        setTimeout(() => {
            navigate('/home');
        }, 1500); // Asegúrate de que coincida con el tiempo de la animación de desvanecimiento
    };

    return (
        showSplash ? (
            <SplashScreen />
        ) : (
            <div className={`welcome-screen ${fadeOut ? 'fade-out' : ''}`}>
                <h1 className="welcome-logo">GYMPAL</h1>
                <p className="welcome-mode">MODO FITNESS ON</p>
                <div className="toggle-switch">
                    <input
                        type="checkbox"
                        id="fitness-toggle"
                        onClick={handleToggleClick}
                    />
                    <label htmlFor="fitness-toggle"></label>
                </div>
            </div>
        )
    );
}

export default WelcomeScreen;
