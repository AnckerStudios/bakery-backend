package com.example.demo.repository;

import com.example.demo.entity.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public interface BakeryRepository extends JpaRepository<Bakery, UUID> {

}
