package timeplaner.bo;

import timeplaner.entities.DocumentModel;

public interface Controller {

    DocumentModel getDocumentById();
    void saveDocument(DocumentModel documentModel);
    void deleteDocument();
    void updateDocument();
    void getAllDocuments();

}
