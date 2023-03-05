package com.example.userwebservicewithdatabase.service;

import com.example.userwebservicewithdatabase.entity.TodoEntity;
import com.example.userwebservicewithdatabase.entity.UserEntity;
import com.example.userwebservicewithdatabase.exception.TodoNotFoundException;
import com.example.userwebservicewithdatabase.exception.UserNotFoundException;
import com.example.userwebservicewithdatabase.model.Todo;
import com.example.userwebservicewithdatabase.repository.TodoRepo;
import com.example.userwebservicewithdatabase.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class TodoService {

    @Autowired
    private final TodoRepo todoRepo;

    @Autowired
    private final UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        return Todo.toModel(
                userRepo.save(user).getTodos()
                        .stream()
                        .filter(todoEntity -> Objects.equals(todoEntity.getId(), todo.getId()))
                        .findAny()
                        .orElse(todo)
        );
    }

    public Todo complete(Long id) {
        TodoEntity todo = todoRepo.findById(id)
                .orElseThrow(TodoNotFoundException::new);
        todo.setCompleted(!todo.getCompleted());

        return Todo.toModel(todoRepo.save(todo));
    }

}
