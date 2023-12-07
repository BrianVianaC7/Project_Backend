package com.project.modulo4.models.details.league;

import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.details.club.ClubDetailsKey;
import com.project.modulo4.models.league.model.LeagueModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "league_details")
public class LeagueDetailsModel {

    @EmbeddedId
    private ClubDetailsKey id;

    @ManyToOne
    @MapsId("leagueId")
    @JoinColumn(name = "league_id")
    private LeagueModel league;

    @ManyToOne
    @MapsId("clubId")
    @JoinColumn(name = "club_id")
    private ClubModel club;
}
