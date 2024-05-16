package ru.shop2024.basket;


import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Basket {
    private Long basketId;
    private List<Long> productIds;
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "basket_id")
    private List<BasketItem> items;

    // Конструкторы, геттеры и сеттеры
}

