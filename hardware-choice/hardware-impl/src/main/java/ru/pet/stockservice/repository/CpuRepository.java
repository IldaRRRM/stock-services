package ru.pet.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pet.stockservice.model.Cpu;

import java.util.List;

@Repository
public interface CpuRepository extends JpaRepository<Cpu, Long> {

    List<Cpu> findAllByPriceIsLessThanEqualOrderByPrice(Double price);

    List<Cpu> findAllByPriceIsGreaterThan(Double price);

}
