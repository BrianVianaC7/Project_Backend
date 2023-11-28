package com.project.modulo4.nation.mapper;

import com.project.modulo4.nation.models.dto.NationDTO;
import com.project.modulo4.nation.models.model.NationModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface NationMapper {
    NationDTO toDTO(NationModel nationModel);
}

