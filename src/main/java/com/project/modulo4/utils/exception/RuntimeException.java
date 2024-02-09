package com.project.modulo4.utils.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RuntimeException extends Exception {

    private final String code;
    private final Serializable details;

    public RuntimeException(String message, String code, Object details) {
        super(message);
        this.code = code;
        this.details = (Serializable) details;
    }
}