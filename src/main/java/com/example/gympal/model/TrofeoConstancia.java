package com.example.gympal.model;

public class TrofeoConstancia extends Trofeo {
    public boolean verificarCriterio(Socio socio) {
        return socio.haCumplidoRutinaPerfectamente();
    }
}
