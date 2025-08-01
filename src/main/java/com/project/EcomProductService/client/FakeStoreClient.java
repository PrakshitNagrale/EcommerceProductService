package com.project.EcomProductService.client;

import com.project.EcomProductService.dtos.FakeStoreProductResponseDTO;
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


    public List<FakeStoreProductResponseDTO> getAllProducts(){

        String fakeStoreGetAllProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath);//complete url

        RestTemplate restTemplate = restTemplateBuilder.build();// to call 3rd party api

        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList =
                restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);

        return List.of(productResponseList.getBody());


    }

}
