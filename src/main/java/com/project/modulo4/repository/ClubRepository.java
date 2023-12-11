package com.project.modulo4.repository;

import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.model.LeagueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<ClubModel, Long> {

    @Query("SELECT cd.league FROM ClubModel cd WHERE cd.clubId = :clubId")
    List<LeagueModel> findLeagueByClub(long clubId);

    @Query("SELECT MAX(cd.clubId) FROM ClubModel cd")
    Long findMaxClubId();
}
