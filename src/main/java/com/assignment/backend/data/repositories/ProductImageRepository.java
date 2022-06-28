package com.assignment.backend.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.backend.data.entities.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer>{
    
}
