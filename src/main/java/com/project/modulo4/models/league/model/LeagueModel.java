package com.project.modulo4.models.league.model;


import com.project.modulo4.models.category.dto.CategoryDTO;
import com.project.modulo4.models.nation.dto.NationDTO;
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
    private NationDTO nationId;
    private String leagueName;
    private CategoryDTO categoryId;
    private String leagueImage;
}
