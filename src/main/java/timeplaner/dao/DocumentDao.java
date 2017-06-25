package timeplaner.dao;


import timeplaner.entities.Document;

import java.util.List;

public interface DocumentDao {
    public void createDocument(Document document) throws Exception;

    public Document readDocument(Document document) throws Exception;

    public Document updateDocument(Document document) throws Exception;

    public void deleteDocument(Document document) throws Exception;

    public List<Document> getAllDocuments() throws Exception;
}
