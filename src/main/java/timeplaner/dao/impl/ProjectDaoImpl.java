package timeplaner.dao.impl;


import timeplaner.dao.AbstractLocalSession;
import timeplaner.dao.ProjectDao;
import timeplaner.entities.AbstractDocument;
import timeplaner.entities.Document;
import timeplaner.entities.maindocuments.impl.Project;

import java.util.List;

public class ProjectDaoImpl extends AbstractLocalSession {

    @Override
    protected String getTargetDirectory(Document document) {
        return null;
    }
}
