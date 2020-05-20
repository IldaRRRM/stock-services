package ru.pet.stockservice.service;

import dto.UserProfileDto;

public interface UserProfileService {

    UserProfileDto findUserProfile(String username);

}
