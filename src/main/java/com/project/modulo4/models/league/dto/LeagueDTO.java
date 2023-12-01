package com.project.modulo4.models.league.dto;


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
public class LeagueDTO {

    private long leagueId;
    private long nationId;
    private String leagueName;
    private long categoryId;
    private String leagueImage;

}
