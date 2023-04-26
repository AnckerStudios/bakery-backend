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
    private UUID id;
    @Column(unique = true)
    private String name;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "ingredient",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IngredientProduct> ingredientProducts;

}
