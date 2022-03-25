package spring.test.mockito.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.test.mockito.demo.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
