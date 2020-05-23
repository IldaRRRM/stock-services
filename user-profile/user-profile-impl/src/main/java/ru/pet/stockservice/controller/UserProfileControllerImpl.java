package ru.pet.stockservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.pet.stockservice.dto.UserProfileDto;
import ru.pet.stockservice.service.UserProfileService;

@RestController
@RequiredArgsConstructor
public class UserProfileControllerImpl implements UserProfileController {

    private final UserProfileService userProfileService;

    @Override
    public ResponseEntity<UserProfileDto> findUserProfile(String username) {
        return ResponseEntity.ok(userProfileService.findUserProfile(username));
    }
}
