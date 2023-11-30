package com.project.modulo4.models.nation.dto;

import com.project.modulo4.models.league.dto.LeagueDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NationDTO {
    private long nationId;
    private LeagueDTO leagueId;
    private String nationName;
    private String shortName;
    private String nationImage;
}
