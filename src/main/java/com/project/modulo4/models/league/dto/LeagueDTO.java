package com.project.modulo4.models.league.dto;


import com.project.modulo4.utils.types.CategoryType;
import lombok.*;

@Data
public class LeagueDTO {
    private long leagueId;
    private long nationId;
    private String leagueName;
    private CategoryType category;
    private String leagueImage;
}
