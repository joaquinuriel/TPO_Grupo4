package com.example.gympal.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Medicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float peso;
    private float masaMuscular;
    private float porcentajeGrasa;
    private Date fechaMedicion;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    public Date getFechaMedicion() {
        return fechaMedicion;
    }
}
