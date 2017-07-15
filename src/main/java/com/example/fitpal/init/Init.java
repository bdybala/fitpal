package com.example.fitpal.init;

import com.example.fitpal.entities.Exercise;
import com.example.fitpal.entities.Product;
import com.example.fitpal.entities.User;
import com.example.fitpal.enums.Gender;
import com.example.fitpal.enums.Role;
import com.example.fitpal.repositories.ExerciseRepository;
import com.example.fitpal.repositories.ProductRepository;
import com.example.fitpal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class Init {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;

    @PostConstruct
    public void initAll() {
        initUser();
        initProducts();
        initExercise();
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

    private void initProducts() {
        if (!productRepository.existsByProductName("Jajko")) {
            productRepository.save(Product.builder()
                    .productName("Jajko")
                    .kcal(123)
                    .protein(234)
                    .fat(345)
                    .build());
        }
        if (!productRepository.existsByProductName("Pizza")) {
            productRepository.save(Product.builder()
                    .productName("Pizza")
                    .kcal(321)
                    .protein(432)
                    .fat(543)
                    .build());
        }
        if (!productRepository.existsByProductName("Hamburger")) {
            productRepository.save(Product.builder()
                    .productName("Hamburger")
                    .kcal(654)
                    .protein(543)
                    .fat(432)
                    .build());
        }
    }

    private void initExercise() {
        if (!exerciseRepository.existsByExerciseName("Jogging")) {
            exerciseRepository.save(Exercise.builder()
                    .exerciseName("Jogging")
                    .kcalPerHour(100D)
                    .build());
        }
        if (!exerciseRepository.existsByExerciseName("Pilka nożna")) {
            exerciseRepository.save(Exercise.builder()
                    .exerciseName("Pilka nożna")
                    .kcalPerHour(100D)
                    .build());
        }
        if (!exerciseRepository.existsByExerciseName("Rower")) {
            exerciseRepository.save(Exercise.builder()
                    .exerciseName("Rower")
                    .kcalPerHour(100D)
                    .build());
        }
    }

}
