package ru.shop2024.order;

import jakarta.persistence.*;
import ru.shop2024.user.model.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private List<OrderItem> items = new ArrayList<>();

    // Конструкторы
    public Order(User user, List<OrderItem> items) {
        this.user = user;
        this.items = items;
    }

    public Order() {
    }

    public Order(User user) {
        this.user = user;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
