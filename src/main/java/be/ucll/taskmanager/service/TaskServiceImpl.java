package be.ucll.taskmanager.service;

import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.model.Task;
import be.ucll.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
        taskRepository.save(new Task("Test", LocalDateTime.now(), "this is some test description"));
        taskRepository.save(new Task("OEH NOG EEN TEST", LocalDateTime.now(), "this is some test description"));
        taskRepository.save(new Task("ITS GETTING BORING NOW", LocalDateTime.now(), "this is some test description"));
    }

    @Override
    public List<TaskDTO> getTasks(){
        List<TaskDTO> taskDTOS = new ArrayList<>();
        for (Task task : taskRepository.findAll()){
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
        return taskRepository.findById(id).get();
//        return task;
    }

    @Override
    public void addTask(TaskDTO taskDTO){
        Task task = new Task(taskDTO.getTitle(), taskDTO.getDueDate(), taskDTO.getDescription());
        taskRepository.save(task);
    }

    @Override
    public void editTask(UUID id, TaskDTO bla) {
        Task t = taskRepository.findById(bla.getId()).get();
        t.setTitle(bla.getTitle());
        t.setDescription(bla.getDescription());
        t.setDueDate(bla.getDueDate());
        taskRepository.save(t);
    }
}
