import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import WelcomeScreen from './components/WelcomeScreen';
import Home from './components/Home'; // Crea este componente

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<WelcomeScreen />} />
                <Route path="/home" element={<Home />} />
            </Routes>
        </Router>
    );
}

export default App;
