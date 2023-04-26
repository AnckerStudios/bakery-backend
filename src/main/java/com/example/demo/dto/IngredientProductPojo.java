package com.example.demo.dto;

import com.example.demo.entity.IngredientProduct;
import com.example.demo.entity.ProductBakery;
import lombok.Data;

@Data
public class IngredientProductPojo {
    private IngredientPojo ingredient;
    private ProductPojo product;
    public static IngredientProduct toEntity(IngredientProductPojo pojo){
        IngredientProduct entity = new IngredientProduct();

        entity.setIngredient(IngredientPojo.toEntity(pojo.getIngredient()));
        entity.setProduct(ProductPojo.toEntity(pojo.getProduct()));


        return entity;
    }
    public static IngredientProductPojo fromEntity(IngredientProduct entity){
        IngredientProductPojo pojo = new IngredientProductPojo();

        pojo.setIngredient(IngredientPojo.fromEntity(entity.getIngredient()));
        pojo.setProduct(ProductPojo.fromEntity(entity.getProduct()));

        return pojo;
    }
}
