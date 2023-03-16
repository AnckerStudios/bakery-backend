package com.example.demo.dto;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Product;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class IngredientPojo {
    UUID id;
    String name;

    public static Ingredient toEntity(IngredientPojo pojo){
        Ingredient entity = new Ingredient();
        entity.setId(pojo.getId());
        entity.setName(pojo.getName());
        return entity;
    }
    public static IngredientPojo fromEntity(Ingredient entity){
        IngredientPojo pojo = new IngredientPojo();
        pojo.setId(entity.getId());
        pojo.setName(entity.getName());
        return pojo;
    }
}
