package com.project.modulo4.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PlayerRepositoryTest {

    @Mock
    private PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindMaxPlayerId() {
        // Given
        Long maxId = 100L;
        when(playerRepository.findMaxPlayerId()).thenReturn(maxId);

        // When
        Long result = playerRepository.findMaxPlayerId();

        // Then
        assertNotNull(result);
        assertEquals(maxId, result);
    }
}
