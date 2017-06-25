package timeplaner.gui.docs.provider;


import javafx.scene.Parent;
import timeplaner.entities.Document;
import timeplaner.entities.subdocuments.impl.Task;

import java.util.List;

public interface Provider {

//    public void registrationEvents();

//    public void createDocument(Document document) throws Exception;
//
//    public Document readDocument(Document document) throws Exception;
//
//    public Document updateDocument(Document document) throws Exception;
//
//    public void deleteDocument(Document document) throws Exception;
//
//    public List<Document> getAllDocuments() throws Exception;

    public Parent newNode();

    public Parent updateNode(Document document);

    public Parent getNode();


}
