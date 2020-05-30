package be.ucll.taskmanager.service;

import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.model.Task;

import java.util.List;

public interface TaskService {

    public List<Task> getTasks();

    void addTask(TaskDTO taskDTO);
}


