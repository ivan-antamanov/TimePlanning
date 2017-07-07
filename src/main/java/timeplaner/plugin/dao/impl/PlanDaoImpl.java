package timeplaner.plugin.dao.impl;


import timeplaner.core.entities.maindocuments.impl.PlanDocument;
import timeplaner.plugin.dao.AbstractSessionFactory;
import timeplaner.plugin.dao.SessionFactory;

import java.util.List;

public class PlanDaoImpl extends AbstractSessionFactory<PlanDocument> {

    public PlanDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public PlanDocument create(PlanDocument document) {
        return null;
    }

    @Override
    public PlanDocument read(PlanDocument document) {
        return null;
    }

    @Override
    public PlanDocument update(PlanDocument document) {
        return null;
    }

    @Override
    public PlanDocument delete(PlanDocument document) {
        return null;
    }

    @Override
    public List<PlanDocument> findAll() {
        return null;
    }
}
