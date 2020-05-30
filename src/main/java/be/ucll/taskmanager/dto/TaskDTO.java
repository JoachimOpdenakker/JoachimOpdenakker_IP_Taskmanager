package be.ucll.taskmanager.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskDTO {

    private UUID id;
    private String title;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;
    private String description;

    public TaskDTO(){

    }

    public TaskDTO(UUID id, String title, String description, LocalDateTime dueDate){
        setId(id);
        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
    }

    public String getTitle(){
        return title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
