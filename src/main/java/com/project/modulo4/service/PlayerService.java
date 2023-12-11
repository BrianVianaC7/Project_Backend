package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.NationMapper;
import com.project.modulo4.mapper.PlayerMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.nation.dto.NationDTO;
import com.project.modulo4.models.player.dto.CreatePlayerDTO;
import com.project.modulo4.models.player.dto.PlayerDTO;
import com.project.modulo4.models.player.dto.UpdatePlayerDTO;
import com.project.modulo4.models.player.model.PlayerModel;
import com.project.modulo4.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private ClubService clubService;

    @Autowired
    private NationService nationService;

    @Autowired
    private ClubMapper clubMapper;

    @Autowired
    private NationMapper nationMapper;

    public List<PlayerDTO> getAll() {
        List<PlayerModel> players = playerRepository.findAll();
        return players.stream().map(playerMapper::toDTO).toList();
    }

    public PlayerDTO getById(Long playerId) {
        Optional<PlayerModel> playerOptional = playerRepository.findById(playerId);
        return playerOptional.map(playerMapper::toDTO).orElse(null);
    }

    @Transactional
    public PlayerDTO createPlayer(CreatePlayerDTO createPlayerDTO, Long nationId, Long clubId) {

        NationDTO nationDTO = nationService.getById(nationId);
        if (nationDTO == null){
            throw new RuntimeException("Nation no encontrada");
        }

        ClubDTO clubDTO = clubService.getById(clubId);
        if (clubDTO == null) {
            throw new RuntimeException("Club no encontrada");
        }

        PlayerModel playerModel = playerMapper.toModel(createPlayerDTO);
        playerModel.setNation(nationMapper.toModel(nationDTO));
        playerModel.setClub(clubMapper.toModel(clubDTO));
        // Obtienes el próximo ID disponible manualmente
        Long nextId = playerRepository.findMaxPlayerId() + 1;
        // Verifica si el ID ya está en uso
        while (playerRepository.existsById(nextId)) {
            nextId++;
        }
        playerModel.setId(nextId);
        playerModel = playerRepository.save(playerModel);


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
