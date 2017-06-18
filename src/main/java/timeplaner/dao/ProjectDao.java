package timeplaner.dao;


import timeplaner.entities.maindocuments.impl.Project;

public interface ProjectDao {

    public void createProject(Project project) throws Exception;

    public Project readProject(Project project) throws Exception;

    public void updateProject(Project project) throws Exception;

    public void deleteProject(Project project) throws Exception;

    public void getAllPlans() throws Exception;
}
