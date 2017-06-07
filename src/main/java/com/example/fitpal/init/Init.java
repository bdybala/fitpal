package com.example.fitpal.init;

import com.example.fitpal.config.Constants;
import com.example.fitpal.entities.Role;
import com.example.fitpal.entities.User;
import com.example.fitpal.enums.Gender;
import com.example.fitpal.repositories.RoleRepository;
import com.example.fitpal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Init {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void initAll() {
        initRole();
        initUser();
    }

    private void initRole() {

        if(!roleRepository.existsByRoleName(Constants.ROLE_ADMIN)) {
            roleRepository.save(Role.builder()
                    .roleName(Constants.ROLE_ADMIN)
                    .build());
        }
        if(!roleRepository.existsByRoleName(Constants.ROLE_USER)) {
            roleRepository.save(Role.builder()
                    .roleName(Constants.ROLE_USER)
                    .build());
        }
    }

    private void initUser() {
        if (!userRepository.existsByLogin("user")) {
            userRepository.save(User.builder()
                    .age(18)
                    .login("user")
                    .password("password")
                    .firstName("firstName")
                    .surname("surname")
                    .gender(Gender.MALE)
                    .height(180D)
                    .mass(55D)
                    .role(roleRepository.findByRoleName(Constants.ROLE_USER))
                    .build());
        }
    }
}
