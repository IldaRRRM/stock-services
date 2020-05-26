package ru.pet.stockservice.service;

import ru.pet.stockservice.dto.UserOrderDto;
import ru.pet.stockservice.dto.UserProfileDto;

public interface HardwareChoice {

    UserOrderDto pickHardware(UserProfileDto userProfileDto);

}
