package com.example.demo.controller;

import com.example.demo.dto.BakeryPojo;
import com.example.demo.dto.CategoryPojo;
import com.example.demo.service.BakeryService;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryPojo> findAll(){
        return categoryService.findAll();
    }
    @GetMapping("findById/{id}")
    public CategoryPojo findById(@PathVariable("id") UUID id){
        return categoryService.findById(id);
    }

    @PostMapping
    public CategoryPojo createBakery(@RequestBody CategoryPojo bakeryPojo){
        return categoryService.create(bakeryPojo);
    }
    @DeleteMapping("{id}")
    public boolean deleteBakery(@PathVariable("id") UUID id){
        return categoryService.delete(id);
    }

}
