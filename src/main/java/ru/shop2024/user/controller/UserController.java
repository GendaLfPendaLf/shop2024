package ru.shop2024.user.controller;

import org.springframework.web.bind.annotation.*;
import ru.shop2024.user.model.User;
import ru.shop2024.user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
/*
@GetMapping("/{id}"): Этот маппинг обрабатывает HTTP GET-запросы на /api/users/{id} и вызывает метод getUserById в UserService для получения пользователя по его идентификатору (id).
@PutMapping("/{id}"): Этот маппинг обрабатывает HTTP PUT-запросы на /api/users/{id} и вызывает метод updateUser в UserService для обновления пользователя с указанным id. Обновленные данные пользователя передаются в теле запроса.
@DeleteMapping("/{id}"): Этот маппинг обрабатывает HTTP DELETE-запросы на /api/users/{id} и вызывает метод deleteUser в UserService для удаления пользователя с указанным id.
 */
/*
GET /api/users/{id}: Получить пользователя по идентификатору.
POST /api/users: Создать нового пользователя (тело запроса должно содержать данные пользователя в формате JSON).
PUT /api/users/{id}: Обновить существующего пользователя (тело запроса должно содержать обновленные данные пользователя в формате JSON).
DELETE /api/users/{id}: Удалить пользователя по идентификатору.
 */