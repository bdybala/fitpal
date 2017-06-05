package com.example.fitpal.mappers;

import com.example.fitpal.dtos.ProductDto;
import com.example.fitpal.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements EntityMapper<Product, ProductDto> {

    @Override
    public ProductDto map(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .kcal(product.getKcal())
                .protein(product.getProtein())
                .fat(product.getFat())
                .build();
    }

    @Override
    public Product unmap(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .productName(productDto.getProductName())
                .kcal(productDto.getKcal())
                .protein(productDto.getProtein())
                .fat(productDto.getFat())
                .build();
    }
}
