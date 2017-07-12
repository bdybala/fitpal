package com.example.fitpal.mappers;

import com.example.fitpal.dtos.ExerciseDto;
import com.example.fitpal.entities.Exercise;

public class ExerciseMapper implements EntityMapper<Exercise, ExerciseDto> {

    @Override
    public ExerciseDto map(Exercise exercise) {
        return ExerciseDto.builder()
                .id(exercise.getId())
                .exerciseName(exercise.getExerciseName())
                .kcalPerHour(exercise.getKcalPerHour())
                .build();
    }

    @Override
    public Exercise unmap(ExerciseDto exerciseDto) {
        return Exercise.builder()
                .id(exerciseDto.getId())
                .exerciseName(exerciseDto.getExerciseName())
                .kcalPerHour(exerciseDto.getKcalPerHour())
                .build();
    }
}
