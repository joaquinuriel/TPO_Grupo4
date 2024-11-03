package com.example.gympal.controller;

import com.example.gympal.model.Socio;
import com.example.gympal.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socios")
public class SocioController {
    @Autowired
    private SocioService socioService;

    @GetMapping
    public List<Socio> getAllSocios() {
        return socioService.getAllSocios();
    }

    @GetMapping("/{id}")
    public Socio getSocioById(@PathVariable Long id) {
        return socioService.getSocioById(id);
    }

    @PostMapping
    public Socio createSocio(@RequestBody Socio socio) {
        return socioService.saveSocio(socio);
    }
}
