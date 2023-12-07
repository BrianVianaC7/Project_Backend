package com.project.modulo4.models.details.club;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ClubDetailsKey {

    @Column(name = "club_id")
    private long clubId;

    @Column(name = "league_id")
    private long leagueId;
}

