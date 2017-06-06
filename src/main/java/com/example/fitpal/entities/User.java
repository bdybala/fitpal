package com.example.fitpal.entities;

import com.example.fitpal.enums.Gender;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.DoubleSummaryStatistics;

import static com.example.fitpal.config.Constants.DB_PREFIX;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = DB_PREFIX + "person")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String surname;
    private Integer age;
    private Gender gender;
    private Double mass;
    private Double height;

    private Double massToLoseWeight;
    private Double desiredIntervalToLoseWeight;
}
