package com.project.modulo4.controller;


import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.service.LeagueService;
import com.project.modulo4.utils.exception.LeagueNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ligas")
@Slf4j
@RestController
@RequestMapping("/leagues")
public class LeagueController {

    private final LeagueService leagueService = new LeagueService();

    @Operation(summary = "Obtiene la lista de todas las Ligas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LeagueDTO> getAll() {
        return leagueService.getAll();
    }

    @Operation(summary = "Obtiene una Liga determinada")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LeagueDTO> getLeagueById(@PathVariable Long id) throws LeagueNotFoundException {
        LeagueDTO league = leagueService.getById(id);
        if (league != null) {
            return ResponseEntity.ok(league);
        } else {
            throw new LeagueNotFoundException(id);
        }
    }

    @Operation(summary = "Obtiene todos los Clubes de una Liga determinada")
    @GetMapping("{leagueId}/clubs")
    @ResponseStatus(HttpStatus.OK)
    public List<ClubDTO> findClubsByLeague(@PathVariable Long leagueId) throws LeagueNotFoundException {
        return leagueService.findClubsByLeague(leagueId);
    }

}

