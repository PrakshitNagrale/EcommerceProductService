package com.project.EcomProductService.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel {


    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
}
