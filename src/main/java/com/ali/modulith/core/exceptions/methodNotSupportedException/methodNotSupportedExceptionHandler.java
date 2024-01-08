package com.ali.modulith.core.exceptions.methodNotSupportedException;

import com.ali.modulith.core.exceptions.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class methodNotSupportedExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        ExceptionDetails exceptionDetails = new ExceptionDetails();
        exceptionDetails.setMessage("İstenen metot, istenen kaynak için izin verilmiyor.");
        exceptionDetails.setTimestamp(System.currentTimeMillis());
        exceptionDetails.setCode(HttpStatus.METHOD_NOT_ALLOWED.value());
        return new ResponseEntity<>(exceptionDetails,HttpStatus.METHOD_NOT_ALLOWED);
    }

}
