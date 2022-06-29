package com.assignment.backend.services;


import java.util.List;

import com.assignment.backend.data.entities.Category;
import com.assignment.backend.dto.request.CategoryCreateDto;
import com.assignment.backend.dto.response.CategoryResponseDto;


public interface CategoryService {
    public List<CategoryResponseDto > getAllCategory();
    public CategoryResponseDto createNewCategory(CategoryCreateDto dto);
    public CategoryResponseDto updateCategory(int id, CategoryCreateDto dto);
    public CategoryResponseDto updateCategoryStatus(int id);
    public Category getCategoryById(int id);
}
