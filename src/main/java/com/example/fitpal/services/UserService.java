package com.example.fitpal.services;

import com.example.fitpal.dtos.UserDto;
import com.example.fitpal.exceptions.EntityNotFoundException;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto findOne(Long id);
    UserDto save(UserDto userDto);
    UserDto edit(UserDto userDto) throws EntityNotFoundException;
    void remove(Long id) throws EntityNotFoundException;
}
