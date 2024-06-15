package hoangnguyen.dev.lab_2.repositories;

import hoangnguyen.dev.lab_2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Optional<Object> findByEmail(String email);

    Optional<Object> findByPhone(String phone);
}
