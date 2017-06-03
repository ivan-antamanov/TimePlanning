package timeplaner.plugin;


import timeplaner.dao.AbstractSession;
import timeplaner.documents.AbstractDocument;

public abstract class SavePlugin implements Plugin {

    private AbstractSession session;

    public abstract void createDocument(AbstractDocument document);

    public abstract void readDocument(Long docId);

    public abstract void updateDocument(AbstractDocument document);

    public abstract void deleteDocument(Long docId);

}
