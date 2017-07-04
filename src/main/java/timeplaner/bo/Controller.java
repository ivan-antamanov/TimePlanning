package timeplaner.bo;

import timeplaner.dao.DocumentDao;
import timeplaner.entities.DocumentModel;

import java.util.List;

public interface Controller<V extends DocumentModel> {

    V getDocument(V document);
    V createDocument(V document);
    void deleteDocument(V document);
    void updateDocument(V document);
    List<V> allDocuments();

}
