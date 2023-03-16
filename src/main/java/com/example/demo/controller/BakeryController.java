package com.example.demo.controller;

import com.example.demo.dto.BakeryPojo;
import com.example.demo.dto.IngredientPojo;
import com.example.demo.entity.Bakery;
import com.example.demo.service.BakeryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bakery")
public class BakeryController {
    private final BakeryService bakeryService;

    public BakeryController(BakeryService bakeryService){
        this.bakeryService = bakeryService;
    }

    @GetMapping
    public List<BakeryPojo> findAll(){
        return bakeryService.findAll();
    }
    @GetMapping("findById/{id}")
    public BakeryPojo findById(@PathVariable("id") UUID id){
        return bakeryService.findById(id);
    }
//    @GetMapping("/findByName/{name}")
//    public List<BakeryPojo> findIngredientByName(@PathVariable("name") String name){
//        return bakeryService.findIngredientByName();
//    }

    @PostMapping
    public BakeryPojo createBakery(@RequestBody BakeryPojo bakeryPojo){
        return bakeryService.create(bakeryPojo);
    }
    @DeleteMapping("{id}")
    public boolean deleteBakery(@PathVariable("id") UUID id){
        return bakeryService.delete(id);
    }

//    @GetMapping("{bakery_id}/add/{product_id}")
//    public BakeryPojo addProductInBakery(@PathVariable("bakery_id") UUID productId, @PathVariable("product_id") UUID ingredientId){
//        return bakeryService.addProductInBakery(productId,ingredientId);
//    }
//
//    @GetMapping("{bakery_id}/del/{product_id}")
//    public void delProductInBakery(@PathVariable("bakery_id") UUID productId,@PathVariable("product_id") UUID ingredientId){
//        bakeryService.addProductInBakery(productId,ingredientId);
//    }
}
