package com.example.demo.controller;

import com.example.demo.dto.ProductBakeryPojo;
import com.example.demo.dto.ProductPojo;
import com.example.demo.service.ProductService;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;
    private Path path = Paths.get("uploads");
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

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ProductPojo createProduct(@RequestPart("product") ProductPojo product, @RequestPart("image") MultipartFile image){
        return productService.save(product,image);
    }
    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable("id") UUID id){
        System.out.println("ggggggggggg");
        productService.delete(id);
    }

    @PostMapping(value = "/createIn/{bakery_id}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ProductBakeryPojo createProduct2(@RequestPart("product") ProductPojo product, @RequestPart("image") MultipartFile image,
                                            @RequestParam("price") int price, @PathVariable("bakery_id") UUID bakeryId
    ){
        System.out.println("product "+ product);
        System.out.println("file "+ image);
        return productService.createProduct2(product,image,price,bakeryId);
    }

    @GetMapping("image/{product_id}")
    public ResponseEntity<byte[]> getProductImage(@PathVariable("product_id")UUID productId) throws IOException {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(productService.getProductImage(productId));
    }

    @GetMapping("not/{bakery_id}")
    public List<ProductPojo> getProductsNotBakery(@PathVariable("bakery_id")UUID bakeryId){
        return productService.getProductsNotBakery(bakeryId);
    }
}
