package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.repository.ClubRepository;
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
        List<ClubModel> clubs = clubRepository.findAll();
        return clubs.stream().map(clubMapper::toDTO).toList();
    }

    public ClubDTO getById(Long clubId) {
        Optional<ClubModel> clubOptional = clubRepository.findById(clubId);
        return clubOptional.map(clubMapper::toDTO).orElse(null);
    }
}
