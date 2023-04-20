package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductCategoriesPojo {

    CategoryPojo category;
    List<ProductBakeryPojo> productBakerys;


}
