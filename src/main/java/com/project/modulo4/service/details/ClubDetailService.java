package com.project.modulo4.service.details;

import com.project.modulo4.mapper.LeagueMapper;
import com.project.modulo4.mapper.details.ClubDetailsMapper;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.repository.details.ClubDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubDetailService {

    @Autowired
    private ClubDetailRepository clubDetailRepository;

    @Autowired
    private ClubDetailsMapper clubDetailsMapper;

    @Autowired
    private LeagueMapper leagueMapper;

    public void addLeague(long clubId, long leagueId) {
        clubDetailRepository.save(clubDetailsMapper.toModel(clubId, leagueId));
    }

    public List<LeagueDTO> findLeagueByClub(long clubId) {
        return leagueMapper.toDTO(clubDetailRepository.findLeagueByClub(clubId));
    }

}
