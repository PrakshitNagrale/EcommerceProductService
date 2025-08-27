package com.project.EcomProductService.service;

import com.project.EcomProductService.dtos.FakeStoreProductResponseDTO;
import com.project.EcomProductService.exception.ProductNotFoundException;
import com.project.EcomProductService.models.Product;

import java.util.List;

public interface ProductService {

    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product updateProduct,int productId);
    boolean deleteProduct(int productId);

}
