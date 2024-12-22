//package com.example.demo.service;
//
//import com.example.demo.dto.FoodProductPojo;
//import com.example.demo.dto.FoodTypePojo;
//import com.example.demo.repository.FoodProductRepository;
//import com.example.demo.repository.FoodTypeRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//public class FoodTypeService {
//    private final FoodTypeRepository foodTypeRepository;
//
//    public FoodTypeService(FoodTypeRepository foodTypeRepository) {
//        this.foodTypeRepository = foodTypeRepository;
//    }
//
//    public List<FoodTypePojo> findAll() {
//        return foodTypeRepository.findAll().stream().map(FoodTypePojo::fromEntity).collect(Collectors.toList());
//    }
//
//    public FoodTypePojo findIngredientById(UUID id) {
//        var bakery = foodTypeRepository.findById(id);
//        if(bakery.isPresent()){
//            return FoodTypePojo.fromEntity(bakery.get());
//        }
//        return null;
//    }
//
////    public List<BakeryPojo> findIngredientByName() {
////        return bakeryRepository.findByName().stream().map(BakeryPojo::fromEntity).collect(Collectors.toList());
////    }
//
//    public FoodTypePojo create(FoodTypePojo bakeryPojo) {
//        bakeryPojo.setId(UUID.randomUUID());
//        return FoodTypePojo.fromEntity(foodTypeRepository.save(FoodTypePojo.toEntity(bakeryPojo)));
//
//    }
//
//    public boolean delete(UUID id) {
//        return false;
//    }
//}
