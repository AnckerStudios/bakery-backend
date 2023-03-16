package com.example.demo.service;

import com.example.demo.dto.ProductPojo;
import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Product;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final IngredientRepository ingredientRepository;

    public ProductService(ProductRepository productRepository, IngredientRepository ingredientRepository) {
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<ProductPojo> findAll() {
        return productRepository.findAll().stream().map(ProductPojo::fromEntity).collect(Collectors.toList());
    }

    public ProductPojo findIngredientById(UUID id) {
        var drink = productRepository.findById(id);
        if(drink.isPresent()){
            return ProductPojo.fromEntity(drink.get());
        }
        return null;
    }

//    public List<BakeryPojo> findIngredientByName() {
//        return bakeryRepository.findByName().stream().map(BakeryPojo::fromEntity).collect(Collectors.toList());
//    }

    public ProductPojo create(ProductPojo productPojo) {
        productPojo.setId(UUID.randomUUID());
        return ProductPojo.fromEntity(productRepository.save(ProductPojo.toEntity(productPojo)));

    }

    public boolean delete(UUID id) {
        return false;
    }

    public ProductPojo addIngredientInProduct(UUID productId, UUID ingredientId) {
        Product drink = productRepository.findById(productId).get();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientId);
        drink.getIngredients().add(ingredient);
        return ProductPojo.fromEntity(productRepository.save(drink));
    }
    public ProductPojo delIngredientInProduct(UUID productId, UUID ingredientId) {
        Product drink = productRepository.findById(productId).orElseThrow();
        drink.getIngredients().remove(ingredientRepository.findById(ingredientId).orElseThrow());
        return ProductPojo.fromEntity(productRepository.save(drink));
    }
}
