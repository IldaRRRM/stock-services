package ru.pet.stockservice.exception.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.pet.stockservice.exception.FeignExceptionWrapper;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class UserProfileExceptionHandler {

    @ExceptionHandler(FeignExceptionWrapper.class)
    @ResponseBody
    public ResponseEntity handleUserProfileHandlerException(FeignExceptionWrapper feignExceptionWrapper) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(feignExceptionWrapper.getFeignException().content());
    }
}