package ru.pet.stockservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserProfileDto {
    private Long id;
    private String username;
    private Double balance;
    private Double purchaseBudget;
    private Integer age;
    private List<UserPreferenceDto> userPreferences;
}
