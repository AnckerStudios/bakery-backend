package com.example.demo.service;

import com.example.demo.dto.BakeryPojo;
import com.example.demo.dto.ProductBakeryPojo;
import com.example.demo.entity.*;
import com.example.demo.repository.BakeryRepository;
import com.example.demo.repository.ProductBakeryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BakeryService {
    private final BakeryRepository bakeryRepository;

    public BakeryService(BakeryRepository bakeryRepository) {
        this.bakeryRepository = bakeryRepository;
    }

    public List<BakeryPojo> findAll() {
        return bakeryRepository.findAll().stream().map(BakeryPojo::fromEntity).collect(Collectors.toList());
    }

    public BakeryPojo findById(UUID id) {
        var bakery = bakeryRepository.findById(id);
        if(bakery.isPresent()){
            return BakeryPojo.fromEntity(bakery.get());
        }
        return null;
    }

    public BakeryPojo create(BakeryPojo bakeryPojo) {
        bakeryPojo.setId(UUID.randomUUID());
        return BakeryPojo.fromEntity(bakeryRepository.save(BakeryPojo.toEntity(bakeryPojo)));

    }
//TODO сделать!!!
    public void delete(UUID id) {
        bakeryRepository.deleteById(id);
    }

//    public BakeryPojo addProductInBakery(UUID bakeryId, UUID productId) {
//        Bakery bakery = bakeryRepository.findById(bakeryId).orElseThrow();
//        Product product = productRepository.findById(productId).orElseThrow();
//        ProductBakery productBakery = new ProductBakery();
//        productBakery.setProduct(product);
//        productBakery.setBakery(bakery);
//        productBakery.setPrice(100);
//        productBakery.setValue(100);
//        return ProductBakeryPojo.fromEntity(productBakeryRepository.save(productBakery)).getBakery();
//    }
//
//    public void delProductInBakery(UUID bakeryId, UUID productId) {
////        ProductBakery productBakery = productBakeryRepository.findById()
////        Bakery bakery = bakeryRepository.findById(bakeryId).orElseThrow();
////
////        DrinkProduct drink = bakeryRepository.findById(productId).orElseThrow();
////        drink.getIngredients().remove(ingredientRepository.findById(ingredientId).orElseThrow());
////        return DrinkProductPojo.fromEntity(drinkProductRepository.save(drink));
//    }


}
