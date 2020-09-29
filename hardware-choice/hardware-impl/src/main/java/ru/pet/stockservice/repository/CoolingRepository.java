package ru.pet.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pet.stockservice.model.Cooling;

@Repository
public interface CoolingRepository extends JpaRepository<Cooling, Long> {
}
