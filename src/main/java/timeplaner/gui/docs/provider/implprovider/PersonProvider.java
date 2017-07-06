package timeplaner.gui.docs.provider.implprovider;

import timeplaner.bo.impl.PersonController;
import timeplaner.dao.SessionFactory;
import timeplaner.entities.PersonDocument;
import timeplaner.gui.docs.parents.impldoc.PersonParent;
import timeplaner.gui.docs.provider.AbstractProvider;
import timeplaner.gui.docs.skeletons.impl.PersonSkeleton;


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
