package com.sebas.personas.controller.rest;

import com.sebas.personas.controller.DTO.Persona;
import com.sebas.personas.service.PersonasService;
import org.springframework.lang.Contract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonasController {

    private PersonasService service;


    public PersonasController(PersonasService service){
        this.service = service;
    }

    @GetMapping("/personas")
    public List<Persona> getPersonas(){
        return this.service.findAll();
    }
}
