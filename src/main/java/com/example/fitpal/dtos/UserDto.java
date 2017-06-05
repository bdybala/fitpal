package com.example.fitpal.dtos;

import com.example.fitpal.enums.Gender;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String surname;
    private Integer age;
    private Gender gender;
    private Double mass;
    private Double height;

    private Double massToLoseWeight;
    private Double desiredIntervalToLoseWeight;
}
