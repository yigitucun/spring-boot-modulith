package com.ali.modulith.core.exceptions.methodArgumentTypeMismatchException;

import com.ali.modulith.core.exceptions.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ArgumentTypeMismatchExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        ExceptionDetails details = new ExceptionDetails();
        details.setCode(HttpStatus.BAD_REQUEST.value());
        details.setTimestamp(System.currentTimeMillis());
        details.setMessage("Geçersiz veri");
        return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
    }

}
