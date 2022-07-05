package com.assignment.backend.services;


import com.assignment.backend.dto.request.CartItemCreateDto;
import com.assignment.backend.dto.response.CartResponseDto;
import com.assignment.backend.dto.response.MessageResponse;

public interface CartService {
    /**
     * get cart is active for user have accId
     * 
     * @param accId id of user
     * @return cart and product into that
     */
    public CartResponseDto getCartByAccount(int accId);

    /**
     * Add new product to cart
     * 
     * @param dto include 3 param proId and cartId and quantity
     * @return success or error
     */
    public MessageResponse addProductToCart(CartItemCreateDto dto);

    public MessageResponse updateQuantityProduct(CartItemCreateDto dto);

    public MessageResponse deleteProductOutOfCart(int proId, int cartId);

}
