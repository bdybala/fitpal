package com.example.fitpal.dtos;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDto {

    private Long id;
    private String exerciseName;
    private Double kcalPerHour;
}
