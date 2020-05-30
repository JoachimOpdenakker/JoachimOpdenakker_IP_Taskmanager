package be.ucll.taskmanager.controller;

import be.ucll.taskmanager.model.Task;
import be.ucll.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TaskManagerController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public String getTasks(Model model){
        List<Task> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
}
