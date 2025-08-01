package com.project.EcomProductService.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
}
