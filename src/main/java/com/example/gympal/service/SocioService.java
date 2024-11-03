package com.example.gympal.service;

import com.example.gympal.model.Socio;
import com.example.gympal.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;

    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    public Socio getSocioById(Long id) {
        return socioRepository.findById(id).orElse(null);
    }

    public Socio saveSocio(Socio socio) {
        return socioRepository.save(socio);
    }
}
