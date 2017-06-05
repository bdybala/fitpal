package com.example.fitpal.services.impl;

import com.example.fitpal.dtos.ProductDto;
import com.example.fitpal.entities.Product;
import com.example.fitpal.mappers.ProductMapper;
import com.example.fitpal.repositories.ProductRepository;
import com.example.fitpal.services.ProductService;
import com.example.fitpal.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> findAll() {
        return productMapper.map(productRepository.findAll());
    }

    @Override
    public ProductDto findOne(Long id) {
        return productMapper.map(productRepository.findOne(id));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return productMapper.map(productRepository.save(productMapper.unmap(productDto)));
    }

    @Override
    public ProductDto edit(ProductDto productDto) throws EntityNotFoundException {
        Product product = Optional.ofNullable(productRepository.findOne(productDto.getId()))
                .orElseThrow(() -> new EntityNotFoundException("Product with that id not found! :" + productDto.getId()));
        return productMapper.map(productRepository.save(updateProduct(product, productDto)));

    }

    private Product updateProduct(Product product, ProductDto productDto) {
        if (productDto.getProductName() != null)
            product.setProductName(productDto.getProductName());
        if (productDto.getKcal() != null)
            product.setKcal(productDto.getKcal());
        if (productDto.getProtein() != null)
            product.setProtein(productDto.getProtein());
        if (productDto.getFat() != null)
            product.setFat(product.getFat());
        return product;
    }

    @Override
    public void remove(Long id) throws EntityNotFoundException {
        Product product = Optional.ofNullable(productRepository.findOne(id)).orElseThrow(()
                -> new EntityNotFoundException("Product with that id not found! :" + id));
        productRepository.delete(product);
    }
}
