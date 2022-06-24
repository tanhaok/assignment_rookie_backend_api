package com.assignment.backend.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.backend.data.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
