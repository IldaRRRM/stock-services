package ru.pet.stockservice.service;

import ru.pet.stockservice.dto.UserProfileDto;

import java.util.Map;

public interface DistributeBalanceByPref {

    public Map<String, Double> distribute(UserProfileDto userProfileDto);

}
