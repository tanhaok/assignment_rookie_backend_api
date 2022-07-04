package com.assignment.backend.dto.response;

import com.assignment.backend.data.entities.Product;

public class ProductItemResponseDto {
    private int proId;
    private String name;
    private double price;
    private int quantity;

    

    /**
     * 
     */
    public ProductItemResponseDto() {
    }

    public ProductItemResponseDto(int id, String name, double price, int quantity) {
        this.proId = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductItemResponseDto build(Product pro, int quantity) {
        return new ProductItemResponseDto(pro.getProId(), pro.getName(), pro.getPrice(), quantity);
    }
}
