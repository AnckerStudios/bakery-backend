//package com.example.demo.dto;
//
//import com.example.demo.entity.Bakery;
//import com.example.demo.entity.BakeryCategory;
//import com.example.demo.entity.Category;
//import com.example.demo.entity.ProductBakery;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//public class BakeryCategoryPojo {
//    CategoryPojo category;
//    BakeryPojo bakery;
//    List<ProductBakeryPojo> productBakeryPojos;
//
//    public static BakeryCategory toEntity(BakeryCategoryPojo pojo){
//        BakeryCategory entity = new BakeryCategory();
//        entity.setCategory(CategoryPojo.toEntity(pojo.getCategory()));
//        entity.setBakery(BakeryPojo.toEntity(pojo.getBakery()));
//
//        List<ProductBakery> productBakery = new ArrayList<>();
//        entity.setProductBakeries(productBakery);
//        for(ProductBakeryPojo item : pojo.getProductBakeryPojos()){
//            productBakery.add(ProductBakeryPojo.toEntity(item));
//        }
//        return entity;
//    }
//    public static BakeryCategoryPojo fromEntity(BakeryCategory entity){
//        BakeryCategoryPojo pojo = new BakeryCategoryPojo();
//        pojo.setCategory(CategoryPojo.fromEntity(entity.getCategory()));
//        pojo.setBakery(BakeryPojo.fromEntity(entity.getBakery()));
//
//        List<ProductBakeryPojo> productBakery = new ArrayList<>();
//        pojo.setProductBakeryPojos(productBakery);
//        for(ProductBakery item : entity.getProductBakeries()){
//            productBakery.add(ProductBakeryPojo.fromEntity(item));
//        }
//        return pojo;
//    }
//}
