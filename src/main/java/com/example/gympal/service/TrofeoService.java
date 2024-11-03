package com.example.gympal.service;

import com.example.gympal.model.Socio;
import com.example.gympal.model.Trofeo;
import com.example.gympal.repository.TrofeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TrofeoService {

    @Autowired
    private TrofeoRepository trofeoRepository;

    public Trofeo otorgarTrofeoPorLogro(String nombreTrofeo, Socio socio) {
        Trofeo trofeo = new Trofeo(nombreTrofeo, new Date(), socio);
        return trofeoRepository.save(trofeo);
    }

    public void verificarYOtorgarTrofeos(Socio socio) {
        // Verificar si el socio ha cumplido su objetivo principal y otorgar el trofeo de Dedicación
        if (socio.haCumplidoObjetivo()) {
            otorgarTrofeoPorLogro("Dedicación", socio);
        }

        // Verificar si el socio ha cumplido perfectamente con la rutina
        if (socio.haCumplidoRutinaPerfectamente()) {
            otorgarTrofeoPorLogro("Constancia", socio);
        }

        // Verificar si el socio se ha pesado más de tres veces en el mes
        if (socio.getCantidadPesajesEnUltimoMes() > 3) {
            otorgarTrofeoPorLogro("Creído", socio);
        }
    }
}
