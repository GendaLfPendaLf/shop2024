package ru.shop2024.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop2024.product.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    // Другие методы, если необходимо
}
