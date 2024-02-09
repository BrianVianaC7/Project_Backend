package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.NationMapper;
import com.project.modulo4.mapper.PlayerMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.nation.dto.NationDTO;
import com.project.modulo4.models.player.dto.CreatePlayerDTO;
import com.project.modulo4.models.player.dto.PlayerDTO;
import com.project.modulo4.models.player.dto.UpdatePlayerDTO;
import com.project.modulo4.models.player.model.PlayerModel;
import com.project.modulo4.repository.PlayerRepository;
import com.project.modulo4.utils.exception.ClubNotFoundException;
import com.project.modulo4.utils.exception.NationNotFoundException;
import com.project.modulo4.utils.exception.PlayerNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PlayerService {

    final
    PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    private final ClubService clubService;

    private final NationService nationService;

    private final ClubMapper clubMapper;

    private final NationMapper nationMapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper, ClubService clubService, NationService nationService, ClubMapper clubMapper, NationMapper nationMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
        this.clubService = clubService;
        this.nationService = nationService;
        this.clubMapper = clubMapper;
        this.nationMapper = nationMapper;
    }

    public List<PlayerDTO> getAll() {
        List<PlayerModel> players = playerRepository.findAll();
        return players.stream().map(playerMapper::toDTO).toList();
    }

    public PlayerDTO getById(Long playerId) throws PlayerNotFoundException{
        Optional<PlayerModel> playerOptional = playerRepository.findById(playerId);
        return playerOptional.map(playerMapper::toDTO).orElse(null);
    }

    @Transactional
    public PlayerDTO createPlayer(CreatePlayerDTO createPlayerDTO, Long nationId, Long clubId) throws ClubNotFoundException, NationNotFoundException {

        NationDTO nationDTO = nationService.getById(nationId);
        if (nationDTO == null){
            throw new NationNotFoundException(nationId);
        }

        ClubDTO clubDTO = clubService.getById(clubId);
        if (clubDTO == null) {
            throw new ClubNotFoundException(clubId);
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

    public PlayerDTO updatePlayer(Long playerId, UpdatePlayerDTO updatePlayerDTO) throws PlayerNotFoundException {
        Optional<PlayerModel> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isPresent()) {
            PlayerModel existingPlayer = playerOptional.get();
            playerMapper.updateToModel(updatePlayerDTO, existingPlayer);
            PlayerModel updatedPlayer = playerRepository.save(existingPlayer);
            return playerMapper.toDTO(updatedPlayer);
        } else {
            throw new PlayerNotFoundException(playerId);
        }
    }
}
