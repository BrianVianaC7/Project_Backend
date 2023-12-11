package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.LeagueMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.repository.ClubRepository;
import jakarta.transaction.Transactional;
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

    @Autowired
    private LeagueMapper leagueMapper;

    @Autowired
    private NationService nationService;

    @Autowired
    private LeagueService leagueService;

    public List<ClubDTO> getAll() {
        List<ClubModel> clubs = clubRepository.findAll();
        return clubs.stream().map(clubMapper::toDTO).toList();
    }

    public ClubDTO getById(Long clubId) {
        Optional<ClubModel> clubOptional = clubRepository.findById(clubId);
        return clubOptional.map(clubMapper::toDTO).orElse(null);
    }

    @Transactional
    public ClubDTO createClub(CreateClubDTO createClubDTO, Long leagueId) {
        LeagueDTO leagueDTO = leagueService.getById(leagueId);
        if (leagueDTO == null) {
            throw new RuntimeException("Liga no encontrada");
        }

        ClubModel clubModel = clubMapper.toModel(createClubDTO);
        clubModel.setLeague(leagueMapper.toModel(leagueDTO));
        // Obtienes el próximo ID disponible manualmente
        Long nextId = clubRepository.findMaxClubId() + 1;
        clubModel.setClubId(nextId);
        clubModel = clubRepository.save(clubModel);

        return clubMapper.toDTO(clubModel);
    }
}
