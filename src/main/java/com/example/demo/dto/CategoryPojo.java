package com.example.demo.dto;

import com.example.demo.entity.Bakery;
import com.example.demo.entity.Category;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CategoryPojo {
    UUID id;
    String name;
    boolean isDrink;
    public static Category toEntity(CategoryPojo pojo){
        Category entity = new Category();
        entity.setId(pojo.getId());
        entity.setName(pojo.getName());
        entity.setDrink(pojo.isDrink());
        return entity;
    }
    public static CategoryPojo fromEntity(Category entity){
        CategoryPojo pojo = new CategoryPojo();
        pojo.setId(entity.getId());
        pojo.setName(entity.getName());
        pojo.setDrink(entity.isDrink());
        return pojo;
    }
}
