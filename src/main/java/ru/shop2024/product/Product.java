package ru.shop2024.product;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false, precision = 10)
    private Double price;

    @Column(nullable = false)
    private Long count;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    // Конструктор со всеми полями
    public Product(String brand, String type, Double price, Long count, String description) {
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.count = count;
        this.description = description;
    }

    // Геттеры и сеттеры
    // (они генерируются автоматически с помощью аннотации @Data)
}
