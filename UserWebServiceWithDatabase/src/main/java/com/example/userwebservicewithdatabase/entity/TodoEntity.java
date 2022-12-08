package com.example.userwebservicewithdatabase.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
@NoArgsConstructor
@Data
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Boolean completed;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
