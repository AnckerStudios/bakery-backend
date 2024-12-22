package com.example.demo.dto;

import com.example.demo.entity.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ProductPojo {

    private UUID id;
    private String name;
    private int volume;
    private CategoryPojo category;
    //List<UUID> productBakeries;
    private List<IngredientPojo> ingredients;


    public static Product toEntity(ProductPojo pojo){
        Product entity = new Product();
        entity.setId(pojo.getId());
        entity.setName(pojo.getName());
        entity.setCategory(CategoryPojo.toEntity(pojo.getCategory()));
        entity.setVolume(pojo.getVolume());
        List<IngredientProduct> products = new ArrayList<>();
        entity.setIngredientProducts(products);

        for(IngredientPojo ingredient : pojo.getIngredients()){
            IngredientProduct ingredientProduct = new IngredientProduct();
            ingredientProduct.setProduct(entity);
            ingredientProduct.setIngredient(IngredientPojo.toEntity(ingredient));
            products.add(ingredientProduct);
        }
        return entity;
    }
    public static ProductPojo fromEntity(Product entity){
        ProductPojo pojo = new ProductPojo();
        pojo.setId(entity.getId());
        pojo.setName(entity.getName());
        pojo.setCategory(CategoryPojo.fromEntity(entity.getCategory()));
        pojo.setVolume(entity.getVolume());
        List<IngredientPojo> ingredientPojos = new ArrayList<>();
        pojo.setIngredients(ingredientPojos);
        for(IngredientProduct ingredientPojo : entity.getIngredientProducts()){
            ingredientPojos.add(IngredientPojo.fromEntity(ingredientPojo.getIngredient()));
        }
        return pojo;
    }
}
