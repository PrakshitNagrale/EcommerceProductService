package com.project.EcomProductService.service;

import com.project.EcomProductService.client.FakeStoreClient;
import com.project.EcomProductService.dtos.FakeStoreProductResponseDTO;
import com.project.EcomProductService.exception.InvalidInputException;
import com.project.EcomProductService.exception.NoProductPresentException;
import com.project.EcomProductService.exception.ProductNotFoundException;
import com.project.EcomProductService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl {

    @Autowired
    FakeStoreClient fakeStoreClient;  //field injection


    public List<FakeStoreProductResponseDTO> getAllProducts() {  //to get all the products

        //it will call getAllProducts of client and return list
       List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();

       if(fakeStoreProducts == null){   //check if the list is empty
           throw new NoProductPresentException("No Products are found");
       }
       return fakeStoreProducts;
    }


    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException {  //to get product by id

        if(productId<1){
            throw new InvalidInputException("Input is not Correct");
        }
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductById(productId);

       if(fakeStoreProductResponseDTO == null){
           throw new ProductNotFoundException("Product not found with id = "+productId);
       }
        return fakeStoreProductResponseDTO;
    }


    public Product createProduct(Product product) {
        return null;
    }


    public Product updateProduct(Product updateProduct, int productId) {
        return null;
    }


    public boolean deleteProduct(int productId) {
        return false;
    }
}
