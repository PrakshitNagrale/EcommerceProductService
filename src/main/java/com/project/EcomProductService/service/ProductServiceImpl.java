package com.project.EcomProductService.service;

import com.project.EcomProductService.exception.ProductNotFoundException;
import com.project.EcomProductService.models.Product;
import com.project.EcomProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll(); // findAll() is inbuilt method given by repository
    }

    @Override
    public Product getProductByProductId(UUID productId) throws ProductNotFoundException {

       // basic code,because findById() returns Optional & to Optional can be empty
         /*
        Product product = productRepository.findById(productId).get();
        if(product == null){
            throw new ProductNotFoundException("Product doest not found for id: "+productId);
        }
           */
        // OR with .orElseThrow() ,lambda expression

       Product savedProduct =  productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product doest not found for id: "+productId));

       return savedProduct;
    }

    @Override
    public Product createProduct(Product product) {
       Product savedProduct =  productRepository.save(product);
       return savedProduct;
    }

    //to update product
    @Override
    public Product updateProduct(Product updateProduct, UUID productId) {

        //1. check product is present in db by productId if not throw exception
        Product savedProduct = productRepository.findById(productId)
                .orElseThrow(()-> new ProductNotFoundException("Product doest not found for id: "+productId));

        //2. update all the attributes except id
        savedProduct.setCategory(updateProduct.getCategory());
        savedProduct.setRating(updateProduct.getRating());
        savedProduct.setTitle(updateProduct.getTitle());
        savedProduct.setPrice(updateProduct.getPrice());
        savedProduct.setDescription(updateProduct.getDescription());
        savedProduct.setImageURL(updateProduct.getImageURL());

        //3. save in db
        productRepository.save(savedProduct);

        //4.return product
        return savedProduct;
    }

    //to delete single product
    @Override
    public boolean deleteProduct(UUID productId) {

        // productRepository.deleteById(productId);
    //1. find the product is present or not
      Product product = productRepository.findById(productId)
              .orElseThrow(() ->  new ProductNotFoundException("Product doest not found for id: "+productId));
      //2. delete the product
       productRepository.delete(product);
        return true;
    }

    //to get product by product name
    @Override
    public Product getProductByProductName(String productName) {
      //  to get product by title
       return productRepository.findProductByTitle(productName);

       //to get "first product" by title
       //return productRepository.findFirstProductByTitle(productName);
    }

    //to get products between price range
    @Override
    public List<Product> getProducts(double minPrice, double maxPrice) {
       return productRepository.findByPriceBetween(minPrice,maxPrice);
    }

    //to get all products by rating
    @Override
    public List<Product> getProductsByRating(double rating) {

        return productRepository.findProductByRating(rating);
    }
}
