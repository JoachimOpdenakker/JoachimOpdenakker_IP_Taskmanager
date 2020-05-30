package be.ucll.taskmanager.model;

import java.time.LocalDateTime;

public class Task {


    private String title;
    private LocalDateTime dueDate;
    private String description;

    public Task(String title, LocalDateTime dueDate, String description){
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
