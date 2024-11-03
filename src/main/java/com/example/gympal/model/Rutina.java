package com.example.gympal.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL)
    private List<Entrenamiento> entrenamientos;

    private Date fechaInicio;

    public Rutina() {}

    public Rutina(List<Entrenamiento> entrenamientos, Date fechaInicio) {
        this.entrenamientos = entrenamientos;
        this.fechaInicio = fechaInicio;
    }

    // Método para verificar si la rutina se ha cumplido a la perfección
    public boolean esPerfecta() {
        // Verificar si todos los entrenamientos están completos
        for (Entrenamiento entrenamiento : entrenamientos) {
            if (!entrenamiento.estaCompleto()) {
                return false;
            }
        }
        return true;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(List<Entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
