package com.sebas.personas.utils.exception;

import com.sebas.personas.database.entity.Persona;

public class PersonaNoEncontradoException extends RuntimeException {

    public PersonaNoEncontradoException(Long id) {
        super("No existe el libro con id " + id);
    }
}