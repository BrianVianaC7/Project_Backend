package com.project.modulo4.service;

import com.project.modulo4.mapper.NationMapper;
import com.project.modulo4.models.nation.dto.NationDTO;
import com.project.modulo4.models.nation.model.NationModel;
import com.project.modulo4.repository.NationRepository;
import com.project.modulo4.utils.exception.NationNotFoundException;
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
        List<NationModel> nations = nationRepository.findAll();
        return nations.stream().map(nationMapper::toDTO).toList();
    }

    public NationDTO getById(Long nationId) throws NationNotFoundException {
        Optional<NationModel> nationOptional = nationRepository.findById(nationId);
        return nationOptional.map(x -> nationMapper.toDTO(x)).orElse(null);
    }
}
