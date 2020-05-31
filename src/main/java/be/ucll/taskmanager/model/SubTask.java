package be.ucll.taskmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class SubTask {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private UUID superTaskID;
    public SubTask(){

    }

    public SubTask(String title, String description, UUID superTaskID){
        this.title = title;
        this.description = description;
        this.id = UUID.randomUUID();
        this.superTaskID = superTaskID;
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

    public UUID getSuperTaskID(){
        return superTaskID;
    }

    public void setSuperTaskID(UUID superTaskID){
        this.superTaskID = superTaskID;
    }

    @Override
    public String toString(){
        return "title: " + this.getTitle() + " description: " + this.getDescription();
    }
}
