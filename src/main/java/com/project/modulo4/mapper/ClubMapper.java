package com.project.modulo4.mapper;

import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.league.model.LeagueModel;
import com.project.modulo4.models.player.dto.CreatePlayerDTO;
import com.project.modulo4.models.player.model.PlayerModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClubMapper {
    ClubDTO toDTO(ClubModel clubModel);

    @Mapping(target = "clubId", ignore = true)
    @Mapping(target = "league", ignore = true)
    ClubModel toModel(CreateClubDTO createClubDTO);
    List<ClubDTO> toDTO(List<ClubModel> model);

}
