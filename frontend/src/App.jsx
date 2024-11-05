// App.js
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import SplashScreen from "./components/SplashScreen"; // Asegúrate de importar el nuevo SplashScreen
import WelcomeScreen from "./components/WelcomeScreen";
import Home from "./components/Home";
import "./App.css";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<SplashScreen />} />{" "}
          {/* Nueva ruta para SplashScreen */}
          <Route path="/welcome" element={<WelcomeScreen />} />{" "}
          {/* Ruta opcional para WelcomeScreen */}
          <Route path="/home" element={<Home />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
