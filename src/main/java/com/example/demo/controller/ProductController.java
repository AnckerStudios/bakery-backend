package com.example.demo.controller;

import com.example.demo.dto.ProductPojo;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<ProductPojo> findAll(){
        return productService.findAll();
    }

    @GetMapping("/findById/{id}")
    public ProductPojo findIngredientById(@PathVariable("id") UUID id){
        return productService.findIngredientById(id);
    }

    @GetMapping("{product_id}/addIngredient/{ingredient_id}")
    public ProductPojo addIngredientInProduct(@PathVariable("product_id") UUID productId,@PathVariable("ingredient_id") UUID ingredientId){
        return productService.addIngredientInProduct(productId,ingredientId);
    }

    @GetMapping("{product_id}/delIngredient/{ingredient_id}")
    public void delIngredientInProduct(@PathVariable("product_id") UUID productId,@PathVariable("ingredient_id") UUID ingredientId){
        productService.delIngredientInProduct(productId,ingredientId);
    }
//    @GetMapping("/findByName/{name}")
//    public List<BakeryPojo> findIngredientByName(@PathVariable("name") String name){
//        return bakeryService.findIngredientByName();
//    }

    @PostMapping
    public ProductPojo createIngredient(@RequestBody ProductPojo drinkProductPojo){
        return productService.create(drinkProductPojo);
    }
    @DeleteMapping("{id}")
    public boolean deleteIngredient(@PathVariable("id") UUID id){
        return productService.delete(id);
    }
}
