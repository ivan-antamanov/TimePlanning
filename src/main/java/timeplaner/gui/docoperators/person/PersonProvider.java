package timeplaner.gui.docoperators.person;

import timeplaner.plugin.dao.SessionFactory;
import timeplaner.core.entities.PersonDocument;
import timeplaner.core.AbstractProvider;


public class PersonProvider extends AbstractProvider<PersonController, PersonParent, PersonDocument> {

    public PersonProvider(SessionFactory sessionFactory){
        parent = new PersonParent(new PersonSkeleton());
        controller = new PersonController(sessionFactory);
    }

    @Override
    protected void registrationEvents() {

    }

    @Override
    protected void showSuccessDialog() {

    }

    @Override
    public PersonParent newNode() {
        return null;
    }

    @Override
    public PersonParent updateNode(PersonDocument documentModel) {
        return null;
    }

    @Override
    public PersonParent getNode() { //todo in abstract class
        return parent.getDocParent();
    }
}
