package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.NationMapper;
import com.project.modulo4.mapper.PlayerMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.dto.UpdateClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.nation.dto.NationDTO;
import com.project.modulo4.models.nation.model.NationModel;
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
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
@Service
public class PlayerService {


    PlayerRepository playerRepository = new PlayerRepository() {
        @Override
        public Long findMaxPlayerId() {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends PlayerModel> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends PlayerModel> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<PlayerModel> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public PlayerModel getOne(Long aLong) {
            return null;
        }

        @Override
        public PlayerModel getById(Long aLong) {
            return null;
        }

        @Override
        public PlayerModel getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends PlayerModel> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends PlayerModel> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends PlayerModel> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<PlayerModel> findAll() {
            return null;
        }

        @Override
        public List<PlayerModel> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends PlayerModel> S save(S entity) {
            return null;
        }

        @Override
        public Optional<PlayerModel> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(PlayerModel entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends PlayerModel> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<PlayerModel> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<PlayerModel> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends PlayerModel> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends PlayerModel> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends PlayerModel> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends PlayerModel> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends PlayerModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };


    private final PlayerMapper playerMapper = new PlayerMapper() {
        @Override
        public PlayerDTO toDTO(PlayerModel playerModel) {
            return null;
        }

        @Override
        public List<PlayerDTO> toDTO(List<PlayerModel> model) {
            return null;
        }

        @Override
        public PlayerModel toModel(CreatePlayerDTO createPlayerDTO) {
            return null;
        }

        @Override
        public PlayerModel updateToModel(UpdatePlayerDTO updatePlayerDTO, PlayerModel playerModel) {
            return null;
        }
    };


    private final ClubService clubService = new ClubService();


    private final NationService nationService = new NationService();


    private final ClubMapper clubMapper = new ClubMapper() {
        @Override
        public ClubDTO toDTO(ClubModel clubModel) {
            return null;
        }

        @Override
        public ClubModel toModel(CreateClubDTO createClubDTO) {
            return null;
        }

        @Override
        public ClubModel updateToModel(UpdateClubDTO updateClubDTO, ClubModel clubModel) {
            return null;
        }

        @Override
        public ClubModel toModel(ClubDTO clubDTO) {
            return null;
        }

        @Override
        public List<ClubDTO> toDTO(List<ClubModel> model) {
            return null;
        }
    };


    private final NationMapper nationMapper = new NationMapper() {
        @Override
        public NationDTO toDTO(NationModel nationModel) {
            return null;
        }

        @Override
        public NationModel toModel(NationDTO nationDTO) {
            return null;
        }

        @Override
        public List<NationDTO> toDTO(List<NationModel> model) {
            return null;
        }
    };

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
    public void deleteById(Long playerId) throws PlayerNotFoundException {
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
