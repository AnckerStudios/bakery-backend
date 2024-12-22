package com.example.demo.service;

import com.example.demo.dto.BakeryPojo;
import com.example.demo.dto.ProductBakeryPojo;
import com.example.demo.dto.ProductPojo;
import com.example.demo.entity.Bakery;
import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductBakery;
import com.example.demo.repository.BakeryRepository;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final IngredientRepository ingredientRepository;
    private final BakeryRepository bakeryRepository;

    public ProductService(ProductRepository productRepository, IngredientRepository ingredientRepository, BakeryRepository bakeryRepository) {
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
        this.bakeryRepository = bakeryRepository;
    }

    public List<ProductPojo> findAll() {
        return productRepository.findAll().stream().map(ProductPojo::fromEntity).toList();
    }

    public ProductPojo findIngredientById(UUID id) {
        var drink = productRepository.findById(id);
        if(drink.isPresent()){
            return ProductPojo.fromEntity(drink.get());
        }
        return null;
    }

//    public List<BakeryPojo> findIngredientByName() {
//        return bakeryRepository.findByName().stream().map(BakeryPojo::fromEntity).collect(Collectors.toList());
//    }

    @Transactional
    public ProductPojo save(ProductPojo productPojo, MultipartFile image) {
        if(productPojo.getId() == null)
            productPojo.setId(UUID.randomUUID());
        File file = new File(Utils.IMAGE_PATH.getPath()+productPojo.getId()+".png");

        try(FileOutputStream out = new FileOutputStream(file);) {
            file.createNewFile();
            out.write(image.getBytes());
            return ProductPojo.fromEntity(productRepository.save(ProductPojo.toEntity(productPojo)));
        }catch (Exception e){
            if(file.exists())
                file.delete();
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void delete(UUID id) {
        File file = new File(Utils.IMAGE_PATH.getPath()+id+".png");
        if(file.exists())
            file.delete();
        productRepository.deleteById(id);
    }

//    public ProductPojo addIngredientInProduct(UUID productId, UUID ingredientId) {
//        Product drink = productRepository.findById(productId).get();
//        Ingredient ingredient = new Ingredient();
//        ingredient.setId(ingredientId);
//        drink.getIngredients().add(ingredient);
//        return ProductPojo.fromEntity(productRepository.save(drink));
//    }
//    public ProductPojo delIngredientInProduct(UUID productId, UUID ingredientId) {
//        Product drink = productRepository.findById(productId).orElseThrow();
//        drink.getIngredients().remove(ingredientRepository.findById(ingredientId).orElseThrow());
//        return ProductPojo.fromEntity(productRepository.save(drink));
//    }

    public ProductBakeryPojo createProduct2(ProductPojo productPojo, MultipartFile image, int price, UUID bakeryId) {
        Product product = ProductPojo.toEntity(productPojo);
        product.setId(UUID.randomUUID());
        Bakery bakery = bakeryRepository.findById(bakeryId).orElseThrow();
        ProductBakery productBakery = new ProductBakery();
        productBakery.setBakery(bakery);
        productBakery.setProduct(product);
        productBakery.setPrice(price);
        product.setProductBakeries(List.of(productBakery));
        File file = new File(Utils.IMAGE_PATH.getPath()+product.getId()+".png");
        try {
            file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);
            out.write(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productRepository.save(product);
        return ProductBakeryPojo.fromEntity(productBakery);
    }
    @Transactional
    public byte[] getProductImage(UUID productId) throws IOException {
        Product product = productRepository.findById(productId).orElseThrow();
        return Files.readAllBytes(new File(Utils.IMAGE_PATH.getPath()+productId+".png").toPath());
    }

    public List<ProductPojo> getProductsNotBakery(UUID bakeryId) {
        List<ProductPojo> list = productRepository.getProductNotBakery(bakeryId).stream().map(ProductPojo::fromEntity).toList();
        System.out.println(list.size());
        return list;
    }
}
