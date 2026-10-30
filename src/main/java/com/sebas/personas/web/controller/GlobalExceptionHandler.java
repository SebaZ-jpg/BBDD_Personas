package com.sebas.personas.web.controller;

import java.net.URI;
import java.util.List;
import com.sebas.personas.utils.exception.PersonaNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonaNoEncontradoException.class)
    ProblemDetail handleLibroNoEncontrado(PersonaNoEncontradoException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        problem.setTitle("Libro no encontrado");
        problem.setType(URI.create("<https://api.ejemplo.test/problemas/libro-no-encontrado>"));
        return problem;
    }

    @ExceptionHandler(com.sebas.personas.utils.exception.IsbnDuplicadoException.class)
    ProblemDetail handleIsbnDuplicado(com.sebas.personas.utils.exception.IsbnDuplicadoException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,
                ex.getMessage()
        );
        problem.setTitle("ISBN duplicado");
        return problem;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ProblemDetail handleValidation(MethodArgumentNotValidException ex) {
        List<ValidationError> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationError(
                        error.getField(),
                        error.getDefaultMessage()
                ))
                .toList();

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Revisa los campos indicados"
        );
        problem.setTitle("Datos no válidos");
        problem.setProperty("errors", errors);
        return problem;
    }

    private record ValidationError(String field, String message) {}
}