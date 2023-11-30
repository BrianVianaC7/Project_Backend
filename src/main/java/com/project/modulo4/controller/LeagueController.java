package com.project.modulo4.controller;


import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.service.LeagueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/leagues")
public class LeagueController {
    @Autowired
    private LeagueService leagueService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LeagueDTO> getAll() {
        return leagueService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LeagueDTO> getLeagueById(@PathVariable Long id) {
        LeagueDTO league = leagueService.getById(id);
        if (league != null) {
            return ResponseEntity.ok(league);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

