package com.example.fitpal.services;

import com.example.fitpal.dtos.ExerciseDto;

import java.util.List;

public interface ExerciseService {

    List<ExerciseDto> findAll();
    ExerciseDto findOne(Long id);
    ExerciseDto save(ExerciseDto exerciseDto);
    ExerciseDto edit(ExerciseDto exerciseDto);
    void remove(Long id);
}
