package ru.pet.stockservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.pet.stockservice.dto.UserProfileDto;

@RequestMapping(path = "/profile/")
public interface UserProfileController {

    @RequestMapping(value = "{username}", method = RequestMethod.GET)
    ResponseEntity<UserProfileDto> findUserProfile(@PathVariable("username") String username);

    @RequestMapping(value = "create/{username}", method = RequestMethod.POST)
    ResponseEntity<UserProfileDto> createUserProfileByUsername(@PathVariable("username") String username);
}