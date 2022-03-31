package spring.caching.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.caching.demo.entity.User;

public interface UserRepo extends JpaRepository<User,Long> {
}
