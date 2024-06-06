package hoangnguyen.dev.lab_2.repositories;

import hoangnguyen.dev.lab_2.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
