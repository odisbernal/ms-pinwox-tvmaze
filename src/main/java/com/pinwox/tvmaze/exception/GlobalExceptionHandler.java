package com.pinwox.tvmaze.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pinwox.tvmaze.dto.response.GenericResponseDTO;
import com.pinwox.tvmaze.util.ResponseBuilder;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponseDTO<Object>> handleException(
            Exception ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        ResponseBuilder.error(
                                ex.getMessage(),
                                HttpStatus.NOT_FOUND.value()));
    }

}
