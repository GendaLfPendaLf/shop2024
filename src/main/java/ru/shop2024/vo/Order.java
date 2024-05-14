package ru.shop2024.vo;

import jakarta.persistence.*;
import ru.shop2024.user.model.User;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Другие поля, связанные с заказом, такие как список товаров, дата заказа и т.д.

    // Конструкторы, геттеры и сеттеры
}
