package ru.shop2024.product;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Entity
@Data

public class Product {
    @Id

    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double price;

    @Column(nullable = false)
    private Long count;

    @Column(nullable = false)
    private String description;

    // Конструктор без аргументов (необходим для Hibernate)
    public Product() {
    }

    // Другие конструкторы, геттеры и сеттеры, если необходимо
}
