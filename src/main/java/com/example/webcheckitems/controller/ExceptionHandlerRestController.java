package com.example.webcheckitems.controller;

import com.example.webcheckitems.dto.ErrorResponse;
import com.example.webcheckitems.exception.EmptyTextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerRestController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> emptyTextException(EmptyTextException exception) {
        return ResponseEntity.status(400).body(new ErrorResponse(400, exception.getMessage()));
    }
}
