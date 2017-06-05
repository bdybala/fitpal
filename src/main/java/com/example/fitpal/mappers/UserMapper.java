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
                .age(user.getAge())
                .firstName(user.getFirstName())
                .height(user.getHeight())
                .mass(user.getMass())
                .surname(user.getSurname())
                .build();
    }

    @Override
    public User unmap(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .age(userDto.getAge())
                .firstName(userDto.getFirstName())
                .height(userDto.getHeight())
                .mass(userDto.getMass())
                .surname(userDto.getSurname())
                .build();
    }
}
