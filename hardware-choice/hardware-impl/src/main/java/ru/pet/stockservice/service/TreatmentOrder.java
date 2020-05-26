package ru.pet.stockservice.service;

import ru.pet.stockservice.dto.UserOrderDto;

public interface TreatmentOrder {

    public UserOrderDto treatmentOrder(String username);

}
