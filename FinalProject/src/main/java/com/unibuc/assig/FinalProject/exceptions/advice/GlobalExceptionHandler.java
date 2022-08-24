package com.unibuc.assig.FinalProject.exceptions.advice;

import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({AnObjectNotFound.class})
    public String handle(AnObjectNotFound e)
    {
        return e.getMessage() + " at " + LocalDateTime.now();
    }


//    @ExceptionHandler({AnObjectNotFound.class})
//    public ResponseEntity<String> handle(AnObjectNotFound e)
//    {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(e.getMessage() + " at " + LocalDateTime.now());
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle(MethodArgumentNotValidException e)
    {
        return ResponseEntity.badRequest()
                .body("Invalid value: " + e.getFieldError().getRejectedValue() +
                " for field " + e.getFieldError().getField() +
                " with message "+ e.getFieldError().getDefaultMessage());

    }

}
