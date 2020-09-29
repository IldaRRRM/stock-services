package ru.pet.stockservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cooling", schema = "hardware")
public class Cooling extends PcGear {
}

