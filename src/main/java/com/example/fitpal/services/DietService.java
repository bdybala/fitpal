package com.example.fitpal.services;

import com.example.fitpal.dtos.DietDto;

import java.util.List;

public interface DietService {

    List<DietDto> findAll();
    DietDto findOne(Long id);
    DietDto save(DietDto dietDto);
    DietDto edit(DietDto dietDto);
    void remove(Long id);
}
