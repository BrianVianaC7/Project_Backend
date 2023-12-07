package com.project.modulo4.controller;

import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.details.club.ClubDetailsDTO;
import com.project.modulo4.service.ClubService;
import com.project.modulo4.service.details.ClubDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;
    @Autowired
    private ClubDetailService clubDetailService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClubDTO> getAll() {
        return clubService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClubDTO> getClubById(@PathVariable Long id) {
        ClubDTO club = clubService.getById(id);
        if (club != null) {
            return ResponseEntity.ok(club);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{clubId}/leagues")
    @ResponseStatus(HttpStatus.OK)
    public void addLeague(@PathVariable long clubId, @RequestBody ClubDetailsDTO clubDetailsDTO) {
        clubDetailService.addLeague(clubId, clubDetailsDTO.getLeagueId());
    }


}
