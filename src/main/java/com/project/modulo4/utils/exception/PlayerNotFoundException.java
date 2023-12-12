package com.project.modulo4.utils.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("El jugador no existe", "PLAYER_NOT_FOUND", id);
    }
}
