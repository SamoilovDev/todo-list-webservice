package com.example.userwebservicewithdatabase.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todos;
}
