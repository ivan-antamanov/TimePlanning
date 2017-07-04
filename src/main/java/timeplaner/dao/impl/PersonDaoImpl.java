package timeplaner.dao.impl;


import timeplaner.dao.AbstractSessionFactory;
import timeplaner.dao.SessionFactory;
import timeplaner.entities.Person;

import java.util.List;

public class PersonDaoImpl extends AbstractSessionFactory<Person>{

    public PersonDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Person create(Person document) {
        return null;
    }

    @Override
    public Person read(Person document) {
        return null;
    }

    @Override
    public Person update(Person document) {
        return null;
    }

    @Override
    public Person delete(Person document) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }
}
