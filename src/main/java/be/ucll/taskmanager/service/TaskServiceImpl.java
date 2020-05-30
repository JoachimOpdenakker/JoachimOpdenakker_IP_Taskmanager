package be.ucll.taskmanager.service;

import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.model.Task;
import be.ucll.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskDTO> getTasks(){
        List<TaskDTO> taskDTOS = new ArrayList<>();
        for (Task task : taskRepository.getTaskList()){
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setTitle(task.getTitle());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setDueDate(task.getDueDate());
            taskDTO.setId(task.getId());
            taskDTOS.add(taskDTO);
        }
        return taskDTOS;
    }

    @Override
    public Task getTask(UUID id) {
        Task task = taskRepository.getTask(id);
        return task;
    }

    @Override
    public void addTask(TaskDTO taskDTO){
        Task task = new Task(taskDTO.getTitle(), taskDTO.getDueDate(), taskDTO.getDescription());
        taskRepository.addTask(task);
    }
}
