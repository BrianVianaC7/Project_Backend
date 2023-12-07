package com.project.modulo4.mapper.details;

import com.project.modulo4.models.details.club.ClubDetailsModel;
import com.project.modulo4.models.details.league.LeagueDetailsModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LeagueDetailsMapper {

    @Mapping(source = "leagueId", target = "id.leagueId")
    @Mapping(source = "leagueId", target = "league.leagueId")
    @Mapping(source = "clubId", target = "id.clubId")
    @Mapping(source = "clubId", target = "club.clubId")
    LeagueDetailsModel toModel(Long leagueId, Long clubId);

}
