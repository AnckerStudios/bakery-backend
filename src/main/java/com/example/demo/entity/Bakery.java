package com.example.demo.entity;

import jakarta.persistence.Column;
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
    private UUID id;
    private String address;
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "bakery")
    private List<ProductBakery> productBakeries;


}
