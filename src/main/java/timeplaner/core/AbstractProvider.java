package timeplaner.core;


import timeplaner.core.entities.DocumentModel;

public abstract class AbstractProvider<C extends Controller<M>, P extends AbstractDocParent, M extends DocumentModel> implements Provider<P, M> {

    protected C controller;
    protected P parent;

//    public AbstractProvider() {
//        registrationEvents();
//    }

    protected abstract void registrationEvents();

    protected abstract void showSuccessDialog(); //todo put to Utils
}
