//package com.example.demo.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Getter
//@Setter
//@Entity
//public class FoodType {
//    @Id
//    UUID id;
//    String name;
//
//    @OneToMany(mappedBy = "foodType", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<FoodProduct> foodProducts;
//}
