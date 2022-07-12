package com.assignment.backend.dto.response;

import java.util.Set;

public class CartResponseDto {
    private int id;
    Set<CartItemResponseDto> cartItems;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cartItems
     */
    public Set<CartItemResponseDto> getCartItems() {
        return cartItems;
    }

    /**
     * @param cartItems the cartItems to set
     */
    public void setCartItems(Set<CartItemResponseDto> cartItems) {
        this.cartItems = cartItems;
    }

    


}
