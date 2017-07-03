package timeplaner.bo;


import timeplaner.dao.SessionFactory;
import timeplaner.dao.impl.PlanDaoImpl;


public class PlanController {

    private PlanDaoImpl dao;

    public PlanController(SessionFactory sessionFactory) {
        this.dao = new PlanDaoImpl(sessionFactory);
    }

}
