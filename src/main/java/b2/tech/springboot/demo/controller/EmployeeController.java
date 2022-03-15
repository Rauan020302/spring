package b2.tech.springboot.demo.controller;

import b2.tech.springboot.demo.entity.Employee;
import b2.tech.springboot.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(
                employeeService.getEmployee(pageNumber,pageSize), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(
                employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getSingleEmployee(@PathVariable Long id){
        return new ResponseEntity<>(
                employeeService.getSingleEmployee(id),HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<>(
                employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @GetMapping("/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation(@RequestParam String name,@RequestParam String location){
        return new ResponseEntity<>(
                employeeService.getEmployeeByNameAndLocation(name,location),HttpStatus.OK);
    }
    @GetMapping("/filterByKeyWord")
    public ResponseEntity<List<Employee>> getEmployeeByKeyWord(@RequestParam String keyword){
        return new ResponseEntity<>(
                employeeService.findByNameContaining(keyword),HttpStatus.OK);
    }
    @GetMapping("/filterByNameOrLocation/{name}/{location}")
    public ResponseEntity<List<Employee>> getEmployeeByNameOrLocation(@PathVariable String name,@PathVariable String location){
        return new ResponseEntity<>(
                employeeService.getEmployeeByNameOrLocation(name,location),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Integer> deleteEmployee(@PathVariable String name) {
        return new ResponseEntity<>(
                employeeService.deleteByName(name), HttpStatus.NO_CONTENT);
    }
 }
