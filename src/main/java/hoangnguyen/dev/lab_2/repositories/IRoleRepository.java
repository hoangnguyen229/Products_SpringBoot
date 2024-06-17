package hoangnguyen.dev.lab_2.repositories;

import hoangnguyen.dev.lab_2.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,Long> {
    Role findRoleById(Long id);
}
