package ru.shop2024.user.service;

import org.springframework.stereotype.Service;
import ru.shop2024.user.repository.UserRepository;
import ru.shop2024.user.model.User;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // Логика создания пользователя
        user.setUserId(UUID.randomUUID());
        return userRepository.save(user);
    }

    // Дополнительные методы сервиса, если необходимо
}
