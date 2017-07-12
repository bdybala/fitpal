package com.example.fitpal.controllers;

import com.example.fitpal.dtos.ExerciseDto;
import com.example.fitpal.exceptions.EntityNotFoundException;
import com.example.fitpal.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController{

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ExerciseDto> findAll() { return exerciseService.findAll(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ExerciseDto findOne(@PathVariable("id") Long id) { return  exerciseService.findOne(id); }

    @RequestMapping(method = RequestMethod.POST)
    public ExerciseDto create(@RequestBody ExerciseDto exerciseDto) { return exerciseService.save(exerciseDto); }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ExerciseDto edit(@PathVariable("id") Long id, @RequestBody ExerciseDto exerciseDto) throws EntityNotFoundException {
        return exerciseService.edit(exerciseDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") Long id) throws EntityNotFoundException {
        exerciseService.remove(id);
    }
}
