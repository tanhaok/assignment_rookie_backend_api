package com.assignment.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.backend.data.entities.Product;
import com.assignment.backend.data.entities.ProductImage;
import com.assignment.backend.dto.request.ProductCreateDto;
import com.assignment.backend.services.ProductImageService;
import com.assignment.backend.services.ProductService;
import com.assignment.backend.services.impl.ProductImageServiceImpl;
import com.assignment.backend.utils.Status;

@RestController
@RequestMapping("/product")
@CrossOrigin()
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
    public List<Product> getProductByStatus() {
        return this.productService.getProductByStatus();
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

    @PostMapping()
    public ResponseEntity<Boolean> createNewProduct(@RequestBody ProductCreateDto productData) {
        // create product and after that get id and save image
        // System.out.print(productData.getImages().length);

        Product newProduct = new Product();
        newProduct.setCreateDate();
        newProduct.setUpdateDate();
        // newProduct.setCategory(productData.getCategoryId());
        newProduct.setDescription(productData.getDescription());
        newProduct.setName(productData.getName());
        newProduct.setNumOfProduct(productData.getAmount());
        newProduct.setPrice(productData.getPrice());
        newProduct.setStatus(Status.PRODUCT_TRADING);

        Product saveProduct = this.productService.createNewProduct(newProduct);
        // int id = saveProduct.getProId();

        ProductImageService productImageService = new ProductImageService();

        for (String url : productData.getImages()) {
            ProductImage productImage = new ProductImage();
            productImage.setImgUrl(url);
            productImage.setProduct(saveProduct);
            productImage.setAlt("");
            productImageService.saveAllImageForProduct(productImage);
        }

        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

}