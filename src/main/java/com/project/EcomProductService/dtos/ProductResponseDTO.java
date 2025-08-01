package com.project.EcomProductService.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponseDTO {

    private  int productId;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;

}
