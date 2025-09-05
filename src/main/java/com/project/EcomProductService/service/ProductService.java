package com.project.EcomProductService.service;

import com.project.EcomProductService.exception.ProductNotFoundException;
import com.project.EcomProductService.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductByProductId(UUID productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product updateProduct,UUID productId);
    boolean deleteProduct(UUID productId);

    Product getProductByProductName(String productName);
    List<Product> getProducts(double min, double max);
    List<Product> getProductsByRating(double rating);

}
