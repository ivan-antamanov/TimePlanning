package timeplaner.dao.impl;


import timeplaner.dao.AbstractSessionFactory;
import timeplaner.dao.SessionFactory;
import timeplaner.entities.PersonDocument;

import java.util.List;

public class PersonDaoImpl extends AbstractSessionFactory<PersonDocument>{

    public PersonDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public PersonDocument create(PersonDocument document) {
        return null;
    }

    @Override
    public PersonDocument read(PersonDocument document) {
        return null;
    }

    @Override
    public PersonDocument update(PersonDocument document) {
        return null;
    }

    @Override
    public PersonDocument delete(PersonDocument document) {
        return null;
    }

    @Override
    public List<PersonDocument> findAll() {
        return null;
    }
}
