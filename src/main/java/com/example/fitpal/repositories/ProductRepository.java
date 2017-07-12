package com.example.fitpal.repositories;

import com.example.fitpal.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String productName);
    boolean existsByProductName(String productName);
}
