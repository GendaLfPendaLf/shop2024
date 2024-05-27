package ru.shop2024.basket;


import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import ru.shop2024.order.Order;

import java.util.List;

public class Basket {
    private Long basketId;
    private List<Long> productIds;
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "basket_id")
    private List<BasketItem> items;

    @OneToOne(mappedBy = "basket")
    private Order order;

    public List<BasketItem> getItems() {
        return items;
    }

    // Конструкторы, геттеры и сеттеры
}

