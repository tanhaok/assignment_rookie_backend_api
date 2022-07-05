package com.assignment.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.assignment.backend.data.repositories.ProductImageRepository;
import com.assignment.backend.dto.response.MessageResponse;
import com.assignment.backend.services.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService{
    @Autowired
    private ProductImageRepository productImageRepository;


    @Override
    public MessageResponse deleteImage(int id) {
        this.productImageRepository.deleteById(id);
        return new MessageResponse(HttpStatus.ACCEPTED, "Delete Image Successfully");

    }

    
}
