package ru.akkulov.service;

import lombok.Data;
import ru.akkulov.dao.ProjectDAO;
import ru.akkulov.model.Project;

import java.util.List;

@Data
public class ProjectService {
    private ProjectDAO projectDAO;

    public ProjectService() {
        projectDAO = new ProjectDAO();
    }

    public void create(Project project) {
        projectDAO.create(project);
    }

    public List<Project> getAll() {
        return projectDAO.readAll();
    }

    public Project getById(int id) {
        return projectDAO.getById(id);
    }

    public void updateOne(Project project, int id) {
        projectDAO.updateOne(project, id);
    }

    public void deleteOne(int id) {
        projectDAO.deleteOne(id);
    }
}
