package ru.pet.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pet.stockservice.model.Hdd;

@Repository
public interface HddRepository extends JpaRepository<Hdd, Long> {
}
