package com.assignment.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.backend.data.entities.Product;
import com.assignment.backend.dto.request.ProductCreateDto;
import com.assignment.backend.dto.response.ProductResponseDto;
import com.assignment.backend.dto.response.ProductSimpleResponseDto;
import com.assignment.backend.services.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Use this api for user
     * 
     * @return
     */
    @GetMapping("/category/all")
    public List<ProductSimpleResponseDto> getProductOnTrading() {
        return this.productService.getProductOnTrading();
    } 

    @GetMapping("/all")
    public List<ProductResponseDto> getAllProduct() {
        return this.productService.getAllProduct(); 
    } 

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") int id) {
        return this.productService.getProductById(id);
    }

    @GetMapping("/top")
    public List<Product> getProductByRate(){
        return this.productService.getProductByRate();
    }

    @GetMapping("/category/{cateId}")
    public List<ProductSimpleResponseDto> getProductByCategory(@PathVariable("cateId") int cate) {
        return this.productService.getProductByCategory(cate);
    }

    /**
     * Create new product
     * 
     * @param productData
     * @return
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createNewProduct(@RequestBody ProductCreateDto productData) {
        return this.productService.createNewProduct(productData);
    }

    /**
     * Change status of product
     * 
     * @param id
     * @return
     */
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto updateStatusProduct(@PathVariable("id") int id) {
        return this.productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto updateProduct(@PathVariable("id") int id,
            @RequestBody ProductCreateDto productCreateDto) {
        return this.productService.updateProduct(id, productCreateDto);
    }
}