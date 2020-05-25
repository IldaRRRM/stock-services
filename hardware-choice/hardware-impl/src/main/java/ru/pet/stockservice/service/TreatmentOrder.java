package ru.pet.stockservice.service;

import ru.pet.stockservice.dto.HardwareDto;

public interface TreatmentOrder {

    public HardwareDto treatmentOrder(String username);

}
