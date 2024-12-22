//package com.example.demo.dto;
//
//import com.example.demo.entity.*;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.ManyToOne;
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Data
//public class DrinkProductPojo extends ProductPojo{
//    int volume;
//    private UUID drinkType;
//
//    public static DrinkProduct toEntity(DrinkProductPojo pojo){
//        DrinkProduct entity = new DrinkProduct();
//        entity.setId(pojo.getId());
//        //List
//        entity.setName(pojo.getName());
//        List<Ingredient> products = new ArrayList<>();
//        entity.setIngredients(products);
//
//        for(UUID uuid : pojo.getIngredients()){
//            Ingredient ingredient = new Ingredient();
//            ingredient.setId(uuid);
//            products.add(ingredient);
//        }
//        //List
//        entity.setVolume(pojo.getVolume());
//
//        DrinkType type = new DrinkType();
//        type.setId(pojo.getDrinkType());
//        entity.setDrinkType(type);
//        return entity;
//    }
//    public static DrinkProductPojo fromEntity(DrinkProduct entity){
//        DrinkProductPojo pojo = new DrinkProductPojo();
//        pojo.setId(entity.getId());
//        //List
//        pojo.setName(entity.getName());
//        List<UUID> ingredientPojos = new ArrayList<>();
//        pojo.setIngredients(ingredientPojos);
//        for(Ingredient ingredientPojo : entity.getIngredients()){
//            ingredientPojos.add(ingredientPojo.getId());
//        }
//        //List
//        pojo.setVolume(entity.getVolume());
//        pojo.setDrinkType(entity.getDrinkType().getId());
//        return pojo;
//    }
//}
