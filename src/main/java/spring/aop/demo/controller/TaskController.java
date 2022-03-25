package spring.aop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.aop.demo.model.Task;
import spring.aop.demo.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid Task task) {
        Task taskResponse=taskService.createTask(task);
        return new ResponseEntity<>(taskResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Task> deleteTask(Integer id) {
        Long taskId=(Long)id.longValue();
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
    }

    @GetMapping("{/id}")
    public ResponseEntity<Task> getTasks(Integer id) {
        Long taskId=(Long)id.longValue();
        return new ResponseEntity<>(taskService.getTasks(taskId),HttpStatus.OK);
    }

    @PutMapping("{/id}")
    public ResponseEntity<Task> updateTask(Integer id, @Valid Task task) {
        Long taskId=(Long)id.longValue();
        return new ResponseEntity<>(taskService.updateTask(taskId,task),HttpStatus.OK);
    }
}
