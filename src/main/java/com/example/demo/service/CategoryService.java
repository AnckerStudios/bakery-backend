package com.example.demo.service;

import com.example.demo.dto.BakeryPojo;
import com.example.demo.dto.CategoryPojo;
import com.example.demo.repository.BakeryRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryPojo> findAll() {
        return categoryRepository.findAll().stream().map(CategoryPojo::fromEntity).collect(Collectors.toList());
    }

    public CategoryPojo findById(UUID id) {
        var bakery = categoryRepository.findById(id);
        if(bakery.isPresent()){
            return CategoryPojo.fromEntity(bakery.get());
        }
        return null;
    }

    public CategoryPojo create(CategoryPojo bakeryPojo) {
        bakeryPojo.setId(UUID.randomUUID());
        return CategoryPojo.fromEntity(categoryRepository.save(CategoryPojo.toEntity(bakeryPojo)));

    }
    //TODO сделать!!!
    public boolean delete(UUID id) {
        return false;
    }
}
