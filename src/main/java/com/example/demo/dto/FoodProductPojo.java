//package com.example.demo.dto;
//
//import com.example.demo.entity.*;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.ManyToOne;
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//public class FoodProductPojo extends ProductPojo{
//    int weight;
//    private FoodTypePojo foodType;
//
//    public static FoodProduct toEntity(FoodProductPojo pojo){
//        FoodProduct entity = new FoodProduct();
//        entity.setId(pojo.getId());
//        entity.setName(pojo.getName());
//        //List
//        entity.setWeight(pojo.getWeight());
//        entity.setFoodType(FoodTypePojo.toEntity(pojo.getFoodType()));
//        return entity;
//    }
//    public static FoodProductPojo fromEntity(FoodProduct entity){
//        FoodProductPojo pojo = new FoodProductPojo();
//        pojo.setId(entity.getId());
//        pojo.setName(entity.getName());
//        //List
//        pojo.setWeight(entity.getWeight());
//        pojo.setFoodType(FoodTypePojo.fromEntity(entity.getFoodType()));
//        return pojo;
//    }
//
//}
