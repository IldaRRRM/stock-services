package ru.pet.stockservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "hdd", schema = "hardware")
public class Hdd extends PcGear {
    @Column(name = "gb")
    private Integer gb;
}
