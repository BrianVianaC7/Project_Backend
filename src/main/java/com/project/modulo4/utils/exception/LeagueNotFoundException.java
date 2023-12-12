package com.project.modulo4.utils.exception;

public class LeagueNotFoundException extends RuntimeException{
    public LeagueNotFoundException(Long id) {
        super("La liga no existe", "LEAGUE_NOT_FOUND", id);

    }
}
