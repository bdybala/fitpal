package com.example.fitpal.repositories;

import com.example.fitpal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(@NotNull String login);
    boolean existsByLogin(@NotNull String login);
}
