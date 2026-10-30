package com.sebas.personas.database.repository;

import java.util.Optional;

import com.sebas.personas.database.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    boolean existsByIsbn(String isbn);

    Optional<Persona> findByIsbn(String isbn);
}