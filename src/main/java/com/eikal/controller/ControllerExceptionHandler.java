package com.eikal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> illegalStateHandler(IllegalStateException e, WebRequest request) {
        e.printStackTrace();
        return ResponseEntity.status(404).body("Bad Type, Error has occurred\nMessage: " + e.getMessage());
    }

}
