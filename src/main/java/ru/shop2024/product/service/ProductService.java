package ru.shop2024.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shop2024.product.Product;
import ru.shop2024.product.ProductList;
import ru.shop2024.product.ProductReader;
import ru.shop2024.Interface.ProductRepository;


import java.util.UUID;

@Service
public class ProductService {
    private final ProductReader productReader;

    public Product getProductById(UUID productId) {
        // Логика для получения продукта по идентификатору из базы данных или другого источника данных
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
    private ProductList productList;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductReader productReader, ProductRepository productRepository) {
        this.productReader = productReader;
        this.productRepository = productRepository;
    }

    public ProductList getProducts() {
        return productList;
    }

    public void deleteProduct(UUID productId) {

    }
}
