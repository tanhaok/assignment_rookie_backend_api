package com.assignment.backend.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.backend.dto.request.ProductRateCreateDto;
import com.assignment.backend.dto.response.ProductRateResponseDto;
import com.assignment.backend.services.ProductRateService;

@RestController
@RequestMapping("/api/v1/rate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductRateController {

    @Autowired
    private ProductRateService productRateService;

    @PostMapping()
    public ResponseEntity<?> createNewRate(@Valid @RequestBody ProductRateCreateDto dto) {
        return this.productRateService.createNewRate(dto);
    }

    @GetMapping("/{id}")
    public List<ProductRateResponseDto> getProductRates(@PathVariable int id) {
        return this.productRateService.getRatesByProductId(id, true);
    }

    @GetMapping("/all/{id}")
    public List<ProductRateResponseDto> getAllProductRates(@PathVariable int id) {
        return this.productRateService.getRatesByProductId(id, false);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> changeStatusProductRate(@PathVariable int id) {
        return this.productRateService.changeStatus(id);
    }
}
