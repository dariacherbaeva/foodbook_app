package ru.itis.foodbook_app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.foodbook_app.dto.InformationDto;
import ru.itis.foodbook_app.models.Role;
import ru.itis.foodbook_app.models.User;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    @Query("select new ru.itis.foodbook_app.dto.InformationDto(user.username, " +
            "(sum(document.size) / 1024 / 1024) ) from User user left join user.documents " +
            "as document where user.id = :userId group by user.id")
    Optional<User> findByEmail (String email);
    User findByConfirmCode (String confirmCode);
    Optional<User> findById(Long id);
    User findByUsername(String username);
    Optional<User> findByRole(Role role);
    InformationDto getInformationByUser(@Param("userId") Long userId);
}
