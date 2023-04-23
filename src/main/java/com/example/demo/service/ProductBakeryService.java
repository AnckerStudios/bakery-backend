package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.repository.BakeryRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductBakeryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductBakeryService {
    private final ProductBakeryRepository productBakeryRepository;
    private final BakeryRepository bakeryRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductBakeryService(ProductBakeryRepository productBakeryRepository, BakeryRepository bakeryRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productBakeryRepository = productBakeryRepository;
        this.bakeryRepository = bakeryRepository;

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductBakeryPojo> findAll() {
        return productBakeryRepository.findAll().stream().map(ProductBakeryPojo::fromEntity).collect(Collectors.toList());
    }

    public List<ProductBakeryPojo> findByBakery(UUID bakeryId){
        return productBakeryRepository.findByBakery_Id(bakeryId).stream().map(ProductBakeryPojo::fromEntity).toList();
//        HashMap<UUID, ProductCategoriesPojo> map = new HashMap<>();
//        for (ProductBakeryPojo item : list) {
//            CategoryPojo category = item.getProduct().getCategory();
//            if(map.containsKey(category.getId())){
//                map.get(category.getId()).getProductBakerys().add(item);
//            }else{
//                map.put(category.getId(), new ProductCategoriesPojo(
//                        category,
//                        new ArrayList<>(List.of(item))
//                        //List.of(ProductPojo.fromEntity(item.getProduct()))
//                        )
//                );
//            }
//        }
//
//        return map.values().stream().toList();

    }

//    public ProductBakeryPojo findIngredientById(UUID id) {
//        var bakery = bakeryRepository.findById(id);
//        if(bakery.isPresent()){
//            return ProductBakeryPojo.fromEntity(bakery.get());
//        }
//        return null;
//    }

//    public List<BakeryPojo> findIngredientByName() {
//        return bakeryRepository.findByName().stream().map(BakeryPojo::fromEntity).collect(Collectors.toList());
//    }

//    public ProductBakeryPojo create(ProductBakeryPojo bakeryPojo) {
//        bakeryPojo.setId(UUID.randomUUID());
//        return ProductBakeryPojo.fromEntity(bakeryRepository.save(BakeryPojo.toEntity(bakeryPojo)));
//
//    }

    public boolean delete(UUID id) {
        return false;
    }
    //TODO исправить
    public BakeryPojo addProductInBakery(UUID bakeryId, UUID productId) {
        Bakery bakery = bakeryRepository.findById(bakeryId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        ProductBakery productBakery = new ProductBakery();
        productBakery.setProduct(product);
        productBakery.setBakery(bakery);
        productBakery.setPrice(100);
        return ProductBakeryPojo.fromEntity(productBakeryRepository.save(productBakery)).getBakery();
    }

    public void delProductInBakery(UUID bakeryId, UUID productId) {


        Bakery bakery = bakeryRepository.findById(bakeryId).orElseThrow();
//
       Product product = productRepository.findById(productId).orElseThrow();
       ProductBakeryPK pk = new ProductBakeryPK();
       pk.setProduct(product);
       pk.setBakery(bakery);
//        drink.getIngredients().remove(ingredientRepository.findById(ingredientId).orElseThrow());
        productBakeryRepository.deleteById(pk);
    }

    public ProductBakeryPojo createProductInBakery(ProductBakeryPojo productBakeryPojo) {
        Product product = ProductPojo.toEntity(productBakeryPojo.getProduct());
        product.setId(UUID.randomUUID());
        System.out.println(product);
        Bakery bakery = BakeryPojo.toEntity(productBakeryPojo.getBakery());
        ProductBakery productBakery = new ProductBakery();
        productBakery.setBakery(bakery);
        productBakery.setProduct(product);
        productBakery.setPrice(productBakeryPojo.getPrice());
        product.setProductBakeries(List.of(productBakery));
        //System.out.println(product);
        productRepository.save(product);
//        ProductBakery entity = new ProductBakery();
//        entity.setBakery(bakery);
//        entity.setProduct(product);
//        entity.setPrice(productBakeryPojo.getPrice());
//        System.out.println(entity);
//        ProductBakery res = productBakeryRepository.save(entity);
        return productBakeryPojo;
    }

    public ProductBakeryPojo createProduct2(ProductBakeryPojo productBakeryPojo, MultipartFile image) {
        System.out.println("1 productPojo "+ productBakeryPojo);
        System.out.println("2 image "+ image);

        Product product = ProductPojo.toEntity(productBakeryPojo.getProduct());
        product.setId(UUID.randomUUID());
        Bakery bakery = bakeryRepository.findById(productBakeryPojo.getBakery().getId()).orElseThrow();
        ProductBakery productBakery = new ProductBakery();
        productBakery.setBakery(bakery);
        productBakery.setProduct(product);
        productBakery.setPrice(productBakeryPojo.getPrice());
        product.setProductBakeries(List.of(productBakery));
        System.out.println("type image "+ image.getContentType());
        File file = new File("src/main/resources/"+product.getId()+".png");
        try {
            file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);
            out.write(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ProductBakeryPojo.fromEntity(productBakeryRepository.save(productBakery));
    }
}
