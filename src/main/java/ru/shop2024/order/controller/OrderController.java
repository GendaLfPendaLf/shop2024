package ru.shop2024.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop2024.order.Order;
import ru.shop2024.order.OrderItem;
import ru.shop2024.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Методы контроллера для обработки запросов, например, создание, обновление, удаление заказов и т.д.
    @PostMapping("/orders/{orderId}/items")
    public ResponseEntity<OrderItem> addOrderItem(@PathVariable Long orderId, @RequestBody OrderItemRequest request) {
        Order order = orderService.getOrderById(orderId);
        Product product = productService.getProductById(request.getProductId());
        OrderItem orderItem = orderService.addOrderItem(order, product, request.getQuantity());
        return ResponseEntity.ok(orderItem);
    }

    @PutMapping("/orders/{orderId}/items/{orderItemId}")
    public ResponseEntity<Void> updateOrderItemQuantity(@PathVariable Long orderId, @PathVariable UUID orderItemId, @RequestBody OrderItemRequest request) {
        Order order = orderService.getOrderById(orderId);
        orderService.updateOrderItemQuantity(order, orderItemId, request.getQuantity());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/orders/{orderId}/items/{orderItemId}")
    public ResponseEntity<Void> removeOrderItem(@PathVariable Long orderId, @PathVariable UUID orderItemId) {
        Order order = orderService.getOrderById(orderId);
        orderService.removeOrderItem(order, orderItemId);
        return ResponseEntity.ok().build();
    }
}
