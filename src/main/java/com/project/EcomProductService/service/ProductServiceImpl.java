package com.project.EcomProductService.service;

import com.project.EcomProductService.dtos.FakeStoreProductResponseDTO;
import com.project.EcomProductService.exception.ProductNotFoundException;
import com.project.EcomProductService.models.Product;
import com.project.EcomProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
       Product savedProduct =  productRepository.save(product);
       return savedProduct;
    }

    @Override
    public Product updateProduct(Product updateProduct, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
