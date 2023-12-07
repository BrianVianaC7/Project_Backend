package com.project.modulo4.repository.details;

import com.project.modulo4.models.details.club.ClubDetailsKey;
import com.project.modulo4.models.details.club.ClubDetailsModel;
import com.project.modulo4.models.league.model.LeagueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubDetailRepository extends JpaRepository<ClubDetailsModel, ClubDetailsKey> {

    @Query("SELECT cd.league FROM ClubDetailsModel cd WHERE cd.club.clubId = :clubId")
    List<LeagueModel> findLeagueByClub(long clubId);

}
