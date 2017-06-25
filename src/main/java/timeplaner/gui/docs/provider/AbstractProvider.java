package timeplaner.gui.docs.provider;


import timeplaner.dao.DocumentDao;

public abstract class AbstractProvider implements Provider {

    DocumentDao documentDao;

    public AbstractProvider() {
//        registrationEvents();
    }

    protected abstract void registrationEvents();

    protected abstract void showSuccessDialog(); //todo put to Utils
}
