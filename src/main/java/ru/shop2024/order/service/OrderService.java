package ru.shop2024.order.service;

import ru.shop2024.order.Order;
import ru.shop2024.order.OrderItem;
import ru.shop2024.product.Product;
import ru.shop2024.Interface.OrderRepository;

import java.util.Optional;
import java.util.UUID;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

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

    public Optional<Order> findById(Long orderId) {
        // Здесь вы должны реализовать логику для получения заказа из базы данных или другого источника данных
        // по его идентификатору orderId
        // Например, если у вас есть репозиторий OrderRepository, вы можете использовать его метод findById
        return orderRepository.findById(orderId);
    }

    public void main() {
        // Код метода main(), если необходимо
    }
}
