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

    public MantenerFigura() {}

    @Override
    public boolean verificarCumplimiento() {
        float pesoActual = getSocio().getPeso();
        if (pesoActual >= (pesoInicial - margenPeso) && pesoActual <= (pesoInicial + margenPeso)) {
            marcarCumplido();
            return true;
        }
        return false;
    }

    // Metodo para calcular el progreso basado en el peso actual
    @Override
    public void calcularProgreso() {
        float pesoActual = getSocio().getPeso();
        if (pesoActual >= (pesoInicial - margenPeso) && pesoActual <= (pesoInicial + margenPeso)) {
            setProgreso(100.0); // Si el peso está dentro del margen, progreso es 100%
        } else {
            float diferenciaPeso = Math.abs(pesoInicial - pesoActual);
            float margenTotal = 2 * margenPeso;
            setProgreso(Math.max(0, 100 - ((diferenciaPeso / margenTotal) * 100)));
            // Calcula el progreso en función de la cercanía al margen
        }
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
