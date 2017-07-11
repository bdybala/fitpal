package com.example.fitpal.controllers;

import com.example.fitpal.dtos.InputDataDto;
import com.example.fitpal.services.CalculationsService;
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

    @RequestMapping(method = RequestMethod.POST)
    public Integer calculateKcal(@RequestBody InputDataDto inputDataDto) {

        Integer integer = calculationsService.calculateKcal(inputDataDto);
        System.out.println("calculated kcal: " + integer);
        return integer;
    }

}
