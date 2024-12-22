//package com.example.demo.entity;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
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
//public class DrinkType {
//    @Id
//    UUID id;
//    String name;
//
//    @OneToMany(mappedBy = "drinkType", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<DrinkProduct> drinkProducts;
//}
