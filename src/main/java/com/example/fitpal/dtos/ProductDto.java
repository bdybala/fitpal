package com.example.fitpal.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String productName;

    private Integer kcal;
    private Integer protein;
    private Integer fat;
}
