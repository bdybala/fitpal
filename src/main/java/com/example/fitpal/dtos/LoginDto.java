package com.example.fitpal.dtos;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private String login;
    private String password;
}
