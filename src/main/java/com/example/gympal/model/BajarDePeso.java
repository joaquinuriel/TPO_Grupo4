package com.example.gympal.model;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class BajarDePeso extends Objetivo {

    private float pesoObjetivo;

    public BajarDePeso(Date fechaInicio, Socio socio, float pesoObjetivo) {
        super(fechaInicio, socio);
        this.pesoObjetivo = pesoObjetivo;
    }

    public BajarDePeso() {

    }

    @Override
    public boolean verificarCumplimiento() {
        if (getSocio().getPeso() <= pesoObjetivo) {
            marcarCumplido();
            return true;
        }
        return false;
    }

    // Getters y setters
    public float getPesoObjetivo() {
        return pesoObjetivo;
    }

    public void setPesoObjetivo(float pesoObjetivo) {
        this.pesoObjetivo = pesoObjetivo;
    }
}
