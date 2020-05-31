package be.ucll.taskmanager.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TaskTests {

    @Test(expected = DomainException.class)
    public void init_task_title_empty(){
        Task task = new Task("", LocalDateTime.now(), "description");
    }

    @Test(expected = DomainException.class)
    public void init_task_description_empty(){
        Task task = new Task("title", LocalDateTime.now(), "");
    }

    @Test(expected = DomainException.class)
    public void init_task_title_null(){
        Task task = new Task(null, LocalDateTime.now(), "description");
    }

    @Test(expected = DomainException.class)
    public void init_task_description_null(){
        Task task = new Task("title", LocalDateTime.now(), null);
    }

    public void add_subtask_to_task(){
        List<SubTask> subTasks = new ArrayList<>();
        Task task = new Task("title", LocalDateTime.now(), "description");
        SubTask subTask = new SubTask();
        subTask.setTitle("title");
        subTask.setDescription("description");
        task.addSubTask(subTask);
        subTasks.add(subTask);
        assertEquals(task.getSubTaskList(), subTasks);
    }
}
