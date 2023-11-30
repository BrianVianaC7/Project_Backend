package com.project.modulo4.service;

import com.project.modulo4.mapper.PlayerMapper;
import com.project.modulo4.models.player.dto.CreatePlayerDTO;
import com.project.modulo4.models.player.dto.PlayerDTO;
import com.project.modulo4.models.player.dto.UpdatePlayerDTO;
import com.project.modulo4.models.player.model.PlayerModel;
import com.project.modulo4.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    private PlayerMapper playerMapper;

    public List<PlayerDTO> getAll() {
        List<PlayerModel> players = playerRepository.findAll();
        return players.stream().map(playerMapper::toDTO).toList();
    }

    public PlayerDTO getById(Long playerId) {
        Optional<PlayerModel> playerOptional = playerRepository.findById(playerId);
        return playerOptional.map(playerMapper::toDTO).orElse(null);
    }

    public PlayerDTO createPlayer(CreatePlayerDTO createPlayerDTO) {
        PlayerModel playerModel = playerRepository.save(playerMapper.toModel(createPlayerDTO));
        return playerMapper.toDTO(playerModel);
    }
    public void deleteById(Long playerId) {
        playerRepository.deleteById(playerId);
    }

    public PlayerDTO updatePlayer(Long playerId, UpdatePlayerDTO updatePlayerDTO) {
        Optional<PlayerModel> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isPresent()) {
            PlayerModel existingPlayer = playerOptional.get();
            playerMapper.updateToModel(updatePlayerDTO, existingPlayer);
            PlayerModel updatedPlayer = playerRepository.save(existingPlayer);

            return playerMapper.toDTO(updatedPlayer);
        } else {
            return null;
        }
    }
}
