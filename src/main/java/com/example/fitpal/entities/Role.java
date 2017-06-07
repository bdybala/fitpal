package com.example.fitpal.entities;

import com.example.fitpal.config.Constants;
import lombok.*;

import javax.persistence.*;

import java.util.List;

import static com.example.fitpal.config.Constants.DB_PREFIX;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = DB_PREFIX + "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String roleName;

    @OneToMany
    private List<User> users;
}
