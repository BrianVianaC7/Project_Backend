package com.project.modulo4.models.league.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LeagueDTO {

    private long leagueId;
    private long nationId;
    private String leagueName;
    private long categoryId;
    private String leagueImage;

}
