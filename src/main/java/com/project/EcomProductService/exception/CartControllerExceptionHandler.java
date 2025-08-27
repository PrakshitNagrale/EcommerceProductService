package com.project.EcomProductService.exception;

import com.project.EcomProductService.controller.CartController;
import com.project.EcomProductService.dtos.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleCartNotFoundException(CartNotFoundException exception){

        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                exception.getMessage(),404 );

        return new ResponseEntity<>(exceptionResponseDTO , HttpStatus.NOT_FOUND);
    }


}
