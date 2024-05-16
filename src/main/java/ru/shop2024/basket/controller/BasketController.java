package ru.shop2024.basket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop2024.Interface.BasketRepository;
import ru.shop2024.basket.Basket;
import ru.shop2024.basket.BasketItem;
import ru.shop2024.order.OrderItemRequest;
import ru.shop2024.basket.service.BasketService;

import java.util.UUID;

@RestController
@RequestMapping("/baskets")
public class BasketController {
    private final BasketRepository basketRepository;
    private final BasketService basketService;

    public BasketController(BasketRepository basketRepository, BasketService basketService) {
        this.basketRepository = basketRepository;
        this.basketService = basketService;
    }
    @PostMapping("/{basketId}/items")
    public ResponseEntity<BasketItem> addBasketItem(@PathVariable Long basketId, @RequestBody OrderItemRequest request) {
        Basket basket = getBasketById(basketId); // Метод для получения корзины по идентификатору
        BasketItem basketItem = basketService.addBasketItem(basket, request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(basketItem);
    }

    @PutMapping("/{basketId}/items/{basketItemId}")
    public ResponseEntity<Void> updateBasketItemQuantity(@PathVariable Long basketId, @PathVariable UUID basketItemId, @RequestBody OrderItemRequest request) {
        Basket basket = getBasketById(basketId);
        basketService.updateBasketItemQuantity(basket, basketItemId, request.getQuantity());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{basketId}/items/{basketItemId}")
    public ResponseEntity<Void> removeBasketItem(@PathVariable Long basketId, @PathVariable UUID basketItemId) {
        ru.shop2024.basket.Basket basket = getBasketById(basketId);
        basketService.removeBasketItem(basket, basketItemId);
        return ResponseEntity.ok().build();
    }

    // Метод для получения корзины по идентификатору
    private Basket getBasketById(Long basketId) {
        // Логика для получения корзины из базы данных или другого источника данных
        return basketRepository.findById(basketId)
                .orElseThrow(() -> new RuntimeException("Basket not found"));
    }
}
