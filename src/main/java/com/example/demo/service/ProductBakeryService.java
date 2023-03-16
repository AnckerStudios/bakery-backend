package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.Bakery;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductBakery;
import com.example.demo.repository.BakeryRepository;
import com.example.demo.repository.ProductBakeryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductBakeryService {
    private final ProductBakeryRepository productBakeryRepository;
    private final BakeryRepository bakeryRepository;
    private final ProductRepository productRepository;


    public ProductBakeryService(ProductBakeryRepository productBakeryRepository, BakeryRepository bakeryRepository, ProductRepository productRepository) {
        this.productBakeryRepository = productBakeryRepository;
        this.bakeryRepository = bakeryRepository;

        this.productRepository = productRepository;
    }

    public List<ProductBakeryPojo> findAll() {
        return productBakeryRepository.findAll().stream().map(ProductBakeryPojo::fromEntity).collect(Collectors.toList());
    }

    public List<ProductCategoriesPojo> findByBakery(UUID bakeryId){
        List<ProductBakery> list = productBakeryRepository.findByBakery_Id(bakeryId);
        HashMap<UUID, ProductCategoriesPojo> map = new HashMap<>();
        for (ProductBakery item : list) {
            Category category = item.getProduct().getCategory();
            if(map.containsKey(category.getId())){
                map.get(category.getId()).getProducts().add(ProductPojo.fromEntity(item.getProduct()));
            }else{
                map.put(category.getId(), new ProductCategoriesPojo(
                        BakeryPojo.fromEntity(item.getBakery()),
                        CategoryPojo.fromEntity(category),
                        new ArrayList<>(List.of(ProductPojo.fromEntity(item.getProduct())))
                        //List.of(ProductPojo.fromEntity(item.getProduct()))
                        )
                );
            }
        }

        return map.values().stream().toList();

    }

//    public ProductBakeryPojo findIngredientById(UUID id) {
//        var bakery = bakeryRepository.findById(id);
//        if(bakery.isPresent()){
//            return ProductBakeryPojo.fromEntity(bakery.get());
//        }
//        return null;
//    }

//    public List<BakeryPojo> findIngredientByName() {
//        return bakeryRepository.findByName().stream().map(BakeryPojo::fromEntity).collect(Collectors.toList());
//    }

//    public ProductBakeryPojo create(ProductBakeryPojo bakeryPojo) {
//        bakeryPojo.setId(UUID.randomUUID());
//        return ProductBakeryPojo.fromEntity(bakeryRepository.save(BakeryPojo.toEntity(bakeryPojo)));
//
//    }

    public boolean delete(UUID id) {
        return false;
    }
    //TODO исправить
    public BakeryPojo addProductInBakery(UUID bakeryId, UUID productId) {
        Bakery bakery = bakeryRepository.findById(bakeryId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        ProductBakery productBakery = new ProductBakery();
        productBakery.setProduct(product);
        productBakery.setBakery(bakery);
        productBakery.setPrice(100);
        productBakery.setValue(100);
        return ProductBakeryPojo.fromEntity(productBakeryRepository.save(productBakery)).getBakery();
    }

    public void delProductInBakery(UUID bakeryId, UUID productId) {
////        ProductBakery productBakery = productBakeryRepository.findById()
//        Bakery bakery = bakeryRepository.findById(bakeryId).orElseThrow();
//
//        Product product = productRepository.findById(productId).orElseThrow();
//        drink.getIngredients().remove(ingredientRepository.findById(ingredientId).orElseThrow());
//        return DrinkProductPojo.fromEntity(drinkProductRepository.save(drink));
    }
}
