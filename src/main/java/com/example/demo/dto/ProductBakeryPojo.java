package com.example.demo.dto;

import com.example.demo.entity.Bakery;
import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductBakery;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductBakeryPojo {
    BakeryPojo bakery;
    ProductPojo product;
    int price;
    public static ProductBakery toEntity(ProductBakeryPojo pojo){
        ProductBakery entity = new ProductBakery();

        entity.setBakery(BakeryPojo.toEntity(pojo.getBakery()));
        entity.setProduct(ProductPojo.toEntity(pojo.getProduct()));
        entity.setPrice(pojo.getPrice());

        return entity;
    }
    public static ProductBakeryPojo fromEntity(ProductBakery entity){
        ProductBakeryPojo pojo = new ProductBakeryPojo();

        pojo.setBakery(BakeryPojo.fromEntity(entity.getBakery()));
        pojo.setProduct(ProductPojo.fromEntity(entity.getProduct()));
        pojo.setPrice(entity.getPrice());
        return pojo;
    }
}
