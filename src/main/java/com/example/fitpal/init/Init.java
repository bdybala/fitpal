package com.example.fitpal.init;

import com.example.fitpal.entities.User;
import com.example.fitpal.enums.Gender;
import com.example.fitpal.enums.Role;
import com.example.fitpal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class Init {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initAll() {
        initUser();
    }

    private void initUser() {
        if (!userRepository.existsByLogin("user")) {
            userRepository.save(User.builder()
                    .birthday(new Date())
                    .login("user")
                    .password("password")
                    .firstName("firstName")
                    .surname("surname")
                    .gender(Gender.MALE)
                    .height(180D)
                    .mass(55D)
                    .role(Role.ROLE_ADMIN)
                    .build());
        }
    }
}
