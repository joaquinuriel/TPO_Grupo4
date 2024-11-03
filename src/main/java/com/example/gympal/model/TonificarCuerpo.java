package com.example.gympal.model;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class TonificarCuerpo extends Objetivo {

    private float masaMuscularObjetivo;
    private float porcentajeGrasaObjetivo;

    public TonificarCuerpo(Date fechaInicio, Socio socio, float masaMuscularObjetivo, float porcentajeGrasaObjetivo) {
        super(fechaInicio, socio);
        this.masaMuscularObjetivo = masaMuscularObjetivo;
        this.porcentajeGrasaObjetivo = porcentajeGrasaObjetivo;
    }

    public TonificarCuerpo() {

    }

    @Override
    public boolean verificarCumplimiento() {
        Socio socio = getSocio();
        if (socio.getMasaMuscular() >= masaMuscularObjetivo && socio.getPorcentajeGrasa() <= porcentajeGrasaObjetivo) {
            marcarCumplido();
            return true;
        }
        return false;
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

