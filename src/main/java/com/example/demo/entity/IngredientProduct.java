package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@IdClass(IngredientProductPK.class)
public class IngredientProduct {
    @Id
    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
//    @JoinColumn(name = "bakeryCategory_id")
    private Ingredient ingredient;

    @Id
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Product product;

}
