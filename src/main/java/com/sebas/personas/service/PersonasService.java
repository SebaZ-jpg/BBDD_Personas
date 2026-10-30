package com.sebas.personas.service;

import com.sebas.personas.database.entity.Persona;
import com.sebas.personas.database.repository.PersonaRepository;
import com.sebas.personas.utils.exception.PersonaNoEncontradoException;
import com.sebas.personas.utils.mapper.PersonaMapper;
import com.sebas.personas.web.dto.CrearPersonaRequest;
import com.sebas.personas.web.dto.PersonaResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonasService {

    private final PersonaRepository repository;
    private final PersonaMapper mapper;

    public PersonasService(PersonaRepository repository, PersonaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public PersonaResponse crear(CrearPersonaRequest request) {
        if (repository.existsByIsbn(request.isbn())) {
            throw new com.sebas.personas.utils.exception.IsbnDuplicadoException(request.isbn());
        }

        Persona libro = mapper.toEntity(request);
        Persona guardado = repository.save(libro);
        return mapper.toResponse(guardado);
    }

    @Transactional(readOnly = true)
    public PersonaResponse buscarPorId(Long id) {
        Persona libro = repository.findById(id)
                .orElseThrow(() -> new PersonaNoEncontradoException(id));

        return mapper.toResponse(libro);
    }
}