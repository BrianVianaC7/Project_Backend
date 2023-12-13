package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.NationMapper;
import com.project.modulo4.mapper.PlayerMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private PlayerMapper playerMapper;

    @Mock
    private ClubService clubService;
    @Mock
    private ClubMapper clubMapper;

    @Mock
    private NationService nationService;

    @Mock
    private NationMapper nationMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll_ReturnsListOfPlayers() {
        // Arrange
        List<PlayerModel> playerModels = Collections.singletonList(new PlayerModel());
        when(playerRepository.findAll()).thenReturn(playerModels);
        when(playerMapper.toDTO(playerModels)).thenReturn(Collections.singletonList(new PlayerDTO()));

        // Act
        List<PlayerDTO> result = playerService.getAll();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void getById_PlayerExists_ReturnsPlayerDTO() throws PlayerNotFoundException {
        // Arrange
        long playerId = 1L;
        PlayerModel playerModel = new PlayerModel();
        when(playerRepository.findById(playerId)).thenReturn(Optional.of(playerModel));
        when(playerMapper.toDTO(playerModel)).thenReturn(new PlayerDTO());

        // Act
        PlayerDTO result = playerService.getById(playerId);

        // Assert
        assertNotNull(result);
    }

    /*@Test
    void getById_PlayerDoesNotExist_ThrowsPlayerNotFoundException() {
        // Arrange
        long playerId = 1L;
        when(playerRepository.findById(playerId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(PlayerNotFoundException.class, () -> playerService.getById(playerId));
    }*/

    @Test
    void createPlayer_ValidData_ReturnsCreatedPlayerDTO() throws ClubNotFoundException, NationNotFoundException {
        // Arrange
        CreatePlayerDTO createPlayerDTO = new CreatePlayerDTO();
        long nationId = 1L;
        long clubId = 2L;

        // Mocks para NationService
        NationDTO nationDTO = new NationDTO();
        when(nationService.getById(nationId)).thenReturn(nationDTO);

        // Mocks para ClubService
        ClubDTO clubDTO = new ClubDTO();
        when(clubService.getById(clubId)).thenReturn(clubDTO);

        // Mocks para PlayerMapper
        PlayerModel playerModel = new PlayerModel();
        when(playerMapper.toModel(createPlayerDTO)).thenReturn(playerModel);

        // Mocks para NationMapper
        NationModel nationModel = new NationModel();
        when(nationMapper.toModel(nationDTO)).thenReturn(nationModel);

        // Mocks para ClubMapper
        ClubModel clubModel = new ClubModel();
        when(clubMapper.toModel(clubDTO)).thenReturn(clubModel);

        // Mocks para PlayerRepository
        when(playerRepository.findMaxPlayerId()).thenReturn(0L);
        when(playerRepository.existsById(anyLong())).thenReturn(false);
        when(playerRepository.save(any(PlayerModel.class))).thenReturn(playerModel);

        // Mocks para PlayerMapper (toDTO)
        PlayerDTO playerDTO = new PlayerDTO();
        when(playerMapper.toDTO(playerModel)).thenReturn(playerDTO);

        // Act
        PlayerDTO result = playerService.createPlayer(createPlayerDTO, nationId, clubId);

        // Assert
        assertNotNull(result);
        assertEquals(playerDTO, result);
    }
    @Test
    void deleteById_PlayerExists_DeletesPlayer() {
        // Arrange
        long playerId = 1L;
        doNothing().when(playerRepository).deleteById(playerId);

        // Act
        assertDoesNotThrow(() -> playerService.deleteById(playerId));

        // Assert
        verify(playerRepository, times(1)).deleteById(playerId);
    }

    /*@Test
    void deleteById_PlayerDoesNotExist_ThrowsPlayerNotFoundException() {
        // Arrange
        long playerId = 1L;

        doThrow(new PlayerNotFoundException(playerId)).when(playerRepository).deleteById(playerId);

        // Act & Assert
        assertThrows(PlayerNotFoundException.class, () -> playerService.deleteById(playerId));
    }*/

    @Test
    void updatePlayer_PlayerExists_ReturnsUpdatedPlayerDTO() throws PlayerNotFoundException {
        // Arrange
        long playerId = 1L;
        UpdatePlayerDTO updatePlayerDTO = new UpdatePlayerDTO();
        PlayerModel existingPlayer = new PlayerModel();
        PlayerModel updatedPlayer = new PlayerModel();

        when(playerRepository.findById(playerId)).thenReturn(Optional.of(existingPlayer));
        when(playerMapper.updateToModel(updatePlayerDTO, existingPlayer)).thenReturn(updatedPlayer);
        when(playerRepository.save(existingPlayer)).thenReturn(updatedPlayer);
        when(playerMapper.toDTO(updatedPlayer)).thenReturn(new PlayerDTO());

        // Act
        PlayerDTO result = playerService.updatePlayer(playerId, updatePlayerDTO);

        // Assert
        assertNotNull(result);
        verify(playerRepository, times(1)).findById(playerId);
        verify(playerRepository, times(1)).save(existingPlayer);
        verify(playerMapper, times(1)).toDTO(updatedPlayer);
    }

    /*@Test
    void updatePlayer_PlayerDoesNotExist_ThrowsPlayerNotFoundException() {
        // Arrange
        long playerId = 1L;
        UpdatePlayerDTO updatePlayerDTO = new UpdatePlayerDTO();

        when(playerRepository.findById(playerId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(PlayerNotFoundException.class, () -> playerService.updatePlayer(playerId, updatePlayerDTO));
        verify(playerRepository, never()).save(any());
    }*/


}