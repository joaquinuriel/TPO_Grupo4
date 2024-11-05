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

    public Rutina(List<Entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
        this.fechaInicio = new Date();
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

    public void reforzar() {
        
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public List<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }
}
