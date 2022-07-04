package com.assignment.backend.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.assignment.backend.dto.request.CartItemCreateDto;
import com.assignment.backend.dto.response.CartItemResponseDto;
import com.assignment.backend.dto.response.CartResponseDto;
import com.assignment.backend.dto.response.SuccessResponse;

public interface CartService {
    public List<CartItemResponseDto> getALlCart();

    public CartResponseDto getCartByAccount(int accId);

    public ResponseEntity<SuccessResponse> addProductToCart(CartItemCreateDto dto);

    public ResponseEntity<SuccessResponse> updateQuantityProduct(CartItemCreateDto dto);

    public ResponseEntity<SuccessResponse> deleteProductOutOfCart(int proId, int cartId);

}
