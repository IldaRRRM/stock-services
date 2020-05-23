package ru.pet.stockservice.service;

import ru.pet.stockservice.dto.HardwareDto;
import ru.pet.stockservice.dto.UserProfileDto;

public interface HardwareChoice {

    HardwareDto pickHardware(UserProfileDto userProfileDto);

}
