package com.example.propertyview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleException(ResourceNotFoundException e){
        return ExceptionDto.buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
