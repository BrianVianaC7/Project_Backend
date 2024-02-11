package com.project.modulo4.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.project.modulo4.models.club.model.ClubModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

class LeagueRepositoryTest {

    @Mock
    private LeagueRepository leagueRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindClubsByLeague() {
        long leagueId = 1L;
        List<ClubModel> clubModels = new ArrayList<>();
        ClubModel clubModel = new ClubModel();

        clubModels.add(clubModel);

        when(leagueRepository.findClubsByLeague(leagueId)).thenReturn(clubModels);
        List<ClubModel> result = leagueRepository.findClubsByLeague(leagueId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(clubModel, result.get(0));
    }
}
