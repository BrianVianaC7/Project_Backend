package com.project.modulo4.mapper;

import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.league.model.LeagueModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LeagueMapper {
    LeagueDTO toDTO(LeagueModel leagueModel);

    List<LeagueDTO> toDTO(List<LeagueModel> model);

    LeagueModel toModel(LeagueDTO leagueDTO);
}
