package com.project.modulo4.mapper;

import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.dto.UpdateClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClubMapper {
    ClubDTO toDTO(ClubModel clubModel);

    @Mapping(target = "clubId", ignore = true)
    @Mapping(target = "league", ignore = true)
    ClubModel toModel(CreateClubDTO createClubDTO);

    @Mapping(target = "clubId", ignore = true)
    @Mapping(target = "league", ignore = true)
    ClubModel updateToModel(UpdateClubDTO updateClubDTO, @MappingTarget ClubModel clubModel);

    ClubModel toModel(ClubDTO clubDTO);

    List<ClubDTO> toDTO(List<ClubModel> model);

}
