package ru.pet.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pet.stockservice.model.Ssd;

@Repository
public interface SsdRepository extends JpaRepository<Ssd, Long> {
}
