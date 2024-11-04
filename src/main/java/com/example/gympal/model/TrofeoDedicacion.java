package com.example.gympal.model;

public class TrofeoDedicacion extends Trofeo {
    public boolean verificarCriterio(Socio socio) {
        return socio.haCumplidoObjetivo();
    }
}
