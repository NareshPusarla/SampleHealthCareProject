package com.hospital.SampleHealthCare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> usernameNotFound(UsernameNotFoundException usernameNotFoundException){
//        log.error(usernameNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usernameNotFoundException.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentials(BadCredentialsException badCredentialsException){
//        log.error(badCredentialsException.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(badCredentialsException.getMessage());
    }
    
    
    
}
