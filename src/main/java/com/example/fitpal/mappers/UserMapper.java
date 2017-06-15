package com.example.fitpal.mappers;

import com.example.fitpal.dtos.UserDto;
import com.example.fitpal.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements EntityMapper<User, UserDto> {

    @Override
    public UserDto map(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .surname(user.getSurname())
                .birthday(user.getBirthday())
                .gender(user.getGender())
                .mass(user.getMass())
                .height(user.getHeight())
                .role(user.getRole())
                .build();
    }

    @Override
    public User unmap(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .firstName(userDto.getFirstName())
                .surname(userDto.getSurname())
                .birthday(userDto.getBirthday())
                .gender(userDto.getGender())
                .mass(userDto.getMass())
                .height(userDto.getHeight())
                .role(userDto.getRole())
                .build();
    }
}
