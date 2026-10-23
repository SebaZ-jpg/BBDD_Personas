package com.sebas.personas.service;

import com.sebas.personas.controller.DTO.Persona;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Service
public class PersonasService {

        public List<Persona> findAll(){
            return List.of(new Persona("1234", "nombre1"));
        }
    }

