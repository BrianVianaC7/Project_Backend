package com.project.modulo4.club.mapper;

import com.project.modulo4.club.models.dto.ClubDTO;
import com.project.modulo4.club.models.model.ClubModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClubMapper {
    ClubDTO toDTO(ClubModel clubModel);

}
