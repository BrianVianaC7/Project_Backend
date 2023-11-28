package com.project.modulo4.league.controller;


import com.project.modulo4.league.models.dto.LeagueDTO;
import com.project.modulo4.league.service.LeagueService;
import com.project.modulo4.nation.models.dto.NationDTO;
import com.project.modulo4.nation.service.NationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/leagues")
public class LeagueController {
    @Autowired
    private LeagueService leagueService;

    @GetMapping
    public List<LeagueDTO> getAll() {
        return leagueService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeagueDTO> getLeagueById(@PathVariable Long id) {
        LeagueDTO league = leagueService.getById(id);
        if (league != null) {
            return ResponseEntity.ok(league);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

