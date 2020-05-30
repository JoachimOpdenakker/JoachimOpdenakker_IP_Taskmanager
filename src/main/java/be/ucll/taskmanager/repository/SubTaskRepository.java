package be.ucll.taskmanager.repository;

import be.ucll.taskmanager.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubTaskRepository extends JpaRepository<SubTask, UUID> {}
