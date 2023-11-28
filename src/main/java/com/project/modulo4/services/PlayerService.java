package com.project.modulo4.services;

import com.project.modulo4.mapper.PlayerMapper;
import com.project.modulo4.models.dao.CreatePlayerDTO;
import com.project.modulo4.models.dao.PlayerDTO;
import com.project.modulo4.models.dao.UpdatePlayerDTO;
import com.project.modulo4.models.model.PlayerModel;
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
        List<PlayerModel> players = playerRepository.getAll();
        return players.stream().map(x -> playerMapper.toDTO(x)).toList();
    }

    public PlayerDTO getById(Long playerId) {
        Optional<PlayerModel> playerOptional = playerRepository.getById(playerId);
        return playerOptional.map(x -> playerMapper.toDTO(x)).orElse(null);
    }

    public PlayerDTO createPlayer(CreatePlayerDTO createPlayerDTO) {
        PlayerModel playerModel = playerMapper.toModel(createPlayerDTO);
        return playerMapper.toDTO(playerRepository.createPlayer(playerModel));
    }

    public void deleteById(Long playerId) {
        playerRepository.deleteById(playerId);
    }

    public PlayerDTO updatePlayer(Long playerId, UpdatePlayerDTO updatePlayerDTO) {
        Optional<PlayerModel> playerOptional = playerRepository.getById(playerId);
        if (playerOptional.isPresent()) {
            PlayerModel existingPlayer = playerOptional.get();
            PlayerModel updatedPlayer = playerMapper.updateToModel(updatePlayerDTO, existingPlayer);
            playerRepository.updatePlayer(updatedPlayer);
            return playerMapper.toDTO(updatedPlayer);
        } else {
            return null;
        }
    }
}
