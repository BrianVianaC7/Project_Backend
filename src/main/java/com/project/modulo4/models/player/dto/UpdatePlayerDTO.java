package com.project.modulo4.models.player.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdatePlayerDTO {
    private String name;
    private String longName;
    private long categoryId;
    private int numberJersey;
    private long nationId;
    private long leagueId;
    private long clubTeamId;
    private String position;
}
