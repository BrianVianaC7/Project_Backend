package com.project.modulo4.service;

import com.project.modulo4.mapper.CategoryMapper;
import com.project.modulo4.models.category.dto.CategoryDTO;
import com.project.modulo4.models.category.model.CategoryModel;
import com.project.modulo4.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryMapper categoryMapper;

    public List<CategoryDTO> getAll() {
        List<CategoryModel> category = categoryRepository.findAll();
        return category.stream().map(categoryMapper::toDTO).toList();
    }

    public CategoryDTO getById(Long categoryId) {
        Optional<CategoryModel> categoryOptional = categoryRepository.findById(categoryId);
        return categoryOptional.map(categoryMapper::toDTO).orElse(null);
    }
}

