package ru.pet.stockservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PowerSupplierDto extends PcGearDto {
    private Integer power;

}

