package be.ucll.taskmanager.service;

import be.ucll.taskmanager.dto.SubTaskDTO;
import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.model.SubTask;
import be.ucll.taskmanager.model.Task;
import be.ucll.taskmanager.repository.SubTaskRepository;
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
    private final SubTaskRepository subTaskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, SubTaskRepository subTaskRepository){
        this.taskRepository = taskRepository;
        this.subTaskRepository = subTaskRepository;
        taskRepository.save(new Task("Test", LocalDateTime.now(), "this is some test description"));
        taskRepository.save(new Task("OEH NOG EEN TEST", LocalDateTime.now(), "this is some test description"));
        taskRepository.save(new Task("ITS GETTING BORING NOW", LocalDateTime.now(), "this is some test description"));
        for (Task task: taskRepository.findAll()){
            if (task.getTitle().equals("ITS GETTING BORING NOW")){
                subTaskRepository.save(new SubTask("test", "test", task.getId()));
            }
        }
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
    public List<SubTaskDTO> getSubTasks(){
        List<SubTaskDTO> subTasks = new ArrayList<>();
        for (SubTask subTask : subTaskRepository.findAll()){
            SubTaskDTO subTaskDTO = new SubTaskDTO();
            subTaskDTO.setTitle(subTask.getTitle());
            subTaskDTO.setDescription(subTask.getDescription());
            subTaskDTO.setId(subTask.getId());
            subTaskDTO.setSuperTaskID(subTask.getSuperTaskID());
            subTasks.add(subTaskDTO);
        }
        return subTasks;
    }

    @Override
    public List<SubTaskDTO> getSubTasksBySuperTaskID(UUID id){
        List<SubTaskDTO> subTaskDTOS = new ArrayList<>();
        for (SubTask subTask : subTaskRepository.findAll()){
            if(subTask.getSuperTaskID().toString().equals(id.toString())) {
                SubTaskDTO subTaskDTO = new SubTaskDTO();
                subTaskDTO.setId(subTask.getId());
                subTaskDTO.setTitle(subTask.getTitle());
                subTaskDTO.setDescription(subTask.getDescription());
                subTaskDTO.setSuperTaskID(subTask.getSuperTaskID());
                subTaskDTOS.add(subTaskDTO);
            }
            else {
                System.out.println("no match");
            }
        }
        return subTaskDTOS;
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

    @Override
    public void addSubTask(UUID id, SubTaskDTO subTaskDTO){
        UUID subTaskDTOId = subTaskDTO.getId();
        SubTask subtask = new SubTask();
        subtask.setTitle(subTaskDTO.getTitle());
        subtask.setDescription(subTaskDTO.getDescription());
        TaskDTO taskDTO = new TaskDTO();
        Task task = this.taskRepository.findById(subTaskDTOId).get();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setDueDate(task.getDueDate());
        subTaskDTO.setSuperTaskID(id);
        subtask.setSuperTaskID(id);
        this.taskRepository.saveAndFlush(task);
        this.subTaskRepository.saveAndFlush(subtask);
    }

    public String subTaskListToString(){
        String result = "";
        for (SubTask subTask: subTaskRepository.findAll()){
            result += "id: " + subTask.getId() + "\n description: " + subTask.getDescription() + "\n supertaskid: " + subTask.getSuperTaskID() + "\n";
        }
        return result;
    }

    @Override
    public void removeTaskAndSubtasks(UUID id){
        for (SubTask subTask: subTaskRepository.findAll()){
            if (subTask.getSuperTaskID().equals(id)){
                subTaskRepository.delete(subTask);
            }
        }
        taskRepository.deleteById(id);
    }
}