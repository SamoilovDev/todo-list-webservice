package com.example.userwebservicewithdatabase.model;

import com.example.userwebservicewithdatabase.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    private Long id;

    private String title;

    private Boolean completed;

    private String description;

    public static Todo toModel(TodoEntity entity) {
        return Todo.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .completed(entity.getCompleted())
                .description(entity.getDescription())
                .build();
    }

}
