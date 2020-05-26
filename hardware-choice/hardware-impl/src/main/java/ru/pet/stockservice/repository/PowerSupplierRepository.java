package ru.pet.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pet.stockservice.model.PowerSupplier;

@Repository
public interface PowerSupplierRepository extends JpaRepository<PowerSupplier, Long> {
}
