package com.example.fitpal.services.impl;

import com.example.fitpal.dtos.LoginDto;
import com.example.fitpal.dtos.NewUserDto;
import com.example.fitpal.dtos.UserDto;
import com.example.fitpal.entities.User;
import com.example.fitpal.exceptions.EntityNotFoundException;
import com.example.fitpal.mappers.NewUserMapper;
import com.example.fitpal.mappers.UserMapper;
import com.example.fitpal.repositories.UserRepository;
import com.example.fitpal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NewUserMapper newUserMapper;


    @Override
    public List<UserDto> findAll() {
        return userMapper.map(userRepository.findAll());
    }

    @Override
    public UserDto findOne(Long id) { return userMapper.map(userRepository.findOne(id)); }

    @Override
    public UserDto save(NewUserDto newUserDto) {
        return userMapper.map(userRepository.save(newUserMapper.unmap(newUserDto)));
    }

    @Override
    public UserDto edit(UserDto userDto) throws EntityNotFoundException {
        User user = Optional.ofNullable(userRepository.findOne(userDto.getId()))
                .orElseThrow(() -> new EntityNotFoundException());
        return userMapper.map(userRepository.save(updateUser(user, userDto)));
    }

    private User updateUser(User user, UserDto userDto) {
        if (userDto.getBirthday()!= null)
            user.setBirthday(userDto.getBirthday());
        if (userDto.getFirstName() != null)
            user.setFirstName(userDto.getFirstName());
        if (userDto.getSurname() != null)
            user.setSurname(userDto.getSurname());
        if (userDto.getGender() != null)
            user.setGender(userDto.getGender());
        if (userDto.getHeight() != null)
            user.setHeight(userDto.getHeight());
        if (userDto.getMass() != null)
            user.setMass(userDto.getMass());
        if (userDto.getMassToLoseWeight() != null)
            user.setMassToLoseWeight(userDto.getMassToLoseWeight());
        if (userDto.getDesiredIntervalToLoseWeight() != null)
            user.setDesiredIntervalToLoseWeight(userDto.getDesiredIntervalToLoseWeight());
        return user;
    }

    @Override
    public void remove(Long id) throws EntityNotFoundException {
        userRepository.delete(Optional.ofNullable(userRepository.findOne(id)).orElseThrow(()
                -> new EntityNotFoundException("")));
    }

    @Override
    public boolean authenticate(LoginDto loginDto) throws EntityNotFoundException {
        User user = Optional.ofNullable(userRepository.findByLogin(loginDto.getLogin()))
                .orElseThrow(() -> new EntityNotFoundException("User with that login doesn't exist!"));
        return user.getPassword().equals(loginDto.getPassword());
    }
}
