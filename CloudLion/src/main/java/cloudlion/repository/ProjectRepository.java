package cloudlion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloudlion.database.Project;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findOneByProjectName(String projectName);
}
