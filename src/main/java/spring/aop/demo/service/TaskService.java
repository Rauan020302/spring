package spring.aop.demo.service;

import spring.aop.demo.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    void deleteTask(Long id);
    Task getTasks(Long id);
    Task updateTask(Long id,Task task);
    List<Task> getAllTasks();
}
