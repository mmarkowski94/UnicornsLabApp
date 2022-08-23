package pl.coderslab.projects;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}