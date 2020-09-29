package ru.pet.stockservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "ssd", schema = "hardware")
public class Ssd extends PcGear {
    @Column(name = "gb")
    private Long gb;
}