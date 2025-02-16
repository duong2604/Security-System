package com.duongvb.SecuritySystem.repository;

import com.duongvb.SecuritySystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
