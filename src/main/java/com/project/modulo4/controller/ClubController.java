package com.project.modulo4.controller;

import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.dto.UpdateClubDTO;
import com.project.modulo4.models.player.dto.PlayerDTO;
import com.project.modulo4.models.player.dto.UpdatePlayerDTO;
import com.project.modulo4.service.ClubService;
import com.project.modulo4.utils.exception.ClubNotFoundException;
import com.project.modulo4.utils.exception.LeagueNotFoundException;
import com.project.modulo4.utils.exception.PlayerNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Clubs")
@Slf4j
@RestController
@RequestMapping("/clubs")
public class ClubController {



    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @Operation(summary = "Obtiene la lista de todos los Clubes")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClubDTO> getAll() {
        return clubService.getAll();
    }

    @Operation(summary = "Obtiene un Club determinado")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClubDTO> getClubById(@PathVariable Long id) throws ClubNotFoundException {
        ClubDTO club = clubService.getById(id);
        if (club != null) {
            return ResponseEntity.ok(club);
        } else {
            throw new ClubNotFoundException(id);
        }
    }

    @Operation(summary = "Crea un Club en una Liga determinada")
    @PostMapping("/{leagueId}/club")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClubDTO> createClub(@Valid @RequestBody CreateClubDTO createClubDTO, @PathVariable Long leagueId) throws LeagueNotFoundException {
        ClubDTO createdClub = clubService.createClub(createClubDTO, leagueId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClub);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edita un Club determinado")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClubDTO> updateClubById(@PathVariable Long id, @Valid @RequestBody UpdateClubDTO updateClubDTO) throws ClubNotFoundException{
        ClubDTO updatedClub = clubService.updateClub(id, updateClubDTO);
        if (updatedClub != null) {
            return ResponseEntity.ok(updatedClub);
        } else {
            throw new ClubNotFoundException(id);
        }
    }
}
