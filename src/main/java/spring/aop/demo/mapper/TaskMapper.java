package spring.aop.demo.mapper;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import spring.aop.demo.entity.TaskDetails;
import spring.aop.demo.model.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {
    public TaskDetails convertToTaskDetails(Task task){

        TaskDetails taskDetails = new TaskDetails();
        taskDetails.setTitle(task.getTitle());
        taskDetails.setDescription(task.getDescription());
        taskDetails.setStartDate(task.getStartDate());
        taskDetails.setEndDate(task.getEndDate());
        return taskDetails;
    }
    public Task convertToTaskDto(TaskDetails taskDetails){

        Task task = new Task();
        task.setId(taskDetails.getId());
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStartDate(taskDetails.getStartDate());
        task.setEndDate(taskDetails.getEndDate());
        return task;
    }
    private Date getDate(String date){
        try {
            if (StringUtils.isEmpty(date)){
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.parse(date);
        }catch (ParseException e){
            return null;
        }
    }
    private String dateFormat(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
    public List<Task> convertToTaskList(List<TaskDetails> taskList){
        return taskList.stream().map(this::convertToTaskDto).collect(Collectors.toList());
    }

}
