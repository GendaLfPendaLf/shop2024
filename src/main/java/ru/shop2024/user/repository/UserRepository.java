package ru.shop2024.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shop2024.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Дополнительные методы для доступа к данным пользователя
}
