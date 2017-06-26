package com.example.fitpal.dtos;

import com.example.fitpal.enums.Gender;
import com.example.fitpal.enums.PhysicalActivity;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InputDataDto {

    private Double mass;
    private Double height;
    private Gender gender;
    private Integer age;
    private PhysicalActivity physicalActivity;
}
