//package com.example.demo.service;
//
//import com.example.demo.dto.BakeryPojo;
//import com.example.demo.dto.FoodProductPojo;
//import com.example.demo.repository.BakeryRepository;
//import com.example.demo.repository.FoodProductRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//public class FoodProductService {
//    private final FoodProductRepository foodProductRepository;
//
//    public FoodProductService(FoodProductRepository foodProductRepository) {
//        this.foodProductRepository = foodProductRepository;
//    }
//
//    public List<FoodProductPojo> findAll() {
//        return foodProductRepository.findAll().stream().map(FoodProductPojo::fromEntity).collect(Collectors.toList());
//    }
//
//    public FoodProductPojo findIngredientById(UUID id) {
//        var bakery = foodProductRepository.findById(id);
//        if(bakery.isPresent()){
//            return FoodProductPojo.fromEntity(bakery.get());
//        }
//        return null;
//    }
//
////    public List<BakeryPojo> findIngredientByName() {
////        return bakeryRepository.findByName().stream().map(BakeryPojo::fromEntity).collect(Collectors.toList());
////    }
//
//    public FoodProductPojo create(FoodProductPojo bakeryPojo) {
//        bakeryPojo.setId(UUID.randomUUID());
//        return FoodProductPojo.fromEntity(foodProductRepository.save(FoodProductPojo.toEntity(bakeryPojo)));
//
//    }
//
//    public boolean delete(UUID id) {
//        return false;
//    }
//}
