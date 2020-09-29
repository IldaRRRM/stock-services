package ru.pet.stockservices.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.pet.stockservices.exception.wrapper.FeignExceptionWrapper;

@ControllerAdvice
public class UserProfileCreateExceptionHandler {
    @ExceptionHandler(FeignExceptionWrapper.class)
    @ResponseBody
    public ResponseEntity handleUserProfileHandlerException(FeignExceptionWrapper feignExceptionWrapper) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(feignExceptionWrapper.getFeignException().content());
    }
}
