package com.project.modulo4.models.nation.dto;

import com.project.modulo4.models.league.dto.LeagueDTO;
import lombok.*;

@Data
public class NationDTO {
    private long nationId;
    private String nationName;
    private String shortName;
    private String nationImage;
}
