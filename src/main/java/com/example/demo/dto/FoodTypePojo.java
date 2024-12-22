//package com.example.demo.dto;
//
//import com.example.demo.entity.*;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Data
//public class FoodTypePojo {
//    UUID id;
//    String name;
//    //private List<FoodProductPojo> foodProducts;
//
//    public static FoodType toEntity(FoodTypePojo pojo){
//        FoodType entity = new FoodType();
//        entity.setId(pojo.getId());
//        entity.setName(pojo.getName());
////        List<FoodProduct> products = new ArrayList<>();
////        entity.setFoodProducts(products);
////        for(FoodProductPojo productPojo : pojo.getFoodProducts()){
////            products.add(FoodProductPojo.toEntity(productPojo));
////        }
//        return entity;
//    }
//    public static FoodTypePojo fromEntity(FoodType entity){
//        FoodTypePojo pojo = new FoodTypePojo();
//        pojo.setId(entity.getId());
//        pojo.setName(entity.getName());
////        List<FoodProductPojo> products = new ArrayList<>();
////        pojo.setFoodProducts(products);
////        for(FoodProduct productEntity : entity.getFoodProducts()){
////            products.add(FoodProductPojo.fromEntity(productEntity));
////        }
//        return pojo;
//    }
//}
