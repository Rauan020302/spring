package b2.tech.springboot.demo.service.impl;

import b2.tech.springboot.demo.entity.Employee;
import b2.tech.springboot.demo.repository.EmployeeRepository;
import b2.tech.springboot.demo.service.EmployeeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> getEmployee(int pageNumber,int pageSize) {
        Pageable pages = PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC, "id");
        return employeeRepository.findAll(pages).getContent();
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Employee is not found for the id - " + id);
    }
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getEmployeeByNameAndLocation(String name,String location) {
        return employeeRepository.findByNameAndLocation(name,location);
    }

    @Override
    public List<Employee> findByNameContaining(String keyword) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return employeeRepository.findByNameContaining(keyword,sort);
    }

    @Override
    public List<Employee> getEmployeeByNameOrLocation(String name,String location) {
        return employeeRepository.getEmployeeByNameAndLocation(name,location);
    }

    @Override
    public Integer deleteByName(String name) {
        return employeeRepository.deleteByName(name);
    }
}
