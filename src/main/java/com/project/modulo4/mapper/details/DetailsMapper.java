package com.project.modulo4.mapper.details;

import com.project.modulo4.models.club.model.ClubModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DetailsMapper {

    @Mapping(source = "clubId", target = "clubId")
    @Mapping(source = "leagueId", target = "league.leagueId")
    ClubModel toModelClub(Long clubId, Long leagueId);

    @Mapping(source = "leagueId", target = "league.leagueId")
    @Mapping(source = "clubId", target = "clubId")
    ClubModel toModelLeague(Long leagueId, Long clubId);
}

