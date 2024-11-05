package com.example.gympal.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_objetivo")
public abstract class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaInicio;
    private boolean cumplido;
    private double progreso; // nuevo atributo de progreso

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    public Objetivo() {}

    public Objetivo(Socio socio) {
        this.socio = socio;
        this.cumplido = false;
        this.progreso = 0.0; // inicializa el progreso en 0
    }

    // Metodo abstracto para que cada subclase defina cómo calcular el progreso
    public abstract void calcularProgreso();

    // Metodo para verificar si el objetivo ha sido cumplido
    public boolean verificarCumplimiento() {
        return progreso >= 100.0;
    }

    public void marcarCumplido() {
        this.cumplido = true;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isCumplido() {
        return cumplido;
    }

    public void setCumplido(boolean cumplido) {
        this.cumplido = cumplido;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public double getProgreso() {
        return progreso;
    }

    public void setProgreso(double progreso) {
        this.progreso = progreso;
    }
}

