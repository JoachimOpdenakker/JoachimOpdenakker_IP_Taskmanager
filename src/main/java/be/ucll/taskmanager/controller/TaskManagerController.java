package be.ucll.taskmanager.controller;

import be.ucll.taskmanager.dto.SubTaskDTO;
import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.model.SubTask;
import be.ucll.taskmanager.model.Task;
import be.ucll.taskmanager.service.TaskService;
import be.ucll.taskmanager.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class TaskManagerController {

    @Autowired
    TaskServiceImpl taskService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
//        List<SubTask> subTasks = taskService.getSubTasks();
        System.out.println(this.taskService.subTaskListToString());
        model.addAttribute("tasks", taskService.getTasks());
        model.addAttribute("subtasks", taskService.getSubTasks());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(Model model, @PathVariable("id") String id){
        Task taskDTO = taskService.getTask(UUID.fromString(id));
        List<SubTaskDTO> subTaskDTOS = taskService.getSubTasksBySuperTaskID(UUID.fromString(id));
        model.addAttribute("task", taskDTO);
        model.addAttribute("subtasks", subTaskDTOS);
        return "task.html";
    }

    @GetMapping("/tasks/new")
    public String newTask(Model model){
        model.addAttribute("taskDTO", new TaskDTO());
        return "newTask";
    }

    @PostMapping("/tasks/new")
    public String newTask(Model model, @ModelAttribute TaskDTO taskDTO, BindingResult bindingResult){
        System.out.print("Adding a new Task");
        if(bindingResult.hasErrors()){
            System.out.print(bindingResult);
            return "newTask";
        }
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTask(Model model, @PathVariable("id") String id){
        Task task = taskService.getTask(UUID.fromString(id));
        model.addAttribute(task);
        return "editTask";
    }

    @PostMapping("/tasks/edit/{id}")
    public String editTask(@ModelAttribute("task") TaskDTO taskDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return "tasks";
        }
        taskService.editTask(taskDTO.getId(), taskDTO);
        return "redirect:/tasks/";
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String createSubTask(Model model, @PathVariable("id") String id){
        model.addAttribute("id", id);
        model.addAttribute("subtask", new SubTask());
        return "newSubTask";
    }

    @PostMapping("/tasks/{id}/sub/create")
    public String createSubTask(@ModelAttribute("subTask") SubTaskDTO subTaskDTO, BindingResult bindingResult, @PathVariable("id") String id){
        if(bindingResult.hasErrors()){
            return "newSubTask";
        }
        UUID taskID = UUID.fromString(id);
        taskService.addSubTask(taskID, subTaskDTO);
        return "redirect:/tasks/" + id;
    }
}
