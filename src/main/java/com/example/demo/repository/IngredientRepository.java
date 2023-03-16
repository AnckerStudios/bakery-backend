package com.example.demo.repository;

import com.example.demo.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {

    List<Ingredient> findByName(String name);


}
