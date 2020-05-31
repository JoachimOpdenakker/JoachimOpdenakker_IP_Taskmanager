package be.ucll.taskmanager.model;

public class DomainException extends RuntimeException {

    public DomainException(String message, Exception e){
        super(message, e);
    }

    public DomainException(String message){
        super(message);
    }

    public DomainException(Exception e){
        super(e);
    }
}
