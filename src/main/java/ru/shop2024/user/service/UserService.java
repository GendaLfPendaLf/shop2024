package ru.shop2024.user.service;

import org.springframework.stereotype.Service;
import ru.shop2024.exception.ResourceNotFoundException;
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
    // Получение пользователя по идентификатору
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("У пользователя не найдет ID: " + id));
    }

    // Обновление пользователя
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setSurname(updatedUser.getSurname());
        existingUser.setSex(updatedUser.getSex());
        existingUser.setAddress(updatedUser.getAddress());
        existingUser.setBasketId(updatedUser.getBasketId());
        return userRepository.save(existingUser);
    }

    // Удаление пользователя
    public void deleteUser(Long id) {
        User existingUser = getUserById(id);
        userRepository.delete(existingUser);
    }
}
/*
getUserById(Long id): Этот метод получает пользователя по его идентификатору (id).
Если пользователь не найден, выбрасывается исключение ResourceNotFoundException.

updateUser(Long id, User updatedUser): Этот метод обновляет существующего пользователя с указанным
id новыми данными из объекта updatedUser. Сначала он получает существующего пользователя, затем
обновляет его поля и сохраняет обновленного пользователя в базе данных.

deleteUser(Long id): Этот метод удаляет пользователя с указанным id из базы данных.
Сначала он получает существующего пользователя, а затем удаляет его из репозитория.
 */