package com.project.EcomProductService.exception;

import com.project.EcomProductService.controller.ProductController;
import com.project.EcomProductService.dtos.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)  //when we have multiple @controller advice we have to mention base Package class
public class ProductControllerExceptionHandler {


    @ExceptionHandler({ProductNotFoundException.class,NoProductPresentException.class})
    public ResponseEntity<ExceptionResponseDTO> handleNoProductException(ProductPresentException  pe){

        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                pe.getMessage(), 404);

        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ExceptionResponseDTO> handleInvalidInputException(InvalidInputException ie){

        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                ie.getMessage(),
                400
        );
        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.BAD_REQUEST);
    }

}
