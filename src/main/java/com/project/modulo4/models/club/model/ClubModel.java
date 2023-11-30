package com.project.modulo4.models.club.model;

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
public class ClubModel {
    private long clubId;
    private LeagueDTO leagueId;
    private NationDTO nationId;
    private CategoryDTO categoryId;
    private String clubName;
    private String clubShortName;
    private String stadium;
    private String clubImage;
}
