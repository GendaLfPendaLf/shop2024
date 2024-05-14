package ru.shop2024.user.service;

import org.springframework.stereotype.Service;
import ru.shop2024.user.model.User;
import ru.shop2024.user.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Другие методы
}
