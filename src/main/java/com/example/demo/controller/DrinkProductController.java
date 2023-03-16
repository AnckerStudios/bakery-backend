//package com.example.demo.controller;
//
//import com.example.demo.dto.BakeryPojo;
//import com.example.demo.dto.DrinkProductPojo;
//import com.example.demo.service.BakeryService;
//import com.example.demo.service.DrinkProductService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/drink")
//public class DrinkProductController {
//    private final DrinkProductService drinkProductService;
//
//    public DrinkProductController(DrinkProductService drinkProductService){
//        this.drinkProductService = drinkProductService;
//    }
//
//    @GetMapping
//    public List<DrinkProductPojo> findAll(){
//        return drinkProductService.findAll();
//    }
//
//    @GetMapping("/findById/{id}")
//    public DrinkProductPojo findIngredientById(@PathVariable("id") UUID id){
//        return drinkProductService.findIngredientById(id);
//    }
//
//    @GetMapping("{product_id}/addIngredient/{ingredient_id}")
//    public DrinkProductPojo addIngredientInProduct(@PathVariable("product_id") UUID productId,@PathVariable("ingredient_id") UUID ingredientId){
//        return drinkProductService.addIngredientInProduct(productId,ingredientId);
//    }
//
//    @GetMapping("{product_id}/delIngredient/{ingredient_id}")
//    public void delIngredientInProduct(@PathVariable("product_id") UUID productId,@PathVariable("ingredient_id") UUID ingredientId){
//         drinkProductService.delIngredientInProduct(productId,ingredientId);
//    }
////    @GetMapping("/findByName/{name}")
////    public List<BakeryPojo> findIngredientByName(@PathVariable("name") String name){
////        return bakeryService.findIngredientByName();
////    }
//
//    @PostMapping
//    public DrinkProductPojo createIngredient(@RequestBody DrinkProductPojo drinkProductPojo){
//        System.out.println(drinkProductPojo.getIngredients());
//        return drinkProductService.create(drinkProductPojo);
//    }
//    @DeleteMapping("{id}")
//    public boolean deleteIngredient(@PathVariable("id") UUID id){
//        return drinkProductService.delete(id);
//    }
//}
