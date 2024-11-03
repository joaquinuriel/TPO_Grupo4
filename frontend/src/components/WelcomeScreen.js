import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

function WelcomeScreen() {
    const [welcomeMessage, setWelcomeMessage] = useState("");
    const navigate = useNavigate();
    useEffect(() => {
        fetch("/api/welcome")
            .then(response => response.text())
            .then(message => setWelcomeMessage(message))
            .catch(error => console.error("Error fetching welcome message:", error));
    }, []);

    return (
        <div style={{textAlign: 'center', marginTop: '20%'}}>
            <h1>{welcomeMessage || "Cargando..."}</h1>
            <button onClick={() => navigate('/home')}>Comenzar</button>
        </div>
    );
}

export default WelcomeScreen;
