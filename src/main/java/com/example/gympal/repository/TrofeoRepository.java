package com.example.gympal.repository;

import com.example.gympal.model.Trofeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrofeoRepository extends JpaRepository<Trofeo, Long> {
}
