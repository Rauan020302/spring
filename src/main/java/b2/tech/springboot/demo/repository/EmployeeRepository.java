package b2.tech.springboot.demo.repository;

import b2.tech.springboot.demo.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    List<Employee> findByNameAndLocation(String name,String location);

    //Select * From table where name like "%word%"
    List<Employee> findByNameContaining(String keyword, Sort sort);

    @Query("FROM Employee WHERE name = :name OR location = :location")
    List<Employee> getEmployeeByNameAndLocation(String name, String location);

    @Transactional
    @Modifying
    @Query("DELETE FROM Employee WHERE name = :name")
    Integer deleteByName(String name);
}
