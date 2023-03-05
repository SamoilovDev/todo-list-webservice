package com.example.userwebservicewithdatabase.model;

import com.example.userwebservicewithdatabase.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String username;

    private List<Todo> todos;

    public static User toModel(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .todos(
                        entity.getTodos().stream()
                                .map(Todo::toModel)
                                .collect(Collectors.toList())
                )
                .build();
    }

}
