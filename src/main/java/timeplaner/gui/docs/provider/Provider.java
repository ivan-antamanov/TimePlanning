package timeplaner.gui.docs.provider;


import javafx.scene.Parent;
import timeplaner.entities.DocumentModel;

public interface Provider {

//    public void registrationEvents();

//    public void createDocument(DocumentModel document) throws Exception;
//
//    public DocumentModel readDocument(DocumentModel document) throws Exception;
//
//    public DocumentModel updateDocument(DocumentModel document) throws Exception;
//
//    public void deleteDocument(DocumentModel document) throws Exception;
//
//    public List<DocumentModel> getAllDocuments() throws Exception;

    public Parent newNode();

    public Parent updateNode(DocumentModel documentModel);

    public Parent getNode();


}
