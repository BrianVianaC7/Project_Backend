package com.project.modulo4.service;

import com.project.modulo4.mapper.NationMapper;
import com.project.modulo4.models.nation.dto.NationDTO;
import com.project.modulo4.models.nation.model.NationModel;
import com.project.modulo4.repository.NationRepository;
import com.project.modulo4.utils.exception.NationNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NationService {

    final
    NationRepository nationRepository;

    final
    NationMapper nationMapper;

    public NationService(NationRepository nationRepository, NationMapper nationMapper) {
        this.nationRepository = nationRepository;
        this.nationMapper = nationMapper;
    }


    public List<NationDTO> getAll() {
        List<NationModel> nations = nationRepository.findAll();
        return nations.stream().map(nationMapper::toDTO).toList();
    }

    public NationDTO getById(Long nationId) throws NationNotFoundException {
        Optional<NationModel> nationOptional = nationRepository.findById(nationId);
        return nationOptional.map(nationMapper::toDTO).orElse(null);
    }
}
