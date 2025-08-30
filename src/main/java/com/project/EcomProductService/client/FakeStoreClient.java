package com.project.EcomProductService.client;

import com.project.EcomProductService.dtos.FakeStoreCartResponseDTO;
import com.project.EcomProductService.dtos.FakeStoreProductResponseDTO;
import com.project.EcomProductService.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder; //to connect with 3rd party api

    @Value("${fakestore.api.base.url}")  //to get value from app.properties file
    private String fakeStoreAPIBaseUrl;

    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;

    @Value("${fakestore.api.cart.for.user.path}")
    private String fakeStoreAPICartForUser;


    public List<FakeStoreProductResponseDTO> getAllProducts(){

        String fakeStoreGetAllProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath);//complete url of fake store website

        RestTemplate restTemplate = restTemplateBuilder.build();// to call 3rd party api

        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList =
                restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class); //it takes url &
                                                                                                // at which class we want to convert the received data

        return List.of(productResponseList.getBody());
    }

    public FakeStoreProductResponseDTO getProductById(int id){

                                                        //https://fakestoreapi.com/products/id
        String fakeStoreGetProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath).concat("/" + id); //to get details of id

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.getForEntity(fakeStoreGetProductURL,FakeStoreProductResponseDTO.class);
                                                //getting single product details and converting it to response dto
        return productResponse.getBody();
    }

    public List<FakeStoreCartResponseDTO> getCartForUser(int userId) { //to get cart for user id
                                        //https://fakestoreapi.com/carts?userId=1

        if(userId < 1){
            throw new InvalidInputException("Invalid user Id: "+userId);
        }

        if(userId < 1)
            return null;
        String fakeStoreGetCartForUser = fakeStoreAPIBaseUrl.concat(fakeStoreAPICartForUser).concat(String.valueOf(userId));

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreCartResponseDTO[]> cartResponse =
                restTemplate.getForEntity(fakeStoreGetCartForUser , FakeStoreCartResponseDTO[].class); //converting fake store output to our response

        return List.of(cartResponse.getBody());

    }

    /*
https://fakestoreapi.com/carts?userId=1 -> get cart by userId, and userId is a query param
 */
}
