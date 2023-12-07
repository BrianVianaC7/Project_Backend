package com.project.modulo4.models.details.players;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PlayerDetailsKey {

    @Column(name = "player_id")
    private long playerId;

    @Column(name = "nation_id")
    private long nationId;

    @Column(name = "league_id")
    private long leagueId;

    @Column(name = "club_id")
    private long clubId;

}
