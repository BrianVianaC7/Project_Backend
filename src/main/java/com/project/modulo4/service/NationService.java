package com.project.modulo4.service;

import com.project.modulo4.mapper.NationMapper;
import com.project.modulo4.models.nation.dto.NationDTO;
import com.project.modulo4.models.nation.model.NationModel;
import com.project.modulo4.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NationService {

    @Autowired
    NationRepository nationRepository;

    @Autowired
    NationMapper nationMapper;


    public List<NationDTO> getAll() {
        List<NationModel> nations = nationRepository.getAll();
        return nations.stream().map(x -> nationMapper.toDTO(x)).toList();
    }

    public NationDTO getById(Long nationId) {
        Optional<NationModel> nationOptional = nationRepository.getById(nationId);
        return nationOptional.map(x -> nationMapper.toDTO(x)).orElse(null);
    }
}
