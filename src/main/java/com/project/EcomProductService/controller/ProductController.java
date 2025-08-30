package com.project.EcomProductService.controller;

import com.project.EcomProductService.dtos.FakeStoreProductResponseDTO;
import com.project.EcomProductService.models.Product;
import com.project.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService; //field base injection

    @GetMapping("/product")
    public ResponseEntity<List<FakeStoreProductResponseDTO>> getAllProducts(){

       List<FakeStoreProductResponseDTO> products =  productService.getAllProducts();

       return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<FakeStoreProductResponseDTO> getProductById(@PathVariable("id") int id){


        FakeStoreProductResponseDTO product = productService.getProduct(id);

        return ResponseEntity.ok(product);

    }

    //to create product in db
    @PostMapping("/product")
    public ResponseEntity create(@RequestBody Product product){

        Product savedProduct = productService.createProduct(product);

        return ResponseEntity.ok(savedProduct);

    }




}
