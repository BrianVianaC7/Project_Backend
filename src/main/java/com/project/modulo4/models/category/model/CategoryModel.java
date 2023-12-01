package com.project.modulo4.models.category.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "category_table")
public class CategoryModel {
    @Id
    private long categoryId;
    @Column(nullable = false, length = 50)
    private String categoryName;
    @Column(nullable = false, length = 5)
    private String shortName;
}
