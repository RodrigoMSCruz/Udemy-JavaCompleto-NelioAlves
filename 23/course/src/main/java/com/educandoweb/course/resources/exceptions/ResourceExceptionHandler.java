package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFound e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        
        return ResponseEntity.status(status).body(err);
    }
}
