package com.project.modulo4.service;

import com.project.modulo4.mapper.NationMapper;
import com.project.modulo4.models.nation.dto.NationDTO;
import com.project.modulo4.models.nation.model.NationModel;
import com.project.modulo4.repository.NationRepository;
import com.project.modulo4.utils.exception.NationNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

class NationServiceTest {

    @Mock
    private NationRepository nationRepository;

    @Mock
    private NationMapper nationMapper;

    @InjectMocks
    private NationService nationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll_ReturnsListOfNations() {
        // Arrange
        List<NationModel> nationModels = Collections.singletonList(new NationModel());
        when(nationRepository.findAll()).thenReturn(nationModels);

        // Utiliza anyList() con captura de argumentos para asegurar la inferencia de tipos
        when(nationMapper.toDTO(nationModels)).thenReturn(Collections.singletonList(new NationDTO()));

        // Act
        List<NationDTO> result = nationService.getAll();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void getById_NationExists_ReturnsNationDTO() throws NationNotFoundException {
        // Arrange
        Long nationId = 1L;
        NationModel nationModel = new NationModel();
        when(nationRepository.findById(nationId)).thenReturn(Optional.of(nationModel));
        when(nationMapper.toDTO(nationModel)).thenReturn(new NationDTO());

        // Act
        NationDTO result = nationService.getById(nationId);

        // Assert
        assertNotNull(result);
    }

    /*@Test
    void getById_NationNotFound_ThrowsNationNotFoundException() {
        // Arrange
        Long nationId = 1L;
        when(nationRepository.findById(nationId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NationNotFoundException.class, () -> nationService.getById(nationId));
    }*/
}