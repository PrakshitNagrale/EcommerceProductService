package com.project.EcomProductService.mapper;

import com.project.EcomProductService.dtos.ProductResponseDTO;
import com.project.EcomProductService.models.Product;

public class ProductEntityDTOMapper {

    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product){

        ProductResponseDTO responseDTO = new ProductResponseDTO();

        responseDTO.setProductId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setRating(product.getRating());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImageURL(product.getImageURL());
        responseDTO.setDescription(product.getDescription());

        return responseDTO;
    }
}
