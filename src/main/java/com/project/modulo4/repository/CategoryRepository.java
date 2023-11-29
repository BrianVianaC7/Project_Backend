package com.project.modulo4.repository;

import com.project.modulo4.models.category.model.CategoryModel;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    private List<CategoryModel> categoryModelList;

    public CategoryRepository() {
        categoryModelList = new LinkedList<>();
    }

    public List<CategoryModel> getAll(){
        return categoryModelList;
    }

    public Optional<CategoryModel> getById(long categoryId) {
        return categoryModelList.stream()
                .filter(category -> category.getCategoryId() == categoryId)
                .findFirst();
    }


}
