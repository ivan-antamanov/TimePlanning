package timeplaner.plugin;


import timeplaner.dao.LocalSessionFactoryImpl;
import timeplaner.entities.StubDocument;

public abstract class SavePlugin implements Plugin {

    private LocalSessionFactoryImpl session;

    public abstract void createDocument(StubDocument document);

    public abstract void readDocument(Long docId);

    public abstract void updateDocument(StubDocument document);

    public abstract void deleteDocument(Long docId);

}
