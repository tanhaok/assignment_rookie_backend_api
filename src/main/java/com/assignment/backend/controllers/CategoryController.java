package com.assignment.backend.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.backend.data.entities.Category;
import com.assignment.backend.dto.request.CategoryCreateDto;
import com.assignment.backend.dto.response.CategoryResponseDto;
import com.assignment.backend.services.CategoryService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService service) {
        this.categoryService = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDto createNewCategory(@Valid @RequestBody CategoryCreateDto dto) {
        return this.categoryService.createNewCategory(dto);
    }

    @PutMapping("/{id}")
    public CategoryResponseDto updateCategory(@Valid @RequestBody CategoryCreateDto dto, @PathVariable("id") int id) {
        return this.categoryService.updateCategory(id, dto);
    }

    @PatchMapping("/{id}")
    public CategoryResponseDto updateStatusCategory(@PathVariable("id") int id) {
        return this.categoryService.updateCategoryStatus(id);
    }

    @GetMapping()
    public List<Category> getAllCategory() {
        return this.categoryService.getAllCategory();
    }

}
