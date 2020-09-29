package ru.pet.stockservices.exception.wrapper;

import feign.FeignException;
import lombok.Getter;

public class FeignExceptionWrapper extends RuntimeException {
    @Getter
    private FeignException feignException;

    public FeignExceptionWrapper(FeignException feignException) {
        this.feignException = feignException;
    }
}
