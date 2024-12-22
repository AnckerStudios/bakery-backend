package com.example.demo.repository;

import com.example.demo.entity.Bakery;
import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Modifying
    @Query(value = "DELETE FROM category c where c.id = ?1",nativeQuery = true)
    int customDeleteById(UUID id);
}
