package com.assignment.backend.data.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.backend.data.entities.Product;
import com.assignment.backend.data.entities.ProductRate;

@Repository
public interface ProductRateRepository extends JpaRepository<ProductRate, Integer> {
    List<ProductRate> findByStatus(boolean status);

    Optional<ProductRate> findByAccIdAndProduct(int accId, Product optional);
}
