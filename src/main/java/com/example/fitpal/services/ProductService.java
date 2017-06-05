package com.example.fitpal.services;

import com.example.fitpal.dtos.ProductDto;
import com.example.fitpal.exceptions.EntityNotFoundException;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();
    ProductDto findOne(Long id);
    ProductDto save(ProductDto productDto);
    ProductDto edit(ProductDto productDto) throws EntityNotFoundException;
    void remove(Long id) throws EntityNotFoundException;
}
