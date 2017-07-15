package com.example.fitpal.dtos;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KcalAndProductsAndExercisesDto {
    private Integer kcal;
    private List<ProductDto> products;
    private List<ExerciseDto> exercises;
}
