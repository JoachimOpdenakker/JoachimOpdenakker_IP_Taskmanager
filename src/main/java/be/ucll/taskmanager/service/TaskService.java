package be.ucll.taskmanager.service;

import be.ucll.taskmanager.dto.SubTaskDTO;
import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.dto.TeamDTO;
import be.ucll.taskmanager.model.SubTask;
import be.ucll.taskmanager.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    public List<TaskDTO> getTasks();

    public List<TeamDTO> getTeams();

    void addTask(TaskDTO taskDTO);

    public Task getTask(UUID id);

    void editTask(UUID id, TaskDTO taskDTO);

    void addSubTask(UUID id, SubTaskDTO subTaskDTO);

    List<SubTaskDTO> getSubTasksBySuperTaskID(UUID id);

    List<SubTask> getSubTasks();

    void addTeam(TeamDTO teamDTO);
}



