package ru.shop2024.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shop2024.vo.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Дополнительные методы, если необходимо
}
