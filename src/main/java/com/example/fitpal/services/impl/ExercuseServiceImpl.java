package com.example.fitpal.services.impl;

import com.example.fitpal.dtos.ExerciseDto;
import com.example.fitpal.entities.Exercise;
import com.example.fitpal.exceptions.EntityNotFoundException;
import com.example.fitpal.mappers.ExerciseMapper;
import com.example.fitpal.repositories.ExerciseRepository;
import com.example.fitpal.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ExercuseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private ExerciseMapper exerciseMapper;

    @Override
    public List<ExerciseDto> findAll() {
        return exerciseMapper.map(exerciseRepository.findAll());
    }

    @Override
    public ExerciseDto findOne(Long id) {
        return exerciseMapper.map(exerciseRepository.findOne(id));
    }

    @Override
    public ExerciseDto save(ExerciseDto exerciseDto) {
        return exerciseMapper.map(exerciseRepository.save(exerciseMapper.unmap(exerciseDto)));
    }

    @Override
    public ExerciseDto edit(ExerciseDto exerciseDto) throws EntityNotFoundException {
        Exercise exercise = Optional.ofNullable(exerciseRepository.findOne(exerciseDto.getId())).orElseThrow(
                () -> new EntityNotFoundException("Exercise with that id not found! :" + exerciseDto.getId()));
        return exerciseMapper.map(exerciseRepository.save(updateExercise(exercise, exerciseDto)));
    }

    private Exercise updateExercise(Exercise exercise, ExerciseDto exerciseDto) {
        if (exerciseDto.getExerciseName() != null)
            exercise.setExerciseName(exerciseDto.getExerciseName());
        if (exerciseDto.getKcalPerHour() != null)
            exercise.setKcalPerHour(exerciseDto.getKcalPerHour());
        return exercise;
    }

    @Override
    public void remove(Long id) throws EntityNotFoundException {
        Exercise exercise = Optional.ofNullable(exerciseRepository.findOne(id)).orElseThrow(
                () -> new EntityNotFoundException("Exercise with that id not found! :" + id));
        exerciseRepository.delete(exercise);
    }
}
