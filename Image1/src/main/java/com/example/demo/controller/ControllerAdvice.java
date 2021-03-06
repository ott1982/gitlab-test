package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class ControllerAdvice {
    private static final Logger logger = LoggerFactory
            .getLogger(ControllerAdvice.class);

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("catched in controller advice", e);
        return new ResponseEntity<>(Optional.ofNullable(e.getMessage())
                .orElse("unknown message"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
