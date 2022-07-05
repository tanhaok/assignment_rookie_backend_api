package com.assignment.backend.services;

import java.util.List;

import com.assignment.backend.dto.request.ProductRateCreateDto;
import com.assignment.backend.dto.response.MessageResponse;
import com.assignment.backend.dto.response.ProductRateResponseDto;

public interface ProductRateService {
    public MessageResponse createNewRate(ProductRateCreateDto dto);

    public List<ProductRateResponseDto> getRatesByProductId(int proId, boolean status);

    public MessageResponse changeStatus(int rateId);

}
