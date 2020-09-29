package ru.pet.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pet.stockservice.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
