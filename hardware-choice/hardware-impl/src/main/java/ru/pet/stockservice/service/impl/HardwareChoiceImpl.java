package ru.pet.stockservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.pet.stockservice.dto.HardwareDto;
import ru.pet.stockservice.dto.UserProfileDto;
import ru.pet.stockservice.service.HardwareChoice;

@Service
@Slf4j
public class HardwareChoiceImpl implements HardwareChoice {
    @Override
    public HardwareDto pickHardware(UserProfileDto userProfileDto) {
        log.info("Реализация подбора");
        return new HardwareDto();
    }
}
