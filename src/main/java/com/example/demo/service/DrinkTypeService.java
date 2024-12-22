//package com.example.demo.service;
//
//import com.example.demo.dto.DrinkProductPojo;
//import com.example.demo.dto.DrinkTypePojo;
//import com.example.demo.repository.DrinkProductRepository;
//import com.example.demo.repository.DrinkTypeRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//public class DrinkTypeService {
//    private final DrinkTypeRepository drinkTypeRepository;
//
//    public DrinkTypeService(DrinkTypeRepository drinkTypeRepository) {
//        this.drinkTypeRepository = drinkTypeRepository;
//    }
//
//    public List<DrinkTypePojo> findAll() {
//        return drinkTypeRepository.findAll().stream().map(DrinkTypePojo::fromEntity).collect(Collectors.toList());
//    }
//
//    public DrinkTypePojo findIngredientById(UUID id) {
//        var drink = drinkTypeRepository.findById(id);
//        if(drink.isPresent()){
//            return DrinkTypePojo.fromEntity(drink.get());
//        }
//        return null;
//    }
//
////    public List<BakeryPojo> findIngredientByName() {
////        return bakeryRepository.findByName().stream().map(BakeryPojo::fromEntity).collect(Collectors.toList());
////    }
//
//    public DrinkTypePojo create(DrinkTypePojo drinkTypePojo) {
//        drinkTypePojo.setId(UUID.randomUUID());
//        return DrinkTypePojo.fromEntity(drinkTypeRepository.save(DrinkTypePojo.toEntity(drinkTypePojo)));
//
//    }
//
//    public boolean delete(UUID id) {
//        return false;
//    }
//}
