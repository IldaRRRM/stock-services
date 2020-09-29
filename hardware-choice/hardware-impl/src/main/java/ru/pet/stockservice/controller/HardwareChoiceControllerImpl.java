package ru.pet.stockservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.pet.stockservice.cotroller.HardwareChoiceController;
import ru.pet.stockservice.dto.UserOrderDto;
import ru.pet.stockservice.service.TreatmentOrder;

@RestController
@RequiredArgsConstructor
public class HardwareChoiceControllerImpl implements HardwareChoiceController {

    private final TreatmentOrder treatmentOrder;

    @Override
    public ResponseEntity<UserOrderDto> collectHardware(String username) {
        return ResponseEntity.ok(treatmentOrder.treatmentOrder(username));
    }
}
