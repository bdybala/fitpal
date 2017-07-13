package com.example.fitpal.controllers;

import com.example.fitpal.dtos.InputDataDto;
import com.example.fitpal.dtos.KcalAndProductsAndExercisesDto;
import com.example.fitpal.services.CalculationsService;
import com.example.fitpal.services.ExerciseService;
import com.example.fitpal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculations")
public class CalculationsController {

    @Autowired
    private CalculationsService calculationsService;
    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public KcalAndProductsAndExercisesDto calculateKcal(@RequestBody InputDataDto inputDataDto) {

        KcalAndProductsAndExercisesDto bundle = KcalAndProductsAndExercisesDto.builder()
                .kcal(calculationsService.calculateKcal(inputDataDto))
                .exercises(exerciseService.findAll())
                .products(productService.findAll())
                .build();

        return bundle;
    }

}
