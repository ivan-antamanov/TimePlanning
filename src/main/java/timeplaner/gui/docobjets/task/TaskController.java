package timeplaner.gui.docobjets.task;


import timeplaner.core.AbstractController;
import timeplaner.core.entities.subdocuments.impl.TaskDocument;
import timeplaner.plugin.dao.SessionFactory;
import timeplaner.plugin.dao.impl.TaskDaoImpl;

import java.util.List;


public class TaskController extends AbstractController<TaskDaoImpl, TaskDocument> {

    public TaskController(SessionFactory sessionFactory) {
        dao = new TaskDaoImpl(sessionFactory);
    }

    @Override
    public TaskDocument getDocument(TaskDocument document) {
        return null;
    }

    @Override
    public TaskDocument createDocument(TaskDocument document) {
        return null;
    }

    @Override
    public void deleteDocument(TaskDocument document) {

    }

    @Override
    public void updateDocument(TaskDocument document) {

    }

    @Override
    public List<TaskDocument> allDocuments() {
        return null;
    }

}
