package com.project.modulo4.mapper;

import com.project.modulo4.models.player.dto.CreatePlayerDTO;
import com.project.modulo4.models.player.dto.PlayerDTO;
import com.project.modulo4.models.player.dto.UpdatePlayerDTO;
import com.project.modulo4.models.player.model.PlayerModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PlayerMapper {
    PlayerDTO toDTO(PlayerModel playerModel);

    //source objeto de entrada , target de salida
    @Mapping(target = "id", ignore = true)
    PlayerModel toModel(CreatePlayerDTO createPlayerDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "birthDate", ignore = true)
    @Mapping(target = "image", ignore = true)
    @Mapping(target = "preferredFoot", ignore = true)
    @Mapping(target = "height", ignore = true)
    @Mapping(target = "weight", ignore = true)
    PlayerModel updateToModel(UpdatePlayerDTO updatePlayerDTO, @MappingTarget PlayerModel playerModel);
}
