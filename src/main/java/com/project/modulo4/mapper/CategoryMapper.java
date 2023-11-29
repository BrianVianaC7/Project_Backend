package com.project.modulo4.mapper;

import com.project.modulo4.models.category.dto.CategoryDTO;
import com.project.modulo4.models.category.model.CategoryModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper {
    CategoryDTO toDTO(CategoryModel categoryModel);
}
