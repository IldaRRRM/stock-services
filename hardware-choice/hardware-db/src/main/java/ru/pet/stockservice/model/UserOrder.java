package ru.pet.stockservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_order", schema = "hardware")
@Data
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @ManyToOne
    @JoinColumn(name = "cpu_id")
    private Cpu processor;
    @ManyToOne
    @JoinColumn(name = "gpu_id")
    private Gpu gpu;
    @ManyToOne
    @JoinColumn(name = "ram_id")
    private Ram ram;
    @ManyToOne
    @JoinColumn(name = "cooling_id")
    private Cooling cooling;
    @ManyToOne
    @JoinColumn(name = "ssd_id")
    private Ssd ssd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hdd_id")
    private Hdd hdd;
    @ManyToOne
    @JoinColumn(name = "power_supplier_id")
    private PowerSupplier powerSupplier;
}