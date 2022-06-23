package com.assignment.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.assignment.backend.data.entities.Product;
import com.assignment.backend.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // TODO:change data return is dto, only get necessary fields

    /** **********************************************************************
     * * Have 5 type of method get * * 
     * 1/ get all product when status = true => show in home, product page for user 
     * 2/ get all product by category: filter - user function
     * 3/ get product by rate: filter - user function 
     * 4/ get product by id: use this function for all user(user, admin) when click on product
     * 5/ get all product: admin function 
     * **********************************************************************
     */

    @GetMapping()
    public List<Product> getProduct(){
        return this.productService.getProduct(); 
    } 

    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return this.productService.getAllProduct(); 
    } 

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int id){
        return this.getProductById(id);
    }

    @GetMapping("/top")
    public List<Product> getProductByRate(){
        return this.productService.getProductByRate();
    }

    @GetMapping("/{category}")
    public List<Product> getProductByCategory(@PathVariable("category") String cate){
        return this.productService.getProductByCategory(cate);
    }

    /**
     * POST method
     */

     
}
