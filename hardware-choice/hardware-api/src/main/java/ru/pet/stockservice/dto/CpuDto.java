package ru.pet.stockservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CpuDto extends PcGearDto {
    private Double powerConsuming;
    private Double frequency;
}
