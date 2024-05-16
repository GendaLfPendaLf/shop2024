package ru.shop2024.order;

import ru.shop2024.controller.Product;

import java.util.UUID;

//В этом классе:
//id - уникальный идентификатор элемента заказа/корзины (можно использовать UUID или Long).
//product - ссылка на объект Product, представляющий продукт в заказе/корзине.
//quantity - количество единиц данного продукта в заказе/корзине.

public class OrderItem {
    private UUID id;
    private Product product;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


