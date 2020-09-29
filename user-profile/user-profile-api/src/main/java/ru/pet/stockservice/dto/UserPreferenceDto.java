package ru.pet.stockservice.dto;

import lombok.Data;

@Data
public class UserPreferenceDto {
    private Long id;
    private String name;
    private PriorityPreferenceDto priority;
}
