package ru.shop2024.user.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    private UUID userId;
    private String name;
    private String surname;
    private String sex;
    private String address;
    private Long basketId;
    private List<Long> orderIds;
}