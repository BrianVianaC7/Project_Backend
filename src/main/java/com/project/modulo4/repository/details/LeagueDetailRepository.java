package com.project.modulo4.repository.details;

import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.details.league.LeagueDetailsKey;
import com.project.modulo4.models.details.league.LeagueDetailsModel;
import com.project.modulo4.models.league.model.LeagueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueDetailRepository extends JpaRepository<LeagueDetailsModel, LeagueDetailsKey> {

    @Query("SELECT ld.club FROM LeagueDetailsModel ld WHERE ld.league.leagueId = :leagueId")
    List<ClubModel> findClubsByLeague(long clubId);

}
