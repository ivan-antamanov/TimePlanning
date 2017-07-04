package timeplaner.bo.impl;


import timeplaner.bo.AbstractController;
import timeplaner.dao.SessionFactory;
import timeplaner.dao.impl.PlanDaoImpl;
import timeplaner.entities.maindocuments.impl.Plan;

import java.util.List;


public class PlanController extends AbstractController<PlanDaoImpl, Plan> {


    public PlanController(SessionFactory sessionFactory) {
        this.dao = new PlanDaoImpl(sessionFactory);
    }

    @Override
    public Plan getDocument(Plan document) {
        return null;
    }

    @Override
    public Plan createDocument(Plan document) {
        return null;
    }

    @Override
    public void deleteDocument(Plan document) {

    }

    @Override
    public void updateDocument(Plan document) {

    }

    @Override
    public List<Plan> allDocuments() {
        return null;
    }
}
