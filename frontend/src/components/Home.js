import React from 'react';

function Home() {
    return (
        <div style={{
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            flexDirection: 'column',
            height: '100vh',
            background: 'linear-gradient(135deg, #f06, #ff9)',
            color: '#fff',
            fontFamily: 'Arial, sans-serif',
            textAlign: 'center'
        }}>
            <h1 style={{ fontSize: '3em', marginBottom: '0.5em' }}>¡Bienvenido a GymPal!</h1>
            <p style={{ fontSize: '1.5em', maxWidth: '600px' }}>
                Explora nuestras rutinas personalizadas, objetivos de entrenamiento y trofeos.
                ¡Estamos aquí para ayudarte a alcanzar tus metas de forma divertida y efectiva!
            </p>
            <button style={{
                marginTop: '2em',
                padding: '1em 2em',
                fontSize: '1.2em',
                color: '#f06',
                backgroundColor: '#fff',
                border: 'none',
                borderRadius: '8px',
                cursor: 'pointer',
                transition: 'transform 0.3s ease',
            }}
                    onMouseOver={(e) => e.target.style.transform = 'scale(1.1)'}
                    onMouseOut={(e) => e.target.style.transform = 'scale(1)'}
            >
                Comenzar tu entrenamiento
            </button>
        </div>
    );
}

export default Home;
