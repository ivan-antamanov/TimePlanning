package timeplaner.dao.impl;


import timeplaner.dao.AbstractLocalSession;
import timeplaner.dao.ProjectDao;
import timeplaner.entities.AbstractDocument;
import timeplaner.entities.maindocuments.impl.Project;

public class ProjectDaoImpl extends AbstractLocalSession implements ProjectDao {



    @Override
    public void createProject(Project project) throws Exception {
        saveDocument(project);
    }

    @Override
    public Project readProject(Project project) throws Exception {
        return (Project) loadDocument(project);
    }

    @Override
    public void updateProject(Project project) throws Exception {
        saveDocument(project);
    }

    @Override
    public void deleteProject(Project project) throws Exception {

    }

    @Override
    public void getAllPlans() throws Exception {

    }
}
