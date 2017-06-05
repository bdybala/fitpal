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

    private String kcal;
    private String protein;
    private String fat;
}
