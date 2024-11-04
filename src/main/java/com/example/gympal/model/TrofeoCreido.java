package com.example.gympal.model;


public class TrofeoCreido extends Trofeo {
    public boolean verificarCriterio(Socio socio) {
        return socio.getCantidadPesajesEnUltimoMes() > 3;
    }
}
