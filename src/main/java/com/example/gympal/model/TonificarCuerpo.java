package com.example.gympal.model;

import jakarta.persistence.Entity;
import java.util.Date;

@Entity
public class TonificarCuerpo extends Objetivo {

    private float masaMuscularObjetivo;
    private float porcentajeGrasaObjetivo;

    public TonificarCuerpo(Date fechaInicio, Socio socio, float masaMuscularObjetivo, float porcentajeGrasaObjetivo) {
        super(socio);
        this.fechaInicio = new Date();
        this.masaMuscularObjetivo = masaMuscularObjetivo;
        this.porcentajeGrasaObjetivo = porcentajeGrasaObjetivo;
    }

    public TonificarCuerpo() {}

    @Override
    public boolean verificarCumplimiento() {
        Socio socio = getSocio();
        if (socio.getMasaMuscular() >= masaMuscularObjetivo && socio.getPorcentajeGrasa() <= porcentajeGrasaObjetivo) {
            return true;
        }
        return false;
    }

    // Metodo para calcular el progreso en función de masa muscular y porcentaje de grasa
    @Override
    public void calcularProgreso() {
        Socio socio = getSocio();
        float progresoMasaMuscular = Math.min(100, (socio.getMasaMuscular() / masaMuscularObjetivo) * 100); //Calcula el progreso de masa muscular en porcentaje, donde 100% significa que el socio ha alcanzado o superado la masa muscular objetivo.
        float progresoPorcentajeGrasa = Math.min(100, ((porcentajeGrasaObjetivo - socio.getPorcentajeGrasa()) / porcentajeGrasaObjetivo) * 100); ////Calcula el progreso de masa muscular en porcentaje, donde 100% significa que el socio ha alcanzado o superado la masa muscular objetivo.

        // Promedio de ambos factores para determinar el progreso total
        setProgreso((progresoMasaMuscular + progresoPorcentajeGrasa) / 2);
    }

    // Getters y setters
    public float getMasaMuscularObjetivo() {
        return masaMuscularObjetivo;
    }

    public void setMasaMuscularObjetivo(float masaMuscularObjetivo) {
        this.masaMuscularObjetivo = masaMuscularObjetivo;
    }

    public float getPorcentajeGrasaObjetivo() {
        return porcentajeGrasaObjetivo;
    }

    public void setPorcentajeGrasaObjetivo(float porcentajeGrasaObjetivo) {
        this.porcentajeGrasaObjetivo = porcentajeGrasaObjetivo;
    }
}

