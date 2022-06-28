package com.assignment.backend.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.backend.data.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
