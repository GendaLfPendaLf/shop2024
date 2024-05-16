package ru.shop2024.order.service;

import ru.shop2024.product.Product;
import ru.shop2024.order.Order;
import ru.shop2024.order.OrderItem;

import java.util.UUID;


public OrderItem addOrderItem(Order order, Product product, int quantity) {
    OrderItem orderItem = new OrderItem(product, quantity);
    order.getItems().add(orderItem);
    return orderItem;
}

public void updateOrderItemQuantity(Order order, UUID orderItemId, int newQuantity) {
    OrderItem orderItem = order.getItems().stream()
            .filter(item -> item.getId().equals(orderItemId))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("OrderItem not found"));
    orderItem.setQuantity(newQuantity);
}

public void removeOrderItem(Order order, UUID orderItemId) {
    OrderItem orderItem = order.getItems().stream()
            .filter(item -> item.getId().equals(orderItemId))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("OrderItem not found"));
    order.getItems().remove(orderItem);
}
