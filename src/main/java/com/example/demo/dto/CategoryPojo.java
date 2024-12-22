package com.example.demo.dto;

import com.example.demo.entity.Bakery;
import com.example.demo.entity.Category;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


public class CategoryPojo {
    private UUID id;
    private String name;
    private boolean isDrink; // -> drink?????
    public static Category toEntity(CategoryPojo pojo){
        Category entity = new Category();
        entity.setId(pojo.getId());
        entity.setName(pojo.getName());
        entity.setIsDrink(pojo.getIsDrink());
        return entity;
    }
    public static CategoryPojo fromEntity(Category entity){
        CategoryPojo pojo = new CategoryPojo();
        pojo.setId(entity.getId());
        pojo.setName(entity.getName());
        pojo.setIsDrink(entity.getIsDrink());
        return pojo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsDrink() {
        return isDrink;
    }

    public void setIsDrink(boolean isDrink) {
        this.isDrink = isDrink;
    }
}
