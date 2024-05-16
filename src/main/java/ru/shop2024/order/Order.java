package ru.shop2024.order;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    // ...

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    public Collection<OrderItem> getItems() {

    }

    // Конструкторы, геттеры и сеттеры
}
