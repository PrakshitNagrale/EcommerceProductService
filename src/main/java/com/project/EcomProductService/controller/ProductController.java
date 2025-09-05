package com.project.EcomProductService.controller;

import com.project.EcomProductService.exception.InvalidInputException;
import com.project.EcomProductService.models.Product;
import com.project.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService; //field base injection

    //to get all the products form db
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){

         List<Product> products =  productService.getAllProducts();
       return ResponseEntity.ok(products);
    }

    //to get single product
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") UUID id){

        if(id == null){
            throw new InvalidInputException("Input is Incorrect!");
        }
        Product savedProduct = productService.getProductByProductId(id);
        return ResponseEntity.ok(savedProduct);
    }

    //to create product in db
    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody Product product){

        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    //to update the product
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") UUID id,@RequestBody Product product){

        Product updatedProduct = productService.updateProduct(product,id);
        return ResponseEntity.ok(updatedProduct);
    }

    //to delete the product
    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id){

        return ResponseEntity.ok(
                productService.deleteProduct(id)
        );
    }

    //to get product by title
    @GetMapping("/product/name/{productName}")
    public ResponseEntity<Product> getProductByName(@PathVariable("productName") String title){

        return  ResponseEntity.ok(
        productService.getProductByProductName(title)
        );
    }

    //to get products by price Range
    @GetMapping("/products/{min}/{max}")
    public ResponseEntity<List<Product>> getProductsByPriceRange(@PathVariable("min") double minPrice,
                                                                 @PathVariable("max") double maxPrice){
        return ResponseEntity.ok(
                productService.getProducts(minPrice,maxPrice)
        );
    }

    //to get products by rating
    @GetMapping("product/rating/{rating}")
    public ResponseEntity<List<Product>> getProductByRating(@PathVariable("rating") double rating){

        return ResponseEntity.ok(
                productService.getProductsByRating(rating)
        );

    }


}
