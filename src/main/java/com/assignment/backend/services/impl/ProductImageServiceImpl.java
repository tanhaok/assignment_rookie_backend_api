package com.assignment.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignment.backend.data.entities.ProductImage;
import com.assignment.backend.data.repositories.ProductImageRepository;
import com.assignment.backend.services.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService{

    private ProductImageRepository productImageRepository;

    @Autowired
    public ProductImageServiceImpl(ProductImageRepository repository){
        this.productImageRepository = repository;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteImage(int id) {
        this.productImageRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    
}
