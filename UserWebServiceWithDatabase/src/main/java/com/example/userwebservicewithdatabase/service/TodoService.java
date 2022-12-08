package com.example.userwebservicewithdatabase.service;

import com.example.userwebservicewithdatabase.entity.TodoEntity;
import com.example.userwebservicewithdatabase.entity.UserEntity;
import com.example.userwebservicewithdatabase.model.Todo;
import com.example.userwebservicewithdatabase.repository.TodoRepo;
import com.example.userwebservicewithdatabase.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepo todoRepo;

    private final UserRepo userRepo;

    public TodoService(@Autowired TodoRepo todoRepo, UserRepo userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }

}
