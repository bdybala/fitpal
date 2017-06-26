package com.example.fitpal.mappers;

import com.example.fitpal.dtos.NewUserDto;
import com.example.fitpal.entities.User;
import com.example.fitpal.enums.Gender;
import com.example.fitpal.enums.Role;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class NewUserMapper implements EntityMapper<User, NewUserDto> {

    @Override
    public NewUserDto map(User user) {
        //TODO ??
        return null;
    }

    @Override
    public User unmap(NewUserDto newUserDto) {
        return User.builder()
                .login(newUserDto.getLogin())
                .password(newUserDto.getPassword())
                .firstName(newUserDto.getFirstName())
                .surname(newUserDto.getLastName())
                .birthday(new Date(newUserDto.getBirthday()))
                .height(newUserDto.getHeight())
                .mass(newUserDto.getMass())
                .role(Role.ROLE_USER)
                .gender(Gender.MALE)
                .build();
    }
}
