package com.assignment.backend.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.assignment.backend.data.entities.ProductRate;
import com.assignment.backend.dto.request.ProductRateCreateDto;
import com.assignment.backend.dto.response.ProductRateResponseDto;

public interface ProductRateService {
    public ResponseEntity<?> createNewRate(ProductRateCreateDto dto);

    public List<ProductRateResponseDto> getRatesByProductId(int proId, boolean status);

    public ResponseEntity<?> changeStatus(int rateId);

}
