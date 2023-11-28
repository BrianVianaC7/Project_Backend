package com.project.modulo4.nation.models.dto;

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
    private long leagueId;
    private String nationName;
    private String shortName;
    private String nationImage;
}
