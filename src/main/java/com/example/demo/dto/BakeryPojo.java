package com.example.demo.dto;

import com.example.demo.entity.*;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class BakeryPojo {
    private UUID id;
    private String address;
    private String name;
    //List<BakeryCategoryPojo> bakeryCategoryPojos;

    public static Bakery toEntity(BakeryPojo pojo){
        Bakery entity = new Bakery();
        entity.setId(pojo.getId());
        entity.setAddress(pojo.getAddress());
        entity.setName(pojo.getName());
//        List<BakeryCategory> categories = new ArrayList<>();
//        entity.setBakeryCategories(categories);
//        for(BakeryCategoryPojo category : pojo.getBakeryCategoryPojos()){
//            categories.add(BakeryCategoryPojo.toEntity(category));
//        }
        return entity;
    }
    public static BakeryPojo fromEntity(Bakery entity){
        BakeryPojo pojo = new BakeryPojo();
        pojo.setId(entity.getId());
        pojo.setAddress(entity.getAddress());
        pojo.setName(entity.getName());
//        List<BakeryCategoryPojo> categories = new ArrayList<>();
//        pojo.setBakeryCategoryPojos(categories);
//        for(BakeryCategory bakeryCategory : entity.getBakeryCategories()){
//            categories.add(BakeryCategoryPojo.fromEntity(bakeryCategory));
//        }
        return pojo;
    }
}
