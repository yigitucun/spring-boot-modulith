package com.ali.modulith.core.exceptions.validationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException e){
        ValidationExceptionDetails details = new ValidationExceptionDetails();
        details.setTimestamp(System.currentTimeMillis());
        details.setValidationErrors(new HashMap<>());
        details.setCode(HttpStatus.BAD_REQUEST.value());
        for (FieldError fieldError:e.getBindingResult().getFieldErrors()){
            details.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);

    }
}
