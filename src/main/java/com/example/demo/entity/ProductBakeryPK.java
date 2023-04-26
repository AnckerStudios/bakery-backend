package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ProductBakeryPK implements Serializable {
    //@Column(name = "bakery_id")
    private Bakery bakery;
    //@Column(name = "product_id")
    private Product product;



}
