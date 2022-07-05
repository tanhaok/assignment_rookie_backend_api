package com.assignment.backend.services;

import java.util.List;

import com.assignment.backend.dto.request.OrderCreateDto;
import com.assignment.backend.dto.response.MessageResponse;
import com.assignment.backend.dto.response.OrderResponseDto;

public interface OrderService {
    public MessageResponse createNewOrder(OrderCreateDto dto);

    public List<OrderResponseDto> getAllOrderByAccId(int id);

    public List<OrderResponseDto> getAllOrder();

    public MessageResponse updateStatusOrder(int orderId, String status);
    
}
