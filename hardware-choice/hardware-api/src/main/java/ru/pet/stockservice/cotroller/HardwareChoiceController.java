package ru.pet.stockservice.cotroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pet.stockservice.dto.UserOrderDto;

@RequestMapping(path = "/hardware/")
public interface HardwareChoiceController {

    @GetMapping(value = "collect/{username}")
    ResponseEntity<UserOrderDto> collectHardware(@PathVariable(name = "username") String username);
}
