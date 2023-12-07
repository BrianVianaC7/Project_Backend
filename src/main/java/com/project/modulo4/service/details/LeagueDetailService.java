package com.project.modulo4.service.details;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.LeagueMapper;
import com.project.modulo4.mapper.details.ClubDetailsMapper;
import com.project.modulo4.mapper.details.LeagueDetailsMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.repository.details.LeagueDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueDetailService {

    @Autowired
    private LeagueDetailRepository leagueDetailRepository;

    @Autowired
    private LeagueDetailsMapper leagueDetailsMapper;

    @Autowired
    private ClubMapper clubMapper;


    public List<ClubDTO> findClubsByLeague(long leagueId) {
        return clubMapper.toDTO(leagueDetailRepository.findClubsByLeague(leagueId));
    }


}
