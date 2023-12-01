package com.project.modulo4.models.club.dto;


import com.project.modulo4.models.category.dto.CategoryDTO;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.nation.dto.NationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ClubDTO {
    private long clubId;
    private long leagueId;
    private long nationId;
    private long categoryId;
    private String clubName;
    private String clubShortName;
    private String stadium;
    private String clubImage;
}
