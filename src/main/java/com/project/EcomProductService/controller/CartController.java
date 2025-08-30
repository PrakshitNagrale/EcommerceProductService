package com.project.EcomProductService.controller;

import com.project.EcomProductService.client.FakeStoreClient;
import com.project.EcomProductService.dtos.FakeStoreCartResponseDTO;
import com.project.EcomProductService.exception.CartNotFoundException;
import com.project.EcomProductService.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private FakeStoreClient fakeStoreClient;  //field injection


    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartForUser(@PathVariable("userId") int userId){

      List<FakeStoreCartResponseDTO> cartResponse = fakeStoreClient.getCartForUser(userId);

      if(cartResponse == null){
          throw  new CartNotFoundException("Cart Not Found with userId "+ userId);
      }
      return ResponseEntity.ok(cartResponse);
    }


}
