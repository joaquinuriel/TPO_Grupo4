package com.example.gympal.model;

import jakarta.persistence.*;

@Entity
public class Entrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean completo;

    @ManyToOne
    @JoinColumn(name = "rutina_id")
    private Rutina rutina;

    public Entrenamiento() {}

    public Entrenamiento(boolean completo) {
        this.completo = completo;
    }

    public boolean estaCompleto() {
        return completo;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
}
