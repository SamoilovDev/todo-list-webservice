package com.example.userwebservicewithdatabase.service;

import com.example.userwebservicewithdatabase.entity.UserEntity;
import com.example.userwebservicewithdatabase.exception.UserAlreadyExistException;
import com.example.userwebservicewithdatabase.exception.UserNotFoundException;
import com.example.userwebservicewithdatabase.model.User;
import com.example.userwebservicewithdatabase.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(@Autowired UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User with this name is already exists!");
        }
        userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {

        if (userRepo.findById(id).isPresent()) {
            throw new UserNotFoundException("Пользователь не найден");
        }

        UserEntity user = userRepo.findById(id).get();

        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
