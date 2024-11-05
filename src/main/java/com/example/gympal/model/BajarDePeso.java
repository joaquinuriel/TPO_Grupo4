package com.example.gympal.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("BAJAR_PESO")
public class BajarDePeso extends Objetivo {

    private Date fechaInicio;
    private double pesoInicial;
    private double pesoObjetivo;
    private double indiceCondicionFisica; // capacidad fisica del socio para 
    private IMedicionAdapter medicionAdapter;

    public BajarDePeso(Socio socio) {
        super(socio);
        this.fechaInicio = new Date();
        Medicion ultimaMedicion = socio.ultimaMedicion();
        this.pesoInicial = ultimaMedicion.getPeso();
        this.pesoObjetivo = medicionAdapter.calcularPesoIdeal(socio);
        this.indiceCondicionFisica = medicionAdapter.calcularIndice(socio);
    }

    public BajarDePeso() {

    }

    public void armarRutina() {
        Ejercicio Sentadillas = new Ejercicio(
            "Sentadillas",
            GrupoMuscular.Piernas,
            3,
            2,
            5 * indiceCondicionFisica, // peso
            2,
            2
        );

        Ejercicio PresMilitar = new Ejercicio(
            "PresMilitar",
            GrupoMuscular.Hombro,
            2,
            3,
            10 * indiceCondicionFisica, // peso
            3,
            3
        );

        Ejercicio FlexionesDeBrazo = new Ejercicio(
            "FlexionesDeBrazo",
            GrupoMuscular.Pecho,
            3,
            2,
            15 * indiceCondicionFisica, // peso
            2,
            2
        );

        // mas ejercicios

        List<Ejercicio> ejercicios = new ArrayList();
        ejercicios.add(Sentadillas);
        ejercicios.add(PresMilitar);
        ejercicios.add(FlexionesDeBrazo);

        List<Entrenamiento> entrenamientos = new ArrayList();

        int ejerciciosPorDia = Math.floor(ejercicios.size / socio.entrenamientosPorSemana);

        int ind = 0;
        for (Ejercicio ejercicio : ejercicios) {

            ind++;
        }

        for (int i = 0; i < ejercicios; i++) {
            entrenamientos[(ejercicios.size - i - 1) % entrenamientosPorSemana].add(ejercicio[i]); 
        }   

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
