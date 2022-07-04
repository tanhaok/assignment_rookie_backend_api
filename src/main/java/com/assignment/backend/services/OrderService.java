package com.assignment.backend.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.assignment.backend.dto.request.OrderCreateDto;
import com.assignment.backend.dto.response.OrderResponseDto;

public interface OrderService {
    public ResponseEntity<?> createNewOrder(OrderCreateDto dto);

    public List<OrderResponseDto> getAllOrderByAccId(int id);

    public List<OrderResponseDto> getAllOrder();

    public ResponseEntity<?> updateStatusOrder(int orderId, String status);
    
}
