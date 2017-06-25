package timeplaner.bo;

import timeplaner.entities.Document;

public interface Controller {

    Document getDocumentById();
    void saveDocument(Document document);
    void deleteDocument();
    void updateDocument();
    void getAllDocuments();

}
