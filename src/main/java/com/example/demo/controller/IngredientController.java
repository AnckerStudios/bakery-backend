package com.example.demo.controller;

import com.example.demo.dto.IngredientPojo;
import com.example.demo.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<IngredientPojo> findAll(){
        return ingredientService.findAll();
    }
    @GetMapping("/findById/{id}")
    public IngredientPojo findIngredientById(@PathVariable("id") UUID id){
        return ingredientService.findIngredientById(id);
    }
    @GetMapping("/findByName/{name}")
    public List<IngredientPojo> findIngredientByName(@PathVariable("name") String name){
        return ingredientService.findIngredientByName(name);
    }

    @PostMapping
    public IngredientPojo createIngredient(@RequestBody IngredientPojo ingredientPojo){
        return ingredientService.create(ingredientPojo);
    }
    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable("id") UUID id){

        ingredientService.delete(id);
    }
}
