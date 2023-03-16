//package com.example.demo.dto;
//
//import com.example.demo.entity.Bakery;
//import com.example.demo.entity.DrinkProduct;
//import com.example.demo.entity.DrinkType;
//import com.example.demo.entity.ProductBakery;
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
//public class DrinkTypePojo {
//    UUID id;
//    String name;
////    private List<DrinkProductPojo> drinkProducts;
//
//    public static DrinkType toEntity(DrinkTypePojo pojo){
//        DrinkType entity = new DrinkType();
//        entity.setId(pojo.getId());
//        entity.setName(pojo.getName());
////        List<DrinkProduct> products = new ArrayList<>();
////        entity.setDrinkProducts(products);
////        for(DrinkProductPojo productPojo : pojo.getDrinkProducts()){
////            products.add(DrinkProductPojo.toEntity(productPojo));
////        }
//        return entity;
//    }
//    public static DrinkTypePojo fromEntity(DrinkType entity){
//        DrinkTypePojo pojo = new DrinkTypePojo();
//        pojo.setId(entity.getId());
//        pojo.setName(entity.getName());
////        List<DrinkProductPojo> products = new ArrayList<>();
////        pojo.setDrinkProducts(products);
////        for(DrinkProduct productEntity : entity.getDrinkProducts()){
////            products.add(DrinkProductPojo.fromEntity(productEntity));
////        }
//        return pojo;
//    }
//}
