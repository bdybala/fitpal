package com.example.fitpal.repositories;

import com.example.fitpal.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Exercise findByExerciseName(String exerciseName);
    boolean existsByExerciseName(String exerciseName);
}
