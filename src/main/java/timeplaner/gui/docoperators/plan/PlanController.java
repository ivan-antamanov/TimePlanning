package timeplaner.gui.docoperators.plan;


import timeplaner.core.AbstractController;
import timeplaner.core.entities.maindocuments.impl.PlanDocument;
import timeplaner.plugin.dao.SessionFactory;
import timeplaner.plugin.dao.impl.PlanDaoImpl;

import java.util.List;


public class PlanController extends AbstractController<PlanDaoImpl, PlanDocument> {


    public PlanController(SessionFactory sessionFactory) {
        this.dao = new PlanDaoImpl(sessionFactory);
    }

    @Override
    public PlanDocument getDocument(PlanDocument document) {
        return null;
    }

    @Override
    public PlanDocument createDocument(PlanDocument document) {
        return null;
    }

    @Override
    public void deleteDocument(PlanDocument document) {

    }

    @Override
    public void updateDocument(PlanDocument document) {

    }

    @Override
    public List<PlanDocument> allDocuments() {
        return null;
    }
}
