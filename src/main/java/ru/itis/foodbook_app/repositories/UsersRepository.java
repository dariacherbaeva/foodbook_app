package ru.itis.foodbook_app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.foodbook_app.models.Role;
import ru.itis.foodbook_app.models.User;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail (String email);
    User findByConfirmCode (String confirmCode);
    Optional<User> findById(Long id);
    User findByUsername(String username);
    Optional<User> findByRole(Role role);
}
