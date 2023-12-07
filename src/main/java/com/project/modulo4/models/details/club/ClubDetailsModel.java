package com.project.modulo4.models.details.club;

import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.model.LeagueModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "club_details")
public class ClubDetailsModel {

    @EmbeddedId
    private ClubDetailsKey id;


    @ManyToOne
    @MapsId("clubId")
    @JoinColumn(name = "club_id")
    private ClubModel club;

    @ManyToOne
    @MapsId("leagueId")
    @JoinColumn(name = "league_id")
    private LeagueModel league;

}
