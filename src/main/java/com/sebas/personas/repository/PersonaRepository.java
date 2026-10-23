package com.sebas.personas.repository;


import com.sebas.personas.controller.DTO.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository {

    public List<Persona> getPersonas();
}
