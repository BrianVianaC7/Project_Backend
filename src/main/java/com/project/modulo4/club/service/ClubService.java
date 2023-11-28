package com.project.modulo4.club.service;

import com.project.modulo4.club.mapper.ClubMapper;
import com.project.modulo4.club.models.dto.ClubDTO;
import com.project.modulo4.club.models.model.ClubModel;
import com.project.modulo4.club.repository.ClubRepository;
import com.project.modulo4.league.mapper.LeagueMapper;
import com.project.modulo4.league.models.dto.LeagueDTO;
import com.project.modulo4.league.models.model.LeagueModel;
import com.project.modulo4.league.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    @Autowired
    ClubRepository clubRepository;
    @Autowired
    ClubMapper clubMapper;

    public List<ClubDTO> getAll() {
        List<ClubModel> clubs = clubRepository.getAll();
        return clubs.stream().map(x -> clubMapper.toDTO(x)).toList();
    }

    public ClubDTO getById(Long clubId) {
        Optional<ClubModel> clubOptional = clubRepository.getById(clubId);
        return clubOptional.map(x -> clubMapper.toDTO(x)).orElse(null);
    }
}
