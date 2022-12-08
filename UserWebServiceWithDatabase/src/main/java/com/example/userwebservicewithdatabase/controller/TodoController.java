package com.example.userwebservicewithdatabase.controller;

import com.example.userwebservicewithdatabase.entity.TodoEntity;
import com.example.userwebservicewithdatabase.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(@Autowired TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
