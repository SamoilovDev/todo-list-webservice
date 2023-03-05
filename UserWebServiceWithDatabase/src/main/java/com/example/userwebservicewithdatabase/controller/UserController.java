package com.example.userwebservicewithdatabase.controller;

import com.example.userwebservicewithdatabase.entity.UserEntity;
import com.example.userwebservicewithdatabase.model.User;
import com.example.userwebservicewithdatabase.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> registration(@RequestBody UserEntity user) {
        userService.registration(user);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<User> getOneUser(@RequestBody Long id) {
        return ResponseEntity.ok(userService.getOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }
}
