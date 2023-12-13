package com.project.modulo4.controller;

import com.project.modulo4.models.player.dto.CreatePlayerDTO;
import com.project.modulo4.models.player.dto.PlayerDTO;
import com.project.modulo4.models.player.dto.UpdatePlayerDTO;
import com.project.modulo4.service.PlayerService;
import com.project.modulo4.utils.exception.ClubNotFoundException;
import com.project.modulo4.utils.exception.NationNotFoundException;
import com.project.modulo4.utils.exception.PlayerNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerControllerTest {

    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll_ReturnsListOfPlayers() {
        // Arrange
        when(playerService.getAll()).thenReturn(Arrays.asList(
                new PlayerDTO(), new PlayerDTO()
        ));

        // Act
        List<PlayerDTO> result = playerController.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void getPlayerById_ReturnsPlayerById() throws PlayerNotFoundException {
        // Arrange
        Long playerId = 1L;
        when(playerService.getById(playerId)).thenReturn(new PlayerDTO());

        // Act
        ResponseEntity<PlayerDTO> response = playerController.getPlayerById(playerId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void getPlayerById_ThrowsExceptionWhenPlayerNotFound() throws PlayerNotFoundException {
        // Arrange
        Long playerId = 1L;
        when(playerService.getById(playerId)).thenThrow(new PlayerNotFoundException(playerId));

        // Act & Assert
        assertThrows(PlayerNotFoundException.class, () -> playerController.getPlayerById(playerId));
    }

   @Test
    void createPlayer_ReturnsCreatedPlayer() throws ClubNotFoundException, NationNotFoundException {
        // Arrange
        Long nationId = 1L;
        Long clubId = 2L;
        CreatePlayerDTO createPlayerDTO = new CreatePlayerDTO();
        when(playerService.createPlayer(createPlayerDTO, nationId, clubId)).thenReturn(new PlayerDTO());

        // Act
        ResponseEntity<PlayerDTO> response = playerController.createPlayer(createPlayerDTO, nationId, clubId);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    /*@Test
    void createPlayer_ReturnsNotFoundWhenNationNotFound() throws ClubNotFoundException, NationNotFoundException {
        // Arrange
        Long nationId = 1L;
        Long clubId = 2L;
        CreatePlayerDTO createPlayerDTO = new CreatePlayerDTO();
        doThrow(new NationNotFoundException(nationId)).when(playerService).createPlayer(createPlayerDTO, nationId, clubId);

        // Act
        ResponseEntity<PlayerDTO> response = playerController.createPlayer(createPlayerDTO, nationId, clubId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }*/

    /*@Test
    void createPlayer_ReturnsNotFoundWhenClubNotFound() throws ClubNotFoundException, NationNotFoundException {
        // Arrange
        Long nationId = 1L;
        Long clubId = 2L;
        CreatePlayerDTO createPlayerDTO = new CreatePlayerDTO();
        doThrow(new ClubNotFoundException(clubId)).when(playerService).createPlayer(createPlayerDTO, nationId, clubId);

        // Act
        ResponseEntity<PlayerDTO> response = playerController.createPlayer(createPlayerDTO, nationId, clubId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }*/


    @Test
    void updatePlayerById_ReturnsUpdatedPlayer() throws PlayerNotFoundException {
        // Arrange
        Long playerId = 1L;
        UpdatePlayerDTO updatePlayerDTO = new UpdatePlayerDTO();
        when(playerService.updatePlayer(playerId, updatePlayerDTO)).thenReturn(new PlayerDTO());

        // Act
        ResponseEntity<PlayerDTO> response = playerController.updatePlayerById(playerId, updatePlayerDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void deletePlayerById_ReturnsOkWhenPlayerIsDeleted() throws PlayerNotFoundException {
        // Arrange
        Long playerId = 1L;

        // Act
        ResponseEntity<Void> response = playerController.deletePlayerById(playerId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(playerService, times(1)).deleteById(playerId);
    }

    @Test
    void deletePlayerById_ReturnsNotFoundWhenPlayerNotFound() throws PlayerNotFoundException {
        // Arrange
        Long playerId = 1L;
        doThrow(new PlayerNotFoundException(playerId)).when(playerService).deleteById(playerId);

        // Act
        ResponseEntity<Void> response = playerController.deletePlayerById(playerId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(playerService, times(1)).deleteById(playerId);
    }
}