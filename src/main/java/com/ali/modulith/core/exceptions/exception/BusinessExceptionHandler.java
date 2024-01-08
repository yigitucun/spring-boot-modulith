package com.ali.modulith.core.exceptions.exception;

import com.ali.modulith.core.exceptions.ExceptionDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> handleBusinessException(BusinessException businessException){
        ExceptionDetails details = new ExceptionDetails();
        details.setMessage(businessException.getMessage());
        details.setCode(businessException.getStatus().value());
        details.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(details,businessException.getStatus());
    }
}
