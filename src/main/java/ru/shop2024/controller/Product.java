package ru.shop2024.controller;

import lombok.Data;

import java.util.UUID;

@Data
public class Product {
    private UUID id;
    private String brand;
    private String type;
    private Double price;
    private Long count;
    private String description;
}
