package be.ucll.taskmanager.service;

import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.model.Task;
import be.ucll.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks(){
        return taskRepository.getTaskList();
    }

    @Override
    public void addTask(TaskDTO taskDTO){
        Task task = new Task(taskDTO.getTitle(), taskDTO.getDueDate(), taskDTO.getDescription());
        taskRepository.addTask(task);
    }
}
