package ru.shop2024.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shop2024.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Дополнительные методы, если необходимо
}
