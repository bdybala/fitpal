package com.example.fitpal.repositories;

import com.example.fitpal.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;

public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsByRoleName(@NotNull String roleName);
    Role findByRoleName(@NotNull String roleName);
}
