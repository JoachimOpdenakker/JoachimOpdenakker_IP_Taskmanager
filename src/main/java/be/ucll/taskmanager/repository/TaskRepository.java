package be.ucll.taskmanager.repository;

import be.ucll.taskmanager.model.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> taskList;

    public TaskRepository(){
        taskList = new ArrayList<>();
        taskList.add(new Task("Test", LocalDateTime.now(), "this is some test description"));
        taskList.add(new Task("OEH NOG EEN TEST", LocalDateTime.now(), "this is some test description"));
        taskList.add(new Task("ITS GETTING BORING NOW", LocalDateTime.now(), "this is some test description"));
    }

    public List<Task> getTaskList(){
        return taskList;
    }

    public void addTask(Task task){
        taskList.add(task);
    }
}
