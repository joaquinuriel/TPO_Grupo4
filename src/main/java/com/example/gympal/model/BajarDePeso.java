package com.example.gympal.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("BAJAR_PESO")
public class BajarDePeso extends Objetivo {

    private double pesoInicial;
    private double pesoObjetivo;

    public BajarDePeso(Date fechaInicio, Socio socio, double pesoInicial, double pesoObjetivo) {
        super(fechaInicio, socio);
        this.pesoInicial = pesoInicial;
        this.pesoObjetivo = pesoObjetivo;
    }

    public BajarDePeso() {

    }

    @Override
    public void calcularProgreso() {
        double pesoActual = getSocio().getPeso(); // Suponiendo que Socio tiene un método getPeso()
        if (pesoActual <= pesoObjetivo) {
            setProgreso(100.0);
        } else {
            setProgreso(((pesoInicial - pesoActual) / (pesoInicial - pesoObjetivo)) * 100);
        }
    }

    // Getters y Setters
    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoObjetivo() {
        return pesoObjetivo;
    }

    public void setPesoObjetivo(double pesoObjetivo) {
        this.pesoObjetivo = pesoObjetivo;
    }
}
