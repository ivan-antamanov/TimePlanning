package timeplaner.dao.impl;


import timeplaner.dao.AbstractLocalSession;
import timeplaner.entities.Document;

public class TaskDaoImpl extends AbstractLocalSession {

    @Override
    protected String getTargetDirectory(Document document) {
        return null;
    }
}
