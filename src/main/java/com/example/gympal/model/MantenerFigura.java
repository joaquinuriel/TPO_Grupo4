package com.example.gympal.model;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class MantenerFigura extends Objetivo {

    private float pesoInicial;
    private float margenPeso;

    public MantenerFigura(Date fechaInicio, Socio socio, float pesoInicial, float margenPeso) {
        super(fechaInicio, socio);
        this.pesoInicial = pesoInicial;
        this.margenPeso = margenPeso;
    }

    public MantenerFigura() {

    }

    @Override
    public boolean verificarCumplimiento() {
        float pesoActual = getSocio().getPeso();
        if (pesoActual >= (pesoInicial - margenPeso) && pesoActual <= (pesoInicial + margenPeso)) {
            marcarCumplido();
            return true;
        }
        return false;
    }

    // Getters y setters
    public float getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(float pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public float getMargenPeso() {
        return margenPeso;
    }

    public void setMargenPeso(float margenPeso) {
        this.margenPeso = margenPeso;
    }
}
