package ru.shop2024.basket;

import ru.shop2024.product.Product;

import java.util.UUID;

public class BasketItem {
    private UUID id;
    private Product product;
    private int quantity;

    public BasketItem() {
    }

    public BasketItem(Product product, int quantity) {
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

