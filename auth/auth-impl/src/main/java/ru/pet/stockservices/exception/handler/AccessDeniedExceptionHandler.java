package ru.pet.stockservices.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccessDeniedExceptionHandler {

    private final String ACCESS_DENIED_EXCEPTION_MSG = "Not enough permissions";

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ACCESS_DENIED_EXCEPTION_MSG);
    }
}
