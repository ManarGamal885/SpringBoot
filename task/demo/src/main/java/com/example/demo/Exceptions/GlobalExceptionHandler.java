package com.example.demo.Exceptions;

import com.example.demo.Exceptions.DTOs.AuthorHasBooksExceptionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AuthorHasBooksException.class)
    public ResponseEntity<AuthorHasBooksExceptionDto> handleAuthorHasBooksException(AuthorHasBooksException e) {
        AuthorHasBooksExceptionDto response = new AuthorHasBooksExceptionDto(e.getMessage());
        logger.error("Exception: ", e);
        return ResponseEntity.status(response.status()).body(response);
    }
}