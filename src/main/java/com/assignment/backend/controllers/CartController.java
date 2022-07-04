package com.assignment.backend.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.backend.dto.request.CartItemCreateDto;
import com.assignment.backend.dto.response.CartItemResponseDto;
import com.assignment.backend.dto.response.CartResponseDto;
import com.assignment.backend.dto.response.SuccessResponse;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/api/v1/cart")
public class CartController {

    /**
     * just for admin
     * 
     * @return
     */
    @GetMapping("/all")
    public List<CartItemResponseDto> getAllCart() {
        return null;
    }

    /**
     * for user get all
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CartResponseDto getCartByAccount(@PathVariable int id) {
        return null;
    }

    @PostMapping()
    public ResponseEntity<SuccessResponse> addProductIntoCart(@RequestBody CartItemCreateDto dto) {
        return null;
    }

    @PutMapping()
    public ResponseEntity<SuccessResponse> updateQuantityProduct(@RequestBody CartItemCreateDto dto) {
        return null;
    }

    @PatchMapping()
    public ResponseEntity<SuccessResponse> deleteProductOutOfCart(int proId, int cartId) {
        return null;
    }

}

/**
 * after login -> check cart for user
 * if exist cart for user and is active return cart id, and product into cart
 * save it in local Storage
 * if not exist and not have any cart is active create cart and return -> save
 * in localStorage
 */
