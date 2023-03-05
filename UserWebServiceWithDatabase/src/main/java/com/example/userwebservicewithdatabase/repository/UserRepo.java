package com.example.userwebservicewithdatabase.repository;

import com.example.userwebservicewithdatabase.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

}
