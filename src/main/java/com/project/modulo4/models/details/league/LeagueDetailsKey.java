package com.project.modulo4.models.details.league;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class LeagueDetailsKey {


    @Column(name = "league_id")
    private long leagueId;

    @Column(name = "club_id")
    private long clubId;

}
