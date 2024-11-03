package com.example.gympal.repository;

import com.example.gympal.model.Medicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicionRepository extends JpaRepository<Medicion, Long> {
}
