package com.project.modulo4.category.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CategoryDTO {
    private long categoryId;
    private String categoryName;
    private String shortName;

}
