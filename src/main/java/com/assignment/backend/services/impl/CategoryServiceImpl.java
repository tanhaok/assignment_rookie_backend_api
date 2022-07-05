package com.assignment.backend.services.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.backend.data.entities.Category;
import com.assignment.backend.data.repositories.CategoryRepository;
import com.assignment.backend.dto.request.CategoryCreateDto;
import com.assignment.backend.dto.response.CategoryResponseDto;
import com.assignment.backend.exceptions.ResourceNotFoundException;
import com.assignment.backend.services.CategoryService;
import com.assignment.backend.utils.Utils;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository cRepository, ModelMapper mapper) {
        this.categoryRepository = cRepository;
        this.modelMapper = mapper;
    }

    @Override
    public CategoryResponseDto createNewCategory(CategoryCreateDto dto) {
        Category category = modelMapper.map(dto, Category.class);
        category.setStatus(Utils.CATEGORY_ACTIVE);
        Category saveCategory = this.categoryRepository.save(category);
        return modelMapper.map(saveCategory, CategoryResponseDto.class);
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        List<Category> lCategories = this.categoryRepository.findAll();
        List<CategoryResponseDto> result = new ArrayList<>();
        for (Category cate : lCategories) {
            result.add(this.modelMapper.map(cate, CategoryResponseDto.class));
        }
        return result;
    }

    @Override
    public CategoryResponseDto updateCategory(int id, CategoryCreateDto dto) {
        Optional<Category> categoRyOptional = this.categoryRepository.findById(id);
        if (categoRyOptional.isEmpty()) {
            throw new ResourceNotFoundException("CATEGORY DOES NOT EXIST");
        }

        Category category = categoRyOptional.get();
        modelMapper.map(dto, category);
        category.setUpdateDate();
        category = this.categoryRepository.save(category);
        return modelMapper.map(category, CategoryResponseDto.class);
    }

    @Override
    public CategoryResponseDto updateCategoryStatus(int id) {
        Optional<Category> categoryOptional = this.categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new ResourceNotFoundException("CATEGORY DOES NOT EXIST");
        }

        Category category = categoryOptional.get();
        if ("Active".equals(category.getStatus())) {
            category.setStatus(Utils.CATEGORY_DEACTIVATE);
        } else {
            category.setStatus(Utils.CATEGORY_ACTIVE);
        }

        category.setUpdateDate();
        category = this.categoryRepository.save(category);
        return modelMapper.map(category, CategoryResponseDto.class);
    }

    @Override
    public Category getCategoryById(int id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }
}
