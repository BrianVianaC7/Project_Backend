package com.project.modulo4.mapper;

import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.league.model.LeagueModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LeagueMapper {
    LeagueDTO toDTO(LeagueModel leagueModel);
}
