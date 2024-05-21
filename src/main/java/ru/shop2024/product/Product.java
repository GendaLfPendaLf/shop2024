package ru.shop2024.product;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String brand;
    private String type;

    @Column(precision = 10, scale = 2)
    private Double price;
    private Long count;
    private String description;
}
