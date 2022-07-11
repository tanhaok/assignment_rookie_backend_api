package com.assignment.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.backend.dto.response.MessageResponse;
import com.assignment.backend.services.ProductImageService;

@RestController
@RequestMapping("/api/v1/image")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductImageController {
    
    @Autowired
    private ProductImageService productImageService;

    @DeleteMapping("/{id}")
    public MessageResponse deleteImage(@PathVariable("id") int id) {
        return this.productImageService.deleteImage(id);
    }

}
