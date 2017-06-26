package com.example.fitpal.services;

import com.example.fitpal.dtos.LoginDto;
import com.example.fitpal.dtos.NewUserDto;
import com.example.fitpal.dtos.UserDto;
import com.example.fitpal.exceptions.EntityNotFoundException;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto findOne(Long id);
    UserDto save(NewUserDto newUserDto);
    UserDto edit(UserDto userDto) throws EntityNotFoundException;
    void remove(Long id) throws EntityNotFoundException;

    boolean authenticate(LoginDto loginDto) throws EntityNotFoundException;
}
