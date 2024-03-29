package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.LeagueMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.dto.UpdateClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.repository.ClubRepository;
import com.project.modulo4.utils.exception.ClubNotFoundException;
import com.project.modulo4.utils.exception.LeagueNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    final
    ClubRepository clubRepository;
    final
    ClubMapper clubMapper;

    private final LeagueMapper leagueMapper;

    private final NationService nationService;

    private final LeagueService leagueService;

    public ClubService(ClubRepository clubRepository, ClubMapper clubMapper, LeagueMapper leagueMapper, NationService nationService, LeagueService leagueService) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
        this.leagueMapper = leagueMapper;
        this.nationService = nationService;
        this.leagueService = leagueService;
    }

    public List<ClubDTO> getAll() {
        List<ClubModel> clubs = clubRepository.findAll();
        return clubs.stream().map(clubMapper::toDTO).toList();
    }

    public ClubDTO getById(Long clubId) throws ClubNotFoundException {
        Optional<ClubModel> clubOptional = clubRepository.findById(clubId);
        return clubOptional.map(clubMapper::toDTO).orElse(null);
    }

    @Transactional
    public ClubDTO createClub(CreateClubDTO createClubDTO, Long leagueId) throws LeagueNotFoundException {
        LeagueDTO leagueDTO = leagueService.getById(leagueId);
        if (leagueDTO == null) {
            throw new LeagueNotFoundException(leagueId);
        }

        ClubModel clubModel = clubMapper.toModel(createClubDTO);
        clubModel.setLeague(leagueMapper.toModel(leagueDTO));
        // Obtienes el próximo ID disponible manualmente
        Long nextId = clubRepository.findMaxClubId() + 1;
        clubModel.setClubId(nextId);
        clubModel = clubRepository.save(clubModel);

        return clubMapper.toDTO(clubModel);
    }


    public ClubDTO updateClub(Long clubId, UpdateClubDTO updateClubDTO) throws ClubNotFoundException {
        Optional<ClubModel> clubOptional = clubRepository.findById(clubId);
        if (clubOptional.isPresent()) {
            ClubModel existingClub = clubOptional.get();
            clubMapper.updateToModel(updateClubDTO, existingClub);
            ClubModel updatedClub = clubRepository.save(existingClub);
            return clubMapper.toDTO(updatedClub);
        } else {
             throw new ClubNotFoundException(clubId);
        }
    }

}
