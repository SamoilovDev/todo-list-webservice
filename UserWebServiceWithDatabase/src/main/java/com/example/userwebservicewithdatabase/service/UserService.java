package com.example.userwebservicewithdatabase.service;

import com.example.userwebservicewithdatabase.entity.UserEntity;
import com.example.userwebservicewithdatabase.exception.UserAlreadyExistException;
import com.example.userwebservicewithdatabase.exception.UserNotFoundException;
import com.example.userwebservicewithdatabase.model.User;
import com.example.userwebservicewithdatabase.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepo userRepo;

    public void registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistException();
        } else userRepo.save(user);
    }

    public User getOne(Long id) {
        return userRepo.findById(id).map(User::toModel)
                .orElseThrow(UserNotFoundException::new);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }

}
