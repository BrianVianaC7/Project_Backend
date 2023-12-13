package com.project.modulo4.controller;

import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.dto.UpdateClubDTO;
import com.project.modulo4.service.ClubService;
import com.project.modulo4.utils.exception.ClubNotFoundException;
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

class ClubControllerTest {

    @InjectMocks
    private ClubController clubController;

    @Mock
    private ClubService clubService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll_ReturnsListOfClubs() {
        // Arrange
        when(clubService.getAll()).thenReturn(Arrays.asList(
                new ClubDTO(), new ClubDTO()
        ));

        // Act
        List<ClubDTO> result = clubController.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void getClubById_ReturnsClubById() throws ClubNotFoundException {
        // Arrange
        Long clubId = 1L;
        when(clubService.getById(clubId)).thenReturn(new ClubDTO());

        // Act
        ResponseEntity<ClubDTO> response = clubController.getClubById(clubId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void getClubById_ThrowsExceptionWhenClubNotFound() throws ClubNotFoundException {
        // Arrange
        Long clubId = 1L;
        when(clubService.getById(clubId)).thenThrow(new ClubNotFoundException(clubId));

        // Act & Assert
        assertThrows(ClubNotFoundException.class, () -> clubController.getClubById(clubId));
    }

    @Test
    void createClub_ReturnsCreatedClub() throws LeagueNotFoundException {
        // Arrange
        Long leagueId = 1L;
        CreateClubDTO createClubDTO = new CreateClubDTO();
        when(clubService.createClub(createClubDTO, leagueId)).thenReturn(new ClubDTO());

        // Act
        ResponseEntity<ClubDTO> response = clubController.createClub(createClubDTO, leagueId);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void updateClubById_ReturnsUpdatedClub() throws ClubNotFoundException {
        // Arrange
        Long clubId = 1L;
        UpdateClubDTO updateClubDTO = new UpdateClubDTO();
        when(clubService.updateClub(clubId, updateClubDTO)).thenReturn(new ClubDTO());

        // Act
        ResponseEntity<ClubDTO> response = clubController.updateClubById(clubId, updateClubDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}