package com.assignment.backend.data.repositories;

import org.springframework.stereotype.Repository;
import com.assignment.backend.data.entities.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);
    List<Product> getProductByRate();
    List<Product> findByStatusTrue();
}
