package ru.shop2024.basket.service;

import org.springframework.stereotype.Service;
import ru.shop2024.basket.Basket;
import ru.shop2024.basket.BasketItem;
import ru.shop2024.basket.repository.BasketRepository;
import ru.shop2024.product.Product;
import ru.shop2024.product.service.ProductService;
import ru.shop2024.user.model.User;

import java.util.UUID;

@Service
public class BasketService {
    // Логика для работы с корзиной, например, добавление, удаление продуктов и т.д.
    private final BasketRepository basketRepository;
    private final ProductService productService;

    public BasketService(BasketRepository basketRepository, ProductService productService) {
        this.basketRepository = basketRepository;
        this.productService = productService;
    }

    public BasketItem addBasketItem(Basket basket, UUID productId, int quantity) {
        Product product = productService.getProductById(productId);
        BasketItem basketItem = new BasketItem(product, quantity);
        basket.getItems().add(basketItem);
        return basketItem;
    }

    public void updateBasketItemQuantity(Basket basket, UUID basketItemId, int newQuantity) {
        BasketItem basketItem = basket.getItems().stream()
                .filter(item -> item.getId().equals(basketItemId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("BasketItem not found"));
        basketItem.setQuantity(newQuantity);
    }

    public void removeBasketItem(Basket basket, UUID basketItemId) {
        BasketItem basketItem = basket.getItems().stream()
                .filter(item -> item.getId().equals(basketItemId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("BasketItem not found"));
        basket.getItems().remove(basketItem);
    }
    public Basket getBasketForUser(User user) {
        return user.getBasket();
    }
}