package ru.shop2024.basket;


import jakarta.persistence.*;
import ru.shop2024.order.Order;

import java.util.List;
@Entity
public class Basket {
    //@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private Long basketId;
   // private List<Long> productIds;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "basketId")
    private List<BasketItem> items;

    @OneToOne(mappedBy = "basket")
    private Order order;

    public List<BasketItem> getItems() {
        return items;
    }

    // Конструкторы, геттеры и сеттеры
}

