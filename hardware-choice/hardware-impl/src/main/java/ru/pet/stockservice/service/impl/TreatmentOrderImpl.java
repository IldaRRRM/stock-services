package ru.pet.stockservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.pet.stockservice.client.UserProfileControllerFeign;
import ru.pet.stockservice.dto.UserOrderDto;
import ru.pet.stockservice.dto.UserProfileDto;
import ru.pet.stockservice.service.HardwareChoice;
import ru.pet.stockservice.service.TreatmentOrder;

@Service
@RequiredArgsConstructor
public class TreatmentOrderImpl implements TreatmentOrder {

    private final UserProfileControllerFeign userProfileControllerFeign;
    private final HardwareChoice hardwareChoice;

    @Override
    public UserOrderDto treatmentOrder(String username) {
        ResponseEntity<UserProfileDto> responseEntity = userProfileControllerFeign.findUserProfile(username);
        return hardwareChoice.pickHardware(responseEntity.getBody());
    }
}
