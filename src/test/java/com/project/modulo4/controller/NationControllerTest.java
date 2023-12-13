package com.project.modulo4.controller;

import com.project.modulo4.models.nation.dto.NationDTO;
import com.project.modulo4.service.NationService;
import com.project.modulo4.utils.exception.NationNotFoundException;
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

class NationControllerTest {

    @InjectMocks
    private NationController nationController;

    @Mock
    private NationService nationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll_ReturnsListOfNations() {
        // Arrange
        when(nationService.getAll()).thenReturn(Arrays.asList(
                new NationDTO(), new NationDTO()
        ));

        // Act
        List<NationDTO> result = nationController.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void getNationById_ReturnsNationById() throws NationNotFoundException {
        // Arrange
        Long nationId = 1L;
        when(nationService.getById(nationId)).thenReturn(new NationDTO());

        // Act
        ResponseEntity<NationDTO> response = nationController.getNationById(nationId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void getNationById_ThrowsExceptionWhenNationNotFound() throws NationNotFoundException {
        // Arrange
        Long nationId = 1L;
        when(nationService.getById(nationId)).thenThrow(new NationNotFoundException(nationId));

        // Act & Assert
        assertThrows(NationNotFoundException.class, () -> nationController.getNationById(nationId));
    }
}