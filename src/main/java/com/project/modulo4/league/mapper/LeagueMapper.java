package com.project.modulo4.league.mapper;

import com.project.modulo4.league.models.dto.LeagueDTO;
import com.project.modulo4.league.models.model.LeagueModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LeagueMapper {
    LeagueDTO toDTO(LeagueModel leagueModel);
}
