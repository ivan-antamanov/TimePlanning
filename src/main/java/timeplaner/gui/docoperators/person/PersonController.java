package timeplaner.gui.docoperators.person;

import timeplaner.core.AbstractController;
import timeplaner.plugin.dao.SessionFactory;
import timeplaner.plugin.dao.impl.PersonDaoImpl;
import timeplaner.core.entities.PersonDocument;

import java.util.List;


public class PersonController extends AbstractController<PersonDaoImpl, PersonDocument> {

    public PersonController(SessionFactory sessionFactory) {
        this.dao = new PersonDaoImpl(sessionFactory);
    }

    @Override
    public PersonDocument getDocument(PersonDocument document) {
        return null;
    }

    @Override
    public PersonDocument createDocument(PersonDocument document) {
        return null;
    }

    @Override
    public void deleteDocument(PersonDocument document) {

    }

    @Override
    public void updateDocument(PersonDocument document) {

    }

    @Override
    public List<PersonDocument> allDocuments() {
        return null;
    }
}
