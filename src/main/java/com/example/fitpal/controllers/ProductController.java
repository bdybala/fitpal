package com.example.fitpal.controllers;

import com.example.fitpal.dtos.ProductDto;
import com.example.fitpal.dtos.UserDto;
import com.example.fitpal.exceptions.EntityNotFoundException;
import com.example.fitpal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDto> findAll() { return productService.findAll(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductDto findOne(@PathVariable("id") Long id) { return productService.findOne(id); }

    @RequestMapping(method = RequestMethod.POST)
    public ProductDto create(@RequestBody ProductDto productDto) { return productService.save(productDto); }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ProductDto edit(@PathVariable("id") Long id, @RequestBody ProductDto productDto)
            throws EntityNotFoundException
    { return productService.edit(productDto); }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") Long id)
            throws EntityNotFoundException
    { productService.remove(id); }


}
