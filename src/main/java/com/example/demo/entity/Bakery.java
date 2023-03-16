package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Bakery {
    @Id
    UUID id;
    String address;
    String name;

    @OneToMany(mappedBy = "bakery")
    List<ProductBakery> productBakeries;


}
