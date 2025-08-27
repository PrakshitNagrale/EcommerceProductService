package com.project.EcomProductService.controller;

import com.project.EcomProductService.dtos.FakeStoreProductResponseDTO;
import com.project.EcomProductService.exception.InvalidInputException;
import com.project.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService; //field base injection

    @GetMapping("/product")
    public ResponseEntity<List<FakeStoreProductResponseDTO>> getAllProducts(){

       List<FakeStoreProductResponseDTO> products =  productService.getAllProducts();

       return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<FakeStoreProductResponseDTO> getProductById(@PathVariable("id") int id){

        if(id<1){
            throw new InvalidInputException("Input is not Correct");
        }

        FakeStoreProductResponseDTO product = productService.getProduct(id);

        return ResponseEntity.ok(product);

    }




}
