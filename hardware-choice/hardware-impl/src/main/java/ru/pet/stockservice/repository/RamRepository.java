package ru.pet.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pet.stockservice.model.Ram;

import java.util.List;

@Repository
public interface RamRepository extends JpaRepository<Ram, Long> {

    List<Ram> findAllByPriceLessThanEqualOrderByPrice(Double sum);

}
