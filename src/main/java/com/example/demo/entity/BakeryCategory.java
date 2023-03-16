//package com.example.demo.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Entity
//@Data
//@IdClass(BakeryCategoryPK.class)
//public class BakeryCategory {
//    @Id
//    @ManyToOne
//    @MapsId("bakeryId")
//    @JoinColumn(name = "bakery_id")
//    Bakery bakery;
//
//    @Id
//    @ManyToOne
//    @MapsId("categoryId")
//    @JoinColumn(name = "category_id")
//    Category category;
//
//    @OneToMany(mappedBy = "bakeryCategory")
//    List<ProductBakery> productBakeries;
//}
