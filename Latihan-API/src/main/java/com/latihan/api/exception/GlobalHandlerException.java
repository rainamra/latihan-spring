package com.latihan.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> message(UserException userException) {
        return new ResponseEntity<>(userException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
