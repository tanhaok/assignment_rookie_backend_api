package com.assignment.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.backend.data.entities.ProductImage;
import com.assignment.backend.data.repositories.ProductImageRepository;
import com.assignment.backend.services.ProductImageService;

public class ProductImageServiceImpl implements ProductImageService{

    private ProductImageRepository productImageRepository;

    @Autowired
    public ProductImageServiceImpl(ProductImageRepository repository){
        this.productImageRepository = repository;
    }

    @Override
    public ProductImage saveAllImageForProduct(ProductImage productImage) {
        return this.productImageRepository.save(productImage);
    }
    
}
