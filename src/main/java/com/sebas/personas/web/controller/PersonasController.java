package com.sebas.personas.web.controller;

import com.sebas.personas.service.PersonasService;
import com.sebas.personas.web.dto.CrearPersonaRequest;
import com.sebas.personas.web.dto.PersonaResponse;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libros")
public class PersonasController {

    private final PersonasService service;

    public PersonasController(PersonasService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PersonaResponse> crear(
            @Valid @RequestBody CrearPersonaRequest request) {

        PersonaResponse creado = service.crear(request);
        URI location = URI.create("/api/libros/" + creado.id());
        return ResponseEntity.created(location).body(creado);
    }

    @GetMapping("/{id}")
    public PersonaResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}