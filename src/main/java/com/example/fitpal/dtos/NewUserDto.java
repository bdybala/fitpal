package com.example.fitpal.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewUserDto {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Double height;
    private Double mass;
    private Long birthday;
}
