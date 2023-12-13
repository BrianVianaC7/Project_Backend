package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.LeagueMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.dto.UpdateClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.league.model.LeagueModel;
import com.project.modulo4.repository.ClubRepository;
import com.project.modulo4.utils.exception.ClubNotFoundException;
import com.project.modulo4.utils.exception.LeagueNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClubServiceTest {

    @InjectMocks
    private ClubService clubService;

    @Mock
    private ClubRepository clubRepository;

    @Mock
    private LeagueService leagueService;

    @Mock
    private ClubMapper clubMapper;

    @Mock
    private LeagueMapper leagueMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getById_ReturnsClubById() throws ClubNotFoundException {
        // Arrange
        Long clubId = 1L;
        ClubModel clubModel = new ClubModel();
        when(clubRepository.findById(clubId)).thenReturn(Optional.of(clubModel));
        when(clubMapper.toDTO(clubModel)).thenReturn(new ClubDTO());

        // Act
        ClubDTO result = clubService.getById(clubId);

        // Assert
        assertNotNull(result);
    }

    /*@Test
    void getById_ThrowsExceptionWhenClubNotFound() {
        // Arrange
        Long clubId = 1L;
        when(clubRepository.findById(clubId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ClubNotFoundException.class, () -> clubService.getById(clubId));
    }*/

    @Test
    void createClub_ReturnsCreatedClub() throws LeagueNotFoundException {
        // Arrange
        Long leagueId = 1L;
        CreateClubDTO createClubDTO = new CreateClubDTO();

        // Mocks
        LeagueDTO leagueDTO = new LeagueDTO();
        when(leagueService.getById(leagueId)).thenReturn(leagueDTO);

        // Configurar el mapeo del club
        ClubModel clubModel = new ClubModel();
        when(clubMapper.toModel(any(CreateClubDTO.class))).thenReturn(clubModel);

        // Configurar el comportamiento para cuando se llame clubRepository.save con cualquier instancia de ClubModel
        when(clubRepository.save(any(ClubModel.class))).thenReturn(clubModel);

        // Configurar el mapeo de DTO después de guardar
        ClubDTO clubDTOAfterSave = new ClubDTO();
        when(clubMapper.toDTO(any(ClubModel.class))).thenReturn(clubDTOAfterSave);

        // Act
        ClubDTO result = clubService.createClub(createClubDTO, leagueId);

        // Assert
        assertNotNull(result);
        assertEquals(clubDTOAfterSave, result);
    }

    @Test
    void updateClub_ReturnsUpdatedClub() throws ClubNotFoundException {
        // Arrange
        Long clubId = 1L;
        UpdateClubDTO updateClubDTO = new UpdateClubDTO();
        ClubModel existingClub = new ClubModel();
        when(clubRepository.findById(clubId)).thenReturn(Optional.of(existingClub));
        when(clubRepository.save(existingClub)).thenReturn(existingClub);
        when(clubMapper.toDTO(existingClub)).thenReturn(new ClubDTO());

        // Act
        ClubDTO result = clubService.updateClub(clubId, updateClubDTO);

        // Assert
        assertNotNull(result);
    }
}