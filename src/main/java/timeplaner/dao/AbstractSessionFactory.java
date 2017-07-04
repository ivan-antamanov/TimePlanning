package timeplaner.dao;


import timeplaner.entities.DocumentModel;

public abstract class AbstractSessionFactory<T extends DocumentModel> implements DocumentDao<T> {

    protected SessionFactory sessionFactory;

    public AbstractSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
