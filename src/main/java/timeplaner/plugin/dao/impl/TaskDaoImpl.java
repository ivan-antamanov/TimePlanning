package timeplaner.plugin.dao.impl;


import timeplaner.plugin.dao.AbstractSessionFactory;
import timeplaner.plugin.dao.SessionFactory;
import timeplaner.core.entities.subdocuments.impl.TaskDocument;

import java.util.List;

public class TaskDaoImpl extends AbstractSessionFactory<TaskDocument> {

    public TaskDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public TaskDocument create(TaskDocument document) {
        return null;
    }

    @Override
    public TaskDocument read(TaskDocument document) {
        return null;
    }

    @Override
    public TaskDocument update(TaskDocument document) {
        return null;
    }

    @Override
    public TaskDocument delete(TaskDocument document) {
        return null;
    }

    @Override
    public List<TaskDocument> findAll() {
        return null;
    }
}
