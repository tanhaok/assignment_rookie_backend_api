package com.assignment.backend.services;

import java.util.List;

import com.assignment.backend.data.entities.Product;

public interface ProductService {

    /**
     * get all product when status = true
     * @return list of product
     */
    public List<Product> getProductByStatus();

    /**
     * get all product do not consider any conditions
     * @return list of product
     */
    public List<Product> getAllProduct();

    
    public Product getProductById(int id);

    public List<Product> getProductByRate();

    public List<Product> getProductByCategory(String category);

    public Product createNewProduct(Product product);

}
