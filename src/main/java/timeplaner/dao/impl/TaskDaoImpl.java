package timeplaner.dao.impl;


import timeplaner.dao.DocumentDao;
import timeplaner.dao.ProjectSessionSetter;
import timeplaner.dao.SessionFactory;
import timeplaner.entities.subdocuments.impl.Task;

import java.util.List;

public class TaskDaoImpl extends ProjectSessionSetter implements DocumentDao<Task> {

    public TaskDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Task create(Task document) {
        return null;
    }

    @Override
    public Task read(Task document) {
        return null;
    }

    @Override
    public Task update(Task document) {
        return null;
    }

    @Override
    public Task delete(Task document) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        return null;
    }
}
