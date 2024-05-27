package ru.shop2024.order.service;

import ru.shop2024.basket.Basket;
import ru.shop2024.basket.BasketItem;
import ru.shop2024.order.Order;
import ru.shop2024.order.OrderItem;
import ru.shop2024.order.repository.OrderRepository;
import ru.shop2024.product.Product;
import ru.shop2024.user.model.User;
import ru.shop2024.basket.repository.BasketRepository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderService {
    private final OrderRepository orderRepository;
    private final BasketRepository basketRepository;

    public OrderService(OrderRepository orderRepository, BasketRepository basketRepository) {

        this.orderRepository = orderRepository;
        this.basketRepository = basketRepository;
    }

    public OrderItem addOrderItem(Order order, Product product, int quantity) {
        OrderItem orderItem = new OrderItem(product, quantity);
        order.getItems().add(orderItem);
        return orderItem;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
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

    public Order createOrderFromBasket(User user) {
        Basket basket = user.getBasket();
        Order order = new Order();
        order.setUser(user);
        order.setBasket(basket);

        for (BasketItem basketItem : basket.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(basketItem.getProduct());
            orderItem.setQuantity(basketItem.getQuantity());
            order.addItem(orderItem);
        }

        return orderRepository.save(order);
    }

    public void clearBasket(Order order) {
        Basket basket = order.getBasket();
        basket.getItems().clear();
        basketRepository.save(basket);
    }

}
