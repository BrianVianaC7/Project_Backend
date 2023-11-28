package com.project.modulo4.category.models.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CategoryModel {
    private long categoryId;
    private String categoryName;
    private String shortName;
}
