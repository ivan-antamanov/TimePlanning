package timeplaner.bo.impl;


import timeplaner.bo.AbstractController;
import timeplaner.dao.SessionFactory;
import timeplaner.dao.impl.TaskDaoImpl;
import timeplaner.entities.subdocuments.impl.Task;

import java.util.List;


public class TaskController extends AbstractController<TaskDaoImpl, Task> {

    public TaskController(SessionFactory sessionFactory) {
        dao = new TaskDaoImpl(sessionFactory);
    }

    @Override
    public Task getDocument(Task document) {
        return null;
    }

    @Override
    public Task createDocument(Task document) {
        return null;
    }

    @Override
    public void deleteDocument(Task document) {

    }

    @Override
    public void updateDocument(Task document) {

    }

    @Override
    public List<Task> allDocuments() {
        return null;
    }

}
