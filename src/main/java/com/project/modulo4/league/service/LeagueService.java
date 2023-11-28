package com.project.modulo4.league.service;

import com.project.modulo4.league.mapper.LeagueMapper;
import com.project.modulo4.league.models.dto.LeagueDTO;
import com.project.modulo4.league.models.model.LeagueModel;
import com.project.modulo4.league.repository.LeagueRepository;
import com.project.modulo4.nation.mapper.NationMapper;
import com.project.modulo4.nation.models.dto.NationDTO;
import com.project.modulo4.nation.models.model.NationModel;
import com.project.modulo4.nation.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {
    @Autowired
    LeagueRepository leagueRepository;
    @Autowired
    LeagueMapper leagueMapper;

    public List<LeagueDTO> getAll() {
        List<LeagueModel> leagues = leagueRepository.getAll();
        return leagues.stream().map(x -> leagueMapper.toDTO(x)).toList();
    }

    public LeagueDTO getById(Long leagueId) {
        Optional<LeagueModel> leagueOptional = leagueRepository.getById(leagueId);
        return leagueOptional.map(x -> leagueMapper.toDTO(x)).orElse(null);
    }
}
