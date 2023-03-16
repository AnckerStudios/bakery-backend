package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Category {

    @Id
    UUID id;
    String name;
    boolean isDrink;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
