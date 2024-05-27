package ru.shop2024.product.service;

import org.springframework.stereotype.Service;
import ru.shop2024.product.Product;
import ru.shop2024.product.exception.ProductNotFoundException;
import ru.shop2024.product.repository.ProductRepository;

import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Метод для создания нового продукта
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Метод для получения продукта по идентификатору
    public Product getProductById(UUID productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
    }

    // Метод для обновления существующего продукта
    public Product updateProduct(UUID productId, Product updatedProduct) {
        Product existingProduct = getProductById(productId);
        existingProduct.setBrand(updatedProduct.getBrand());
        existingProduct.setType(updatedProduct.getType());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCount(updatedProduct.getCount());
        existingProduct.setDescription(updatedProduct.getDescription());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(UUID productId) {
        Product existingProduct = getProductById(productId);
        productRepository.delete(existingProduct);
    }
}