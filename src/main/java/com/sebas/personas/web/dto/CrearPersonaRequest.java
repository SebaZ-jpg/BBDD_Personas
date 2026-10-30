package com.sebas.personas.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record CrearPersonaRequest(

        @NotBlank(message = "El ISBN es obligatorio")
        @Pattern(
                regexp = "\\d{10}|\\d{13}",
                message = "El ISBN debe contener 10 o 13 dígitos"
        )
        String isbn,

        @NotBlank(message = "El título es obligatorio")
        @Size(max = 200, message = "El título no puede superar 200 caracteres")
        String titulo,

        @PastOrPresent(message = "La fecha no puede ser futura")
        LocalDate fechaPublicacion
) {}