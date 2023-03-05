package com.easyops.easyops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyops.easyops.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}