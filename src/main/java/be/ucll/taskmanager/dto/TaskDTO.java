package be.ucll.taskmanager.dto;

import java.time.LocalDateTime;

public class TaskDTO {

    private String title;
    private LocalDateTime dueDate;
    private String description;

    public String getTitle(){
        return title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public String getDescription(){
        return description;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setDueDate(LocalDateTime dueDate){
        this.dueDate = dueDate;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
