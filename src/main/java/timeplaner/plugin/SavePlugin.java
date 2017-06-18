package timeplaner.plugin;


import timeplaner.dao.AbstractLocalSession;
import timeplaner.entities.AbstractDocument;

public abstract class SavePlugin implements Plugin {

    private AbstractLocalSession session;

    public abstract void createDocument(AbstractDocument document);

    public abstract void readDocument(Long docId);

    public abstract void updateDocument(AbstractDocument document);

    public abstract void deleteDocument(Long docId);

}
