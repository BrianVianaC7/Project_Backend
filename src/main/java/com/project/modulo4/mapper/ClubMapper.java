package com.project.modulo4.mapper;

import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.league.model.LeagueModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClubMapper {
    ClubDTO toDTO(ClubModel clubModel);

    List<ClubDTO> toDTO(List<ClubModel> model);

}
