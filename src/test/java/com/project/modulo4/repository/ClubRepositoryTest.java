package com.project.modulo4.repository;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.project.modulo4.models.league.model.LeagueModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

class ClubRepositoryTest {

    @Mock
    private ClubRepository clubRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindLeagueByClub() {
        long clubId = 1L;

        List<LeagueModel> leagueModels = new ArrayList<>();
        LeagueModel leagueModel = new LeagueModel();
        leagueModels.add(leagueModel);

        when(clubRepository.findLeagueByClub(clubId)).thenReturn(leagueModels);
        List<LeagueModel> result = clubRepository.findLeagueByClub(clubId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(leagueModel, result.get(0));
    }

    @Test
    void testFindMaxClubId() {
        Long maxClubId = 10L;
        when(clubRepository.findMaxClubId()).thenReturn(maxClubId);
        Long result = clubRepository.findMaxClubId();

        assertNotNull(result);
        assertEquals(maxClubId, result);
    }
}
