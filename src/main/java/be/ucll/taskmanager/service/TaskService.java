package be.ucll.taskmanager.service;

import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    public List<TaskDTO> getTasks();

    void addTask(TaskDTO taskDTO);

    public Task getTask(UUID id);
}


