package com.project.modulo4.utils.exception;

public class ClubNotFoundException extends RuntimeException{

    public ClubNotFoundException(Long id) {
        super("El club no existe", "CLUB_NOT_FOUND", id);
    }
}
