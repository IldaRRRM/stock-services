package ru.pet.stockservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "ram", schema = "hardware")
public class Ram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "price")
    protected Double price;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    protected Company company;
    @Column(name = "name")
    protected String name;
    @Column(name = "frequency")
    private Long frequency;
    @Column(name = "gb")
    private Long gb;
    @Column(name = "power_consuming")
    private Double powerConsuming;
}