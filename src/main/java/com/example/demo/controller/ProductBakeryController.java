package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.ProductBakery;
import com.example.demo.service.BakeryService;
import com.example.demo.service.ProductBakeryService;
import jakarta.servlet.ServletContext;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public List<ProductBakeryPojo> findByBakery(@PathVariable("bakery_id") UUID bakeryId){
        //System.out.println(bakeryService.findByBakery(bakeryId));
        return bakeryService.findByBakery(bakeryId);

    }
    @GetMapping("{bakery_id}/add/{product_id}")
    public ProductBakeryPojo addProductInBakery(@PathVariable("bakery_id") UUID bakeryId, @PathVariable("product_id") UUID productId,@RequestParam("price") int price){
        return bakeryService.addProductInBakery(bakeryId,productId,price);
    }

    @DeleteMapping("{bakery_id}/del/{product_id}")
    public void delProductInBakery(@PathVariable("bakery_id") UUID productId,@PathVariable("product_id") UUID ingredientId){
        bakeryService.delProductInBakery(productId,ingredientId);
    }

    @PostMapping
    public ProductBakeryPojo createProductInBakery(@RequestBody ProductBakeryPojo productBakeryPojo){
        return bakeryService.createProductInBakery(productBakeryPojo);
    }

    @PostMapping(value = "/createIn",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ProductBakeryPojo createProduct2(@RequestPart("product") ProductBakeryPojo productBakery, @RequestPart("image") MultipartFile image){
        System.out.println("product "+ productBakery);
        System.out.println("file "+ image);
        return bakeryService.createProduct2(productBakery,image);
    }

}
