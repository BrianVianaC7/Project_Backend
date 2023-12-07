package com.project.modulo4.models.details.players;

import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.model.LeagueModel;
import com.project.modulo4.models.nation.model.NationModel;
import com.project.modulo4.models.player.model.PlayerModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "player_details")
public class PlayerDetailsModel {

    @EmbeddedId
    private PlayerDetailsKey id;

    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    private PlayerModel player;

    @ManyToOne
    @MapsId("nationId")
    @JoinColumn(name = "nation_id")
    private NationModel nation;


    @ManyToOne
    @MapsId("leagueId")
    @JoinColumn(name = "league_id")
    private LeagueModel league;

    @ManyToOne
    @MapsId("clubId")
    @JoinColumn(name = "club_id")
    private ClubModel clubModel;


}

