package ru.pet.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pet.stockservice.model.Gpu;

import java.util.List;

@Repository
public interface GpuRepository extends JpaRepository<Gpu, Long> {

    List<Gpu> findAllByPriceIsLessThanEqualOrderByPrice(Double summ);

}
