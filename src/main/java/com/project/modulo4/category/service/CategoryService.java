package com.project.modulo4.category.service;

import com.project.modulo4.category.mapper.CategoryMapper;
import com.project.modulo4.category.models.dto.CategoryDTO;
import com.project.modulo4.category.models.model.CategoryModel;
import com.project.modulo4.category.repository.CategoryRepository;
import com.project.modulo4.club.mapper.ClubMapper;
import com.project.modulo4.club.models.dto.ClubDTO;
import com.project.modulo4.club.models.model.ClubModel;
import com.project.modulo4.club.repository.ClubRepository;
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
        List<CategoryModel> category = categoryRepository.getAll();
        return category.stream().map(x -> categoryMapper.toDTO(x)).toList();
    }

    public CategoryDTO getById(Long categoryId) {
        Optional<CategoryModel> categoryOptional = categoryRepository.getById(categoryId);
        return categoryOptional.map(x -> categoryMapper.toDTO(x)).orElse(null);
    }
}

