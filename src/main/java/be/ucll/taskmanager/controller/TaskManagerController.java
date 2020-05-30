package be.ucll.taskmanager.controller;

import be.ucll.taskmanager.dto.TaskDTO;
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

    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/task/{id}")
    public String getTask(Model model, @PathVariable("id") UUID id){
        model.addAttribute("task", taskService.getTask(id));
        return "task.html";
    }

    @GetMapping("/newtask")
    public String newTask(Model model){
        model.addAttribute("taskDTO", new TaskDTO());
        return "newTask";
    }

    @PostMapping("/newtask")
    public String newTask(Model model, @ModelAttribute TaskDTO taskDTO, BindingResult bindingResult){
        System.out.print("Adding a new Task");
        if(bindingResult.hasErrors()){
            System.out.print(bindingResult);
            return "newTask";
        }
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }
}
