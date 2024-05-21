package ru.shop2024.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop2024.order.Order;
import ru.shop2024.order.OrderItem;
import ru.shop2024.order.OrderItemRequest;
import ru.shop2024.order.service.OrderService;
import ru.shop2024.product.Product;
import ru.shop2024.product.service.ProductService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
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
