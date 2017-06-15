package com.example.fitpal.dtos;

import com.example.fitpal.enums.Gender;
import com.example.fitpal.enums.Role;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String surname;
    private Date birthday;
    private Gender gender;
    private Double mass;
    private Double height;

    private Double massToLoseWeight;
    private Double desiredIntervalToLoseWeight;

    private Role role;
}
