package com.project.modulo4.controller;

import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.player.dto.CreatePlayerDTO;
import com.project.modulo4.models.player.dto.PlayerDTO;
import com.project.modulo4.models.player.dto.UpdatePlayerDTO;
import com.project.modulo4.service.PlayerService;
import com.project.modulo4.utils.exception.ClubNotFoundException;
import com.project.modulo4.utils.exception.NationNotFoundException;
import com.project.modulo4.utils.exception.PlayerNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDTO> getAll() {
        return playerService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) throws PlayerNotFoundException {
        PlayerDTO player = playerService.getById(id);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            throw new PlayerNotFoundException(id);
        }
    }

    @PostMapping("/{nationId}/{clubId}/player")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PlayerDTO> createPlayer(@Valid @RequestBody CreatePlayerDTO createPlayerDTO, @PathVariable Long nationId, @PathVariable Long clubId) throws NationNotFoundException, ClubNotFoundException {
        PlayerDTO createdPlayer = playerService.createPlayer(createPlayerDTO, nationId, clubId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deletePlayerById(@PathVariable Long id) throws PlayerNotFoundException {
        try {
            playerService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PlayerDTO> updatePlayerById(@PathVariable Long id, @Valid @RequestBody UpdatePlayerDTO updatePlayerDTO) throws PlayerNotFoundException {
        PlayerDTO updatedPlayer = playerService.updatePlayer(id, updatePlayerDTO);
        if (updatedPlayer != null) {
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
