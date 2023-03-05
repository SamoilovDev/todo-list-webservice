package com.example.userwebservicewithdatabase.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Todo doesn't exist!")
public class TodoNotFoundException extends RuntimeException {
}
