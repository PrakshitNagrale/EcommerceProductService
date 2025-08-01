package com.project.EcomProductService.service;

import com.project.EcomProductService.client.FakeStoreClient;
import com.project.EcomProductService.dtos.FakeStoreProductResponseDTO;
import com.project.EcomProductService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    @Autowired
    FakeStoreClient fakeStoreClient;

    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {

        //it will call getAllProducts of client and return list
       List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();

        return fakeStoreProducts;
    }

    @Override
    public Product getProduct(int productId) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
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
