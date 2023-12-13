package com.project.modulo4.controller;

import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.service.LeagueService;
import com.project.modulo4.utils.exception.LeagueNotFoundException;
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
import static org.mockito.Mockito.when;

class LeagueControllerTest {

    @InjectMocks
    private LeagueController leagueController;

    @Mock
    private LeagueService leagueService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll_ReturnsListOfLeagues() {
        // Arrange
        when(leagueService.getAll()).thenReturn(Arrays.asList(
                new LeagueDTO(), new LeagueDTO()
        ));

        // Act
        List<LeagueDTO> result = leagueController.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void getLeagueById_ReturnsLeagueById() throws LeagueNotFoundException {
        // Arrange
        Long leagueId = 1L;
        when(leagueService.getById(leagueId)).thenReturn(new LeagueDTO());

        // Act
        ResponseEntity<LeagueDTO> response = leagueController.getLeagueById(leagueId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void getLeagueById_ThrowsExceptionWhenLeagueNotFound() throws LeagueNotFoundException {
        // Arrange
        Long leagueId = 1L;
        when(leagueService.getById(leagueId)).thenThrow(new LeagueNotFoundException(leagueId));

        // Act & Assert
        assertThrows(LeagueNotFoundException.class, () -> leagueController.getLeagueById(leagueId));
    }

    @Test
    void findClubsByLeague_ReturnsListOfClubs() throws LeagueNotFoundException {
        // Arrange
        Long leagueId = 1L;
        when(leagueService.findClubsByLeague(leagueId)).thenReturn(Arrays.asList(
                new ClubDTO(), new ClubDTO()
        ));

        // Act
        List<ClubDTO> result = leagueController.findClubsByLeague(leagueId);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}