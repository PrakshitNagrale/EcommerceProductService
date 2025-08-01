package com.project.EcomProductService.service;

import com.project.EcomProductService.dtos.FakeStoreProductResponseDTO;
import com.project.EcomProductService.models.Product;

import java.util.List;

public interface ProductService {

    List<FakeStoreProductResponseDTO> getAllProducts();
    Product getProduct(int productId);
    Product createProduct(Product product);
    Product updateProduct(Product updateProduct,int productId);
    boolean deleteProduct(int productId);

}
