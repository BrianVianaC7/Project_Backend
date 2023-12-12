package com.project.modulo4.repository;

import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.model.LeagueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LeagueRepository extends JpaRepository<LeagueModel, Long> {

    @Query("SELECT ld FROM ClubModel ld WHERE ld.league.leagueId = :leagueId")
    List<ClubModel> findClubsByLeague(long leagueId);

}
