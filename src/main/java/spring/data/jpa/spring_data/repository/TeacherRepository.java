package spring.data.jpa.spring_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.data.jpa.spring_data.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
