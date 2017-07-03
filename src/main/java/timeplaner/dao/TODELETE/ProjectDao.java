package timeplaner.dao.TODELETE;


import timeplaner.entities.maindocuments.impl.Plan;

public interface ProjectDao {

    public void createProject(Plan plan) throws Exception;

    public Plan readProject(Plan plan) throws Exception;

    public void updateProject(Plan plan) throws Exception;

    public void deleteProject(Plan plan) throws Exception;

    public void getAllPlans() throws Exception;
}
