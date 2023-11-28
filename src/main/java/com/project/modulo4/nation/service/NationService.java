package com.project.modulo4.nation.service;

import com.project.modulo4.nation.mapper.NationMapper;
import com.project.modulo4.nation.models.dto.NationDTO;
import com.project.modulo4.nation.models.model.NationModel;
import com.project.modulo4.nation.repository.NationRepository;
import com.project.modulo4.player.models.dto.PlayerDTO;
import com.project.modulo4.player.models.model.PlayerModel;
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
