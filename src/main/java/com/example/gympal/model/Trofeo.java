package com.example.gympal.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Trofeo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Date fechaOtorgamiento;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    public Trofeo() {}

    public Trofeo(String nombre, Date fechaOtorgamiento, Socio socio) {
        this.nombre = nombre;
        this.fechaOtorgamiento = fechaOtorgamiento;
        this.socio = socio;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaOtorgamiento() {
        return fechaOtorgamiento;
    }

    public void setFechaOtorgamiento(Date fechaOtorgamiento) {
        this.fechaOtorgamiento = fechaOtorgamiento;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
