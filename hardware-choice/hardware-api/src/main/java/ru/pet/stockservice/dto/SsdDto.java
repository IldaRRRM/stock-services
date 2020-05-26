package ru.pet.stockservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SsdDto extends PcGearDto {
    private Long gb;
}
