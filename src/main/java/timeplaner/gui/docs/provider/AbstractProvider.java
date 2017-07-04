package timeplaner.gui.docs.provider;


import timeplaner.bo.Controller;
import timeplaner.entities.DocumentModel;
import timeplaner.gui.docs.parents.AbstractDocParent;

public abstract class AbstractProvider<C extends Controller<M>, P extends AbstractDocParent, M extends DocumentModel> implements Provider<P, M> {

    protected C controller;
    protected P parent;

//    public AbstractProvider() {
//        registrationEvents();
//    }

    protected abstract void registrationEvents();

    protected abstract void showSuccessDialog(); //todo put to Utils
}
