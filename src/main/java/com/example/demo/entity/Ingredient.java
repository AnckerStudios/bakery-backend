package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Ingredient {
    @Id
    UUID id;
    String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    List<Product> products;

}
