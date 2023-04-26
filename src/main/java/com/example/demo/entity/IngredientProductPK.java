package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class IngredientProductPK implements Serializable {
    private Ingredient ingredient;
    private Product product;
}
