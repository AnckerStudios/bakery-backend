//package com.example.demo.controller;
//
//import com.example.demo.dto.DrinkProductPojo;
//import com.example.demo.dto.DrinkTypePojo;
//import com.example.demo.service.DrinkProductService;
//import com.example.demo.service.DrinkTypeService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/drinkType")
//public class DrinkTypeController {
//    private final DrinkTypeService drinkTypeService;
//
//    public DrinkTypeController(DrinkTypeService drinkTypeService){
//        this.drinkTypeService = drinkTypeService;
//    }
//
//    @GetMapping
//    public List<DrinkTypePojo> findAll(){
//        return drinkTypeService.findAll();
//    }
//
//    @GetMapping("/findById/{id}")
//    public DrinkTypePojo findIngredientById(@PathVariable("id") UUID id){
//        return drinkTypeService.findIngredientById(id);
//    }
////    @GetMapping("/findByName/{name}")
////    public List<BakeryPojo> findIngredientByName(@PathVariable("name") String name){
////        return bakeryService.findIngredientByName();
////    }
//
//    @PostMapping
//    public DrinkTypePojo createIngredient(@RequestBody DrinkTypePojo drinkProductPojo){
//        return drinkTypeService.create(drinkProductPojo);
//    }
//    @DeleteMapping("{id}")
//    public boolean deleteIngredient(@PathVariable("id") UUID id){
//        return drinkTypeService.delete(id);
//    }
//}
