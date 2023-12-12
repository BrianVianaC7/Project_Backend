package com.project.modulo4.controller;

import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.dto.UpdateClubDTO;
import com.project.modulo4.models.player.dto.PlayerDTO;
import com.project.modulo4.models.player.dto.UpdatePlayerDTO;
import com.project.modulo4.service.ClubService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClubDTO> getAll() {
        return clubService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClubDTO> getClubById(@PathVariable Long id) {
        ClubDTO club = clubService.getById(id);
        if (club != null) {
            return ResponseEntity.ok(club);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{leagueId}/club")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClubDTO> createClub(@Valid @RequestBody CreateClubDTO createClubDTO, @PathVariable Long leagueId) {
        ClubDTO createdClub = clubService.createClub(createClubDTO, leagueId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClub);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClubDTO> updateClubById(@PathVariable Long id, @Valid @RequestBody UpdateClubDTO updateClubDTO) {
        ClubDTO updatedClub = clubService.updateClub(id, updateClubDTO);
        if (updatedClub != null) {
            return ResponseEntity.ok(updatedClub);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
