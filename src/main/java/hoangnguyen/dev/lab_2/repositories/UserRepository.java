package hoangnguyen.dev.lab_2.repositories;

import hoangnguyen.dev.lab_2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
