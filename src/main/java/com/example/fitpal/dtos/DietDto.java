package com.example.fitpal.dtos;

import com.example.fitpal.entities.Product;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietDto {

    private Long id;
    private String dietName;

    private List<Product> products;
}
