package com.assignment.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.backend.data.entities.Product;
import com.assignment.backend.data.repositories.ProductRepository;
import com.assignment.backend.exceptions.ResourceNotFoundException;
import com.assignment.backend.services.ProductService;
import com.assignment.backend.utils.Message;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> productOptional =  this.productRepository.findById(id);
        if(productOptional.isPresent()){
            Product product  = productOptional.get();
            return product;
        }
        throw new  ResourceNotFoundException(Message.PRODUCT_NOT_FOUND);
    }
    @Override
    public List<Product> getProductByRate() {
        return null;
    }
    @Override
    public List<Product> getProductByCategory(String category) {
        return null;
    }
    
	@Override
	public List<Product> getProduct() {
        return null;
	}
    
}
