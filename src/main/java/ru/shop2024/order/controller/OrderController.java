package ru.shop2024.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop2024.order.Order;
import ru.shop2024.order.OrderItem;
import ru.shop2024.order.OrderItemRequest;
import ru.shop2024.order.service.OrderService;
import ru.shop2024.product.Product;
import ru.shop2024.product.service.ProductService;
import ru.shop2024.user.model.User;
import ru.shop2024.user.service.UserService;
import ru.shop2024.exception.ResourceNotFoundException;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;
    private final UserService userService;

    public OrderController(OrderService orderService, ProductService productService, UserService userService) {
        this.orderService = orderService;
        this.productService = productService;
        this.userService = userService;
    }

    // Методы контроллера для обработки запросов, например, создание, обновление, удаление заказов и т.д.
    @PostMapping("/orders/{orderId}/items")
    public ResponseEntity<OrderItem> addOrderItem(@PathVariable Long orderId, @RequestBody OrderItemRequest request) {
        Optional<Order> orderOptional = orderService.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            Product product = productService.getProductById(request.getProductId());
            OrderItem orderItem = orderService.addOrderItem(order, product, request.getQuantity());
            return ResponseEntity.ok(orderItem);
        } else {
            // Обработка случая, когда заказ не найден
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{userId}")
    public ResponseEntity<Order> createOrder(@PathVariable Long userId) {
        User user;
        try {
            user = userService.getUserById(userId);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        Order order = orderService.createOrderFromBasket(user);
        orderService.clearBasket(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }


    @GetMapping
    public ResponseEntity<Object> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/orders/{orderId}/items/{orderItemId}")
    public ResponseEntity<Void> updateOrderItemQuantity(@PathVariable Long orderId, @PathVariable UUID orderItemId, @RequestBody OrderItemRequest request) {
        Optional<Order> orderOptional = orderService.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            orderService.updateOrderItemQuantity(order, orderItemId, request.getQuantity());
            return ResponseEntity.ok().build();
        } else {
            // Обработка случая, когда заказ не найден
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/orders/{orderId}/items/{orderItemId}")
    public ResponseEntity<Void> removeOrderItem(@PathVariable Long orderId, @PathVariable UUID orderItemId) {
        Optional<Order> orderOptional = orderService.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            orderService.removeOrderItem(order, orderItemId);
            return ResponseEntity.ok().build();
        } else {
            // Обработка случая, когда заказ не найден
            return ResponseEntity.notFound().build();
        }
    }
}
