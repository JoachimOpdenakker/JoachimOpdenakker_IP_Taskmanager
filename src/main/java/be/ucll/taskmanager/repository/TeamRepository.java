package be.ucll.taskmanager.repository;

import be.ucll.taskmanager.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
}
