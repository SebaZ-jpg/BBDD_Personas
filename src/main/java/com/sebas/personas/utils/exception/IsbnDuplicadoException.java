package com.sebas.personas.utils.exception;

public class IsbnDuplicadoException extends RuntimeException {

    public IsbnDuplicadoException(String isbn) {
        super("Ya existe un libro con ISBN " + isbn);
    }
}