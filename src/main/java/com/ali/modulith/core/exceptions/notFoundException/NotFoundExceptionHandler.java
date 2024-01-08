package com.ali.modulith.core.exceptions.notFoundException;

import com.ali.modulith.core.exceptions.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class NotFoundExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> handleNotFoundException(NoResourceFoundException e){
        ExceptionDetails details = new ExceptionDetails();
        details.setCode(HttpStatus.NOT_FOUND.value());
        details.setMessage("Aradığınız sayfa bulunamadı.");
        details.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
    }
}
