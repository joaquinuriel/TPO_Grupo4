package com.example.gympal.model;

import jakarta.persistence.*;

@Entity
public class Entrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean completo = false;

    @ManyToOne
    @JoinColumn(name = "rutina_id")
    private Rutina rutina;

    private Date fechaInicio = Date.now();

    public Entrenamiento() {}

    public boolean estaCompleto() {
        for (Ejercicio ejercicio : ejercicios) {
            if (!ejercicio.getRealizado()) 
                return false;
            return true;
        }
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
}
