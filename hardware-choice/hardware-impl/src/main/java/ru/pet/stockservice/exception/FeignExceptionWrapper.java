package ru.pet.stockservice.exception;

import feign.FeignException;
import lombok.Getter;

public class FeignExceptionWrapper extends RuntimeException {

    @Getter
    private FeignException feignException;

    public FeignExceptionWrapper(FeignException feignException) {
        this.feignException = feignException;
    }

}