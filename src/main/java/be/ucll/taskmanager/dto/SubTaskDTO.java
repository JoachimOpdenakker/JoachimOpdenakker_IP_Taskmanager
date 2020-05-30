package be.ucll.taskmanager.dto;

import java.util.UUID;

public class SubTaskDTO {

    private UUID id;
    private String title;
    private String description;

    public SubTaskDTO(){

    }

    public SubTaskDTO(UUID id, String title, String description){
        setId(id);
        setTitle(title);
        setDescription(description);
    }

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
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
