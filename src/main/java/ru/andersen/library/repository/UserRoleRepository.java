package ru.andersen.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andersen.library.entity.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
