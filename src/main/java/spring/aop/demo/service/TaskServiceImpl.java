package spring.aop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import spring.aop.demo.entity.TaskDetails;
import spring.aop.demo.handler.TaskException;
import spring.aop.demo.mapper.TaskMapper;
import spring.aop.demo.model.Task;
import spring.aop.demo.repository.TaskRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskMapper taskMapper;

    @Autowired
    TaskRepo taskRepository;

    @Override
    @Transactional
    public Task createTask(Task task) {

        TaskDetails taskDetails = taskMapper.convertToTaskDetails(task);

        return taskMapper.convertToTaskDto(taskRepository.save(taskDetails));

    }

    @Override
    @Transactional
    public void deleteTask(Long id){
        Optional<TaskDetails> taskDetails=taskRepository.findById(id);

        if(!taskDetails.isPresent()) {
            throw new TaskException("Task Not Found!", HttpStatus.NOT_FOUND);
        }

        TaskDetails task=taskDetails.get();
        //task.setTaskStatus(TaskStatus.DELETED);
        taskRepository.delete(task);


    }

    @Override
    public Task getTasks(Long id) {
        Optional<TaskDetails> taskDetails=taskRepository.findById(id);

        if(taskDetails.isPresent()) {
            return taskMapper.convertToTaskDto(taskDetails.get());
        }
        return null;
    }

    @Override
    @Transactional
    public Task updateTask(Long id, Task task){
        Optional<TaskDetails> taskDetails=taskRepository.findById(id);

        if(taskDetails.isPresent()) {
            TaskDetails taskDetailsUpdate=taskMapper.convertToTaskDetails(task);
            taskDetailsUpdate.setId(id);
            return taskMapper.convertToTaskDto(taskRepository.save(taskDetailsUpdate));
        }

        throw new TaskException("No Task Found with Id "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Task> getAllTasks() {

        return taskMapper.convertToTaskList(taskRepository.findAll());
    }
}
