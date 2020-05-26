package ru.pet.stockservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HddDto extends PcGearDto {
    private Integer gb;
}
