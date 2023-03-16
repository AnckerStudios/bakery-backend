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
    UUID category;
    //List<UUID> productBakeries;
    List<UUID> ingredients;



    public static Product toEntity(ProductPojo pojo){
        Product entity = new Product();
        entity.setId(pojo.getId());
        entity.setName(pojo.getName());
        Category addCategory = new Category();
        addCategory.setId(pojo.getCategory());
        entity.setCategory(addCategory);
        List<Ingredient> products = new ArrayList<>();
        entity.setIngredients(products);

        for(UUID uuid : pojo.getIngredients()){
            Ingredient ingredient = new Ingredient();
            ingredient.setId(uuid);
            products.add(ingredient);
        }
        return entity;
    }
    public static ProductPojo fromEntity(Product entity){
        ProductPojo pojo = new ProductPojo();
        pojo.setId(entity.getId());
        pojo.setName(entity.getName());
        pojo.setCategory(entity.getCategory().getId());
        List<UUID> ingredientPojos = new ArrayList<>();
        pojo.setIngredients(ingredientPojos);
        for(Ingredient ingredientPojo : entity.getIngredients()){
            ingredientPojos.add(ingredientPojo.getId());
        }
        return pojo;
    }
}
