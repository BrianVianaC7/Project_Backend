package com.project.modulo4.utils.exception;

public class NationNotFoundException extends RuntimeException{
    public NationNotFoundException(Long id) {
        super("El pais no existe", "NATION_NOT_FOUND", id);
    }
}
