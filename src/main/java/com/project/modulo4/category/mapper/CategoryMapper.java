package com.project.modulo4.category.mapper;

import com.project.modulo4.category.models.dto.CategoryDTO;
import com.project.modulo4.category.models.model.CategoryModel;
import com.project.modulo4.club.models.dto.ClubDTO;
import com.project.modulo4.club.models.model.ClubModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper {
    CategoryDTO toDTO(CategoryModel categoryModel);
}
