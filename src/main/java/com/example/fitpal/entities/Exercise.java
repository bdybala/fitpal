package com.example.fitpal.entities;

import lombok.*;

import javax.persistence.*;

import static com.example.fitpal.config.Constants.DB_PREFIX;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = DB_PREFIX + "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String exerciseName;
    private Double kcalPerHour;
}
