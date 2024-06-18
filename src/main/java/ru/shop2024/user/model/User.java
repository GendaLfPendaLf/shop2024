package ru.shop2024.user.model;


import jakarta.persistence.*;
import lombok.Data;
import ru.shop2024.basket.Basket;
import ru.shop2024.order.Order;

import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String sex;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String address;
    private Long basketId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basketId", referencedColumnName = "id")
    private Basket basket;

    // Конструктор по умолчанию
    public User() {
        this.basket = new Basket();
    }

    // Конструктор со всеми полями
    public User(String name, String surname, String sex, String address, Long basketId) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.address = address;
        this.basketId = basketId;
    }

    // Геттеры и сеттеры
}

/*Теперь в классе User есть:
Конструктор по умолчанию: public User() {}.
 Этот конструктор необходим для корректной работы JPA и создания объектов User без явного указания полей.
Конструктор со всеми полями:
public User(String name, String surname, String sex, String address, Long basketId). Этот конструктор позволяет создавать объекты User, явно указывая значения всех полей, кроме id (так как оно генерируется автоматически) и orders (так как это коллекция, которая может быть пустой при создании нового пользователя).
Наличие этих конструкторов упростит создание объектов User в различных частях вашего приложения,
например, в тестах или при создании новых пользователей через сервис или контроллер.
Обратите внимание, что я не добавлял конструктор для поля orders, так как это коллекция,
которая может быть пустой при создании нового пользователя. Если вам нужно создавать пользователей
 с уже существующими заказами, вы можете добавить соответствующий конструктор или
  использовать сеттер для orders.
*/