package com.example.demo.service;

import com.example.demo.dto.IngredientPojo;
import com.example.demo.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<IngredientPojo> findAll() {
        return ingredientRepository.findAll().stream().map(IngredientPojo::fromEntity).collect(Collectors.toList());
    }

    public IngredientPojo findIngredientById(UUID id) {
        var ingredient = ingredientRepository.findById(id);
        if(ingredient.isPresent()){
            return IngredientPojo.fromEntity(ingredient.get());
        }
        return null;
    }

    public List<IngredientPojo> findIngredientByName(String name) {
        return ingredientRepository.findByName(name).stream().map(IngredientPojo::fromEntity).collect(Collectors.toList());
    }

    public IngredientPojo create(IngredientPojo ingredientPojo) {
        System.out.println(ingredientPojo);
        if(ingredientPojo.getId() == null) {
            ingredientPojo.setId(UUID.randomUUID());
        }
        return IngredientPojo.fromEntity(ingredientRepository.save(IngredientPojo.toEntity(ingredientPojo)));

    }

    public void delete(UUID id) {
        ingredientRepository.deleteById(id);
    }
}
