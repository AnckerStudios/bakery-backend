package com.example.demo.controller;

import com.example.demo.dto.BakeryPojo;
import com.example.demo.dto.ProductBakeryPojo;
import com.example.demo.dto.ProductCategoriesPojo;
import com.example.demo.service.BakeryService;
import com.example.demo.service.ProductBakeryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/productBakery")
public class ProductBakeryController {
    private final ProductBakeryService bakeryService;

    public ProductBakeryController(ProductBakeryService bakeryService){
        this.bakeryService = bakeryService;
    }

    @GetMapping
    public List<ProductBakeryPojo> findAll(){
        return bakeryService.findAll();
    }
    @GetMapping("findByBakery/{bakery_id}")
    public List<ProductCategoriesPojo> findByBakery(@PathVariable("bakery_id") UUID bakeryId){
        return bakeryService.findByBakery(bakeryId);
    }
    @GetMapping("{bakery_id}/add/{product_id}")
    public BakeryPojo addProductInBakery(@PathVariable("bakery_id") UUID bakeryId, @PathVariable("product_id") UUID productId){
        return bakeryService.addProductInBakery(bakeryId,productId);
    }

    @GetMapping("{bakery_id}/del/{product_id}")
    public void delProductInBakery(@PathVariable("bakery_id") UUID productId,@PathVariable("product_id") UUID ingredientId){
        bakeryService.delProductInBakery(productId,ingredientId);
    }
}
