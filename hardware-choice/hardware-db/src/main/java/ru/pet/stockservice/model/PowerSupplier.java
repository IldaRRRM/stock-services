package ru.pet.stockservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "power_supplier", schema = "hardware")
public class PowerSupplier extends PcGear {
    @Column(name = "power")
    private Integer power;
}