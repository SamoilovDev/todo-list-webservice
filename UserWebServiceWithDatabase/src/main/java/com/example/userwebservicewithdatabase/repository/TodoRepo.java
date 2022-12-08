package com.example.userwebservicewithdatabase.repository;

import com.example.userwebservicewithdatabase.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
