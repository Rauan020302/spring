package spring.aop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.aop.demo.entity.TaskDetails;

@Repository
public interface TaskRepo extends JpaRepository<TaskDetails,Long> {
}
