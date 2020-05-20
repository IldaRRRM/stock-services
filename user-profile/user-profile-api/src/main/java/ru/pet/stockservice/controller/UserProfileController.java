package ru.pet.stockservice.controller;

import dto.UserProfileDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/profile/")
public interface UserProfileController {

    @GetMapping(value = "{username}")
    ResponseEntity<UserProfileDto> findUserProfile(@PathVariable String username);

}