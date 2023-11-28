package com.project.modulo4.nation.models.model;

import com.project.modulo4.league.models.model.LeagueModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NationModel {
    private long nationId;
    private long leagueId;
    private String nationName;
    private String shortName;
    private String nationImage;

}
