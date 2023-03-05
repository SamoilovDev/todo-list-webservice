package com.example.userwebservicewithdatabase.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "User already exist!")
public class UserAlreadyExistException extends RuntimeException {
}
