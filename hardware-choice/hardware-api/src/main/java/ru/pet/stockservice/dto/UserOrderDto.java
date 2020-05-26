package ru.pet.stockservice.dto;

import lombok.Data;

@Data
public class UserOrderDto {

    private Long id;
    private String username;
    private CpuDto cpu;
    private GpuDto gpu;
    private RamDto ram;
    private CoolingDto cooling;
    private SsdDto ssd;
    private HddDto hdd;
    private PowerSupplierDto powerSupplier;

}