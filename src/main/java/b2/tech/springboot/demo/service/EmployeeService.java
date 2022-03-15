package b2.tech.springboot.demo.service;

import b2.tech.springboot.demo.entity.Employee;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee(int pageNumber,int pageSize);
    Employee saveEmployee(Employee employee);
    Employee getSingleEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee (Employee employee);
    List<Employee> getEmployeeByNameAndLocation(String name,String location);
    List<Employee> findByNameContaining(String keyword);
    List<Employee> getEmployeeByNameOrLocation(String name, String location);
    Integer deleteByName(String name);
}
