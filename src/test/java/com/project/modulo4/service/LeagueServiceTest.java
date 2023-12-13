package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.LeagueMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.league.model.LeagueModel;
import com.project.modulo4.repository.LeagueRepository;
import com.project.modulo4.utils.exception.LeagueNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LeagueServiceTest {

    @Mock
    private LeagueRepository leagueRepository;

    @Mock
    private LeagueMapper leagueMapper;

    @Mock
    private ClubMapper clubMapper;

    @InjectMocks
    private LeagueService leagueService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll_ReturnsListOfLeagues() {
        // Arrange
        List<LeagueModel> leagueModels = Collections.singletonList(new LeagueModel());
        when(leagueRepository.findAll()).thenReturn(leagueModels);
        when(leagueMapper.toDTO(leagueModels)).thenReturn(Collections.singletonList(new LeagueDTO()));

        // Act
        List<LeagueDTO> result = leagueService.getAll();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void getById_LeagueExists_ReturnsLeagueDTO() throws LeagueNotFoundException {
        // Arrange
        Long leagueId = 1L;
        LeagueModel leagueModel = new LeagueModel();
        when(leagueRepository.findById(leagueId)).thenReturn(Optional.of(leagueModel));
        when(leagueMapper.toDTO(leagueModel)).thenReturn(new LeagueDTO());

        // Act
        LeagueDTO result = leagueService.getById(leagueId);

        // Assert
        assertNotNull(result);
    }

    /*@Test
    void getById_LeagueNotFound_ThrowsLeagueNotFoundException() {
        // Arrange
        Long leagueId = 1L;
        when(leagueRepository.findById(leagueId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(LeagueNotFoundException.class, () -> leagueService.getById(leagueId));
    }*/

    @Test
    void findClubsByLeague_LeagueExists_ReturnsListOfClubDTO() throws LeagueNotFoundException {
        // Arrange
        Long leagueId = 1L;
        List<ClubModel> clubModels = Collections.singletonList(new ClubModel());
        when(leagueRepository.findClubsByLeague(leagueId)).thenReturn(clubModels);
        when(clubMapper.toDTO(clubModels)).thenReturn(Collections.singletonList(new ClubDTO()));

        // Act
        List<ClubDTO> result = leagueService.findClubsByLeague(leagueId);

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    /*@Test
    void findClubsByLeague_LeagueNotFound_ThrowsLeagueNotFoundException() {
        // Arrange
        Long leagueId = 1L;
        when(leagueRepository.findClubsByLeague(leagueId)).thenReturn(Collections.emptyList());

        // Act and Assert
        assertThrows(LeagueNotFoundException.class, () -> leagueService.findClubsByLeague(leagueId));
    }*/
}