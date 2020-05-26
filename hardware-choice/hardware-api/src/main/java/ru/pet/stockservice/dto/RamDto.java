package ru.pet.stockservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RamDto extends PcGearDto {
    private Long frequency;
    private Long gb;
    private Double powerConsuming;
}
