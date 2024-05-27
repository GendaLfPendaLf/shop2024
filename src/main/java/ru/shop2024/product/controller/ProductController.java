package ru.shop2024.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop2024.product.Product;
import ru.shop2024.product.service.ProductService;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody Product updatedProduct) {
        Product updatedProductResponse = productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok(updatedProductResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
/*
POST /api/products: Создать новый продукт (тело запроса должно содержать данные продукта в формате JSON).
GET /api/products/{id}: Получить продукт по идентификатору.
PUT /api/products/{id}: Обновить существующий продукт (тело запроса должно содержать обновленные данные продукта в формате JSON).
DELETE /api/products/{id}: Удалить продукт по идентификатору.
 */
