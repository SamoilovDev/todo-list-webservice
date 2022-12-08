package com.example.userwebservicewithdatabase.repository;

import com.example.userwebservicewithdatabase.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
