package com.project.modulo4.mapper.details;

import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.details.club.ClubDetailsModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClubDetailsMapper {

    @Mapping(source = "clubId", target = "id.clubId")
    @Mapping(source = "clubId", target = "club.clubId")
    @Mapping(source = "leagueId", target = "id.leagueId")
    @Mapping(source = "leagueId", target = "league.leagueId")
    ClubDetailsModel toModel(Long clubId, Long leagueId);

}
