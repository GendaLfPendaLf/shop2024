package ru.shop2024.product.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(UUID uuid) {
        super("ID продукта не найден: " + uuid);
    }
}
