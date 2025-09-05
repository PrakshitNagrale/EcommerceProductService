package com.project.EcomProductService.repository;

import com.project.EcomProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product findProductByTitle(String title);

    Product findFirstProductByTitle(String title);

    List<Product> findByPriceBetween(double min , double max);

    List<Product> findProductByRating(double rating);
}
//write in camel case with attributes name properly, and JPA will write the sql queries
//and after "By" it should be the field name same as in our class.