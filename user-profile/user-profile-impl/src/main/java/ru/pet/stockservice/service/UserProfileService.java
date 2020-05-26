package ru.pet.stockservice.service;


import ru.pet.stockservice.dto.UserProfileDto;

public interface UserProfileService {

    UserProfileDto findUserProfile(String username);

    UserProfileDto createUserProfile(String username);

}
