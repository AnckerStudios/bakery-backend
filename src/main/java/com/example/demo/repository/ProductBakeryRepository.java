package com.example.demo.repository;

import com.example.demo.entity.ProductBakery;
import com.example.demo.entity.ProductBakeryPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductBakeryRepository extends JpaRepository<ProductBakery, ProductBakeryPK> {
    List<ProductBakery> findByBakery_Id(UUID uuid);
}
