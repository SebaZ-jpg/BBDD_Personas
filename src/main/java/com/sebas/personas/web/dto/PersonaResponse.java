package com.sebas.personas.web.dto;

import java.time.LocalDate;

public record PersonaResponse(
        Long id,
        String isbn,
        String titulo,
        LocalDate fechaPublicacion,
        boolean disponible
) {

}