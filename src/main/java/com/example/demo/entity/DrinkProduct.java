//package com.example.demo.entity;
//
//import jakarta.persistence.DiscriminatorValue;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.ManyToOne;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@DiscriminatorValue("drink")
//public class DrinkProduct extends Product{
//    int volume;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private DrinkType drinkType;
//}