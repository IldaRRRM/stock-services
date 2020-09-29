package ru.pet.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pet.stockservice.model.UserOrder;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
}
