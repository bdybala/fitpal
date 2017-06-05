package com.example.fitpal.entities;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static com.example.fitpal.config.Constants.DB_PREFIX;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = DB_PREFIX + "diet")
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dietName;

    @ManyToMany
    private List<Product> products;
}
