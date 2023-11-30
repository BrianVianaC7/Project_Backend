package com.project.modulo4.service;

import com.project.modulo4.mapper.LeagueMapper;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.league.model.LeagueModel;
import com.project.modulo4.repository.LeagueRepository;
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