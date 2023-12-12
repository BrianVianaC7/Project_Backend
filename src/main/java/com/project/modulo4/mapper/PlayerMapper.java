package com.project.modulo4.mapper;

import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.league.model.LeagueModel;
import com.project.modulo4.models.player.dto.CreatePlayerDTO;
import com.project.modulo4.models.player.dto.PlayerDTO;
import com.project.modulo4.models.player.dto.UpdatePlayerDTO;
import com.project.modulo4.models.player.model.PlayerModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlayerMapper {
    PlayerDTO toDTO(PlayerModel playerModel);

    //source objeto de entrada , target de salida
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nation", ignore = true)
    @Mapping(target = "club", ignore = true)
    PlayerModel toModel(CreatePlayerDTO createPlayerDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "birthDate", ignore = true)
    @Mapping(target = "nation", ignore = true)
    @Mapping(target = "club", ignore = true)
    @Mapping(target = "image", ignore = true)
    @Mapping(target = "preferredFoot", ignore = true)
    @Mapping(target = "height", ignore = true)
    @Mapping(target = "weight", ignore = true)
    PlayerModel updateToModel(UpdatePlayerDTO updatePlayerDTO, @MappingTarget PlayerModel playerModel);
}
