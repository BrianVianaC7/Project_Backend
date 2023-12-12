package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.LeagueMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.league.model.LeagueModel;
import com.project.modulo4.repository.LeagueRepository;
import com.project.modulo4.utils.exception.LeagueNotFoundException;
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

    @Autowired
    private ClubMapper clubMapper;

    public List<LeagueDTO> getAll() {
        List<LeagueModel> leagues = leagueRepository.findAll();
        return leagues.stream().map(leagueMapper::toDTO).toList();
    }

    public LeagueDTO getById(Long leagueId) throws LeagueNotFoundException {
        Optional<LeagueModel> leagueOptional = leagueRepository.findById(leagueId);
        return leagueOptional.map(leagueMapper::toDTO).orElse(null);
    }

    public List<ClubDTO> findClubsByLeague(Long leagueId) throws LeagueNotFoundException {
        return clubMapper.toDTO(leagueRepository.findClubsByLeague(leagueId));
    }
}
