package com.example.demo.dto;

import com.example.demo.entity.Category;
import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductBakery;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ProductPojo {

    UUID id;
    String name;
    int volume;
    CategoryPojo category;
    //List<UUID> productBakeries;
    List<IngredientPojo> ingredients;


    public static Product toEntity(ProductPojo pojo){
        Product entity = new Product();
        entity.setId(pojo.getId());
        entity.setName(pojo.getName());
        entity.setCategory(CategoryPojo.toEntity(pojo.getCategory()));
        List<Ingredient> products = new ArrayList<>();
        entity.setIngredients(products);
        entity.setVolume(pojo.getVolume());
        for(IngredientPojo ingredient : pojo.getIngredients()){
            products.add(IngredientPojo.toEntity(ingredient));
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
        for(Ingredient ingredientPojo : entity.getIngredients()){
            ingredientPojos.add(IngredientPojo.fromEntity(ingredientPojo));
        }
        return pojo;
    }
}
