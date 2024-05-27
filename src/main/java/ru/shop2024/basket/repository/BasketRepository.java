package ru.shop2024.basket.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shop2024.basket.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
    // Дополнительные методы, если необходимо
}

