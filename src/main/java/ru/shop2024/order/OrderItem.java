package ru.shop2024.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import ru.shop2024.product.Product;

import java.util.UUID;

//В этом классе:
//id - уникальный идентификатор элемента заказа/корзины (можно использовать UUID или Long).
//product - ссылка на объект Product, представляющий продукт в заказе/корзине.
//quantity - количество единиц данного продукта в заказе/корзине.

@Entity
public class OrderItem {
    @Id
    private UUID id;
    private Product product;
    private int quantity;

    public OrderItem() {
    }

    @ManyToOne
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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


