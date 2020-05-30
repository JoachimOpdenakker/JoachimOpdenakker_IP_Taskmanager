package be.ucll.taskmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.*;

@Entity
public class Task {

    @Id
    private String id;
    private String title;
    private LocalDateTime dueDate;

    public Task(){

    }

    public Task(String title, LocalDateTime dueDate){
        this.title = title;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
