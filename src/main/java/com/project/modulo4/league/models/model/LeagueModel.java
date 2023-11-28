package com.project.modulo4.league.models.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LeagueModel {
    private long leagueId;
    private long nationId;
    private String leagueName;
    private long categoryId;
    private String leagueImage;
}
