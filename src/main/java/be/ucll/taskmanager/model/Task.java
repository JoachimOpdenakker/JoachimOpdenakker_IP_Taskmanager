package be.ucll.taskmanager.model;

import be.ucll.taskmanager.dto.SubTaskDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;
    private String description;
    private Boolean completed;

    @OneToMany
    private List<SubTask> subTaskList;

    public Task(){
        this.id = UUID.randomUUID();
        if (subTaskList == null){
            this.subTaskList = new ArrayList<>();
        }
    }

    public Task(String title, LocalDateTime dueDate, String description){
        setTitle(title);
        this.dueDate = dueDate;
        setDescription(description);
        this.id = UUID.randomUUID();
        this.completed = false;
        if (subTaskList == null){
            this.subTaskList = new ArrayList<>();
        }    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.trim().isEmpty()){
            throw new DomainException("Title can't be empty!");
        }
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
        if(description == null || description.trim().isEmpty()){
            throw new DomainException("Description can't be empty!");
        }
        this.description = description;
    }

    public Boolean getCompleted(){
        return completed;
    }

    public void setCompleted(){
        this.completed = true;
    }

    public void setSubTaskList(List<SubTask> subTaskList) {
        this.subTaskList = subTaskList;
    }

}
