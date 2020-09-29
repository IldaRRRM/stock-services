package ru.pet.stockservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class GpuDto extends PcGearDto {
    private Integer gb;
    private Double powerConsuming;
}
