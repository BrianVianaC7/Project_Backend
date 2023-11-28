package com.project.modulo4.mapper;

import com.project.modulo4.models.dao.CreatePlayerDTO;
import com.project.modulo4.models.dao.PlayerDTO;
import com.project.modulo4.models.dao.UpdatePlayerDTO;
import com.project.modulo4.models.model.PlayerModel;
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
    @Mapping(target = "age", ignore = true)
    @Mapping(target = "image", ignore = true)
    PlayerModel updateToModel(UpdatePlayerDTO updatePlayerDTO, @MappingTarget PlayerModel playerModel);
}
