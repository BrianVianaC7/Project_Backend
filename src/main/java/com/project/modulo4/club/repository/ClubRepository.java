package com.project.modulo4.club.repository;

import com.project.modulo4.club.models.model.ClubModel;
import com.project.modulo4.league.models.model.LeagueModel;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClubRepository {

    private List<ClubModel> clubModelList;

    public ClubRepository() {
        clubModelList = new LinkedList<>();
    }

    public List<ClubModel> getAll(){
        return clubModelList;
    }

    public Optional<ClubModel> getById(long clubId) {
        return clubModelList.stream()
                .filter(club -> club.getClubId() == clubId)
                .findFirst();
    }

}
