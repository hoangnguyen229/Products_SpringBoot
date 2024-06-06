package hoangnguyen.dev.lab_2.repositories;

import hoangnguyen.dev.lab_2.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
