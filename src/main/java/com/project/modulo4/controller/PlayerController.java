package com.project.modulo4.controller;

import com.project.modulo4.models.dao.CreatePlayerDTO;
import com.project.modulo4.models.dao.PlayerDTO;
import com.project.modulo4.models.dao.UpdatePlayerDTO;
import com.project.modulo4.models.model.PlayerModel;
import com.project.modulo4.services.PlayerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/jugadores")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<PlayerDTO> getAll() {
        return playerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) {
        PlayerDTO player = playerService.getById(id);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@Valid @RequestBody CreatePlayerDTO createPlayerDTO) {
        PlayerDTO createdPlayer = playerService.createPlayer(createPlayerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerById(@PathVariable Long id) {
        try {
            playerService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayerById(@PathVariable Long id, @Valid @RequestBody UpdatePlayerDTO updatePlayerDTO) {
        PlayerDTO updatedPlayer = playerService.updatePlayer(id, updatePlayerDTO);
        if (updatedPlayer != null) {
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
