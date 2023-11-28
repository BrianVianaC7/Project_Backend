package com.project.modulo4.league.repository;

import com.project.modulo4.league.models.model.LeagueModel;
import com.project.modulo4.nation.models.model.NationModel;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class LeagueRepository {

    private List<LeagueModel> leagueModelList;

    public LeagueRepository() {
        leagueModelList = new LinkedList<>();
    }

    public List<LeagueModel> getAll(){
        return leagueModelList;
    }

    public Optional<LeagueModel> getById(long leagueId) {
        return leagueModelList.stream()
                .filter(league -> league.getLeagueId() == leagueId)
                .findFirst();
    }

}
