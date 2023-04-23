package com.example.demo.repository;

import com.example.demo.dto.ProductPojo;
import com.example.demo.entity.Bakery;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query(value = "SELECT * FROM product WHERE id NOT IN (SELECT product_id FROM product_bakery WHERE bakery_id = ?1)",nativeQuery = true)
    List<Product> getProductNotBakery(UUID bakeryId);
}
