package timeplaner.dao;


import timeplaner.entities.AbstractDocument;
import timeplaner.entities.Document;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

public abstract class AbstractLocalSession implements DocumentDao {

    private ObjectOutputStream saveObjectStream;
    private ObjectInputStream loadObjectStream;
    private FileInputStream loadFileStream;
    private FileOutputStream saveFileStream;
    private final Path pathPrefix = Paths.get("src/main/resources/");

    protected abstract String getTargetDirectory(Document document);

    @Override
    public Document readDocument(Document document) throws ParseException, IOException, ClassNotFoundException {
        Path path = Paths.get(getTargetDirectory(document));
        if(!Files.exists(path)) {
            String fileName = path.toString() +".dat";   //todo Add logger
            loadFileStream = new FileInputStream(fileName);
            loadObjectStream = new ObjectInputStream(loadFileStream);
            AbstractDocument loadDocument = (AbstractDocument) loadObjectStream.readObject();
            loadObjectStream.close();
            return loadDocument;
        } else {
            throw new FileNotFoundException();
        }

    }

    @Override
    public void createDocument(Document document) throws IOException {
        Path path = Paths.get(getTargetDirectory(document)); //todo Add logger
        if(!Files.exists(path)) {
            Files.createDirectory(path);
        } else {
            throw new FileNotFoundException();
        }
        String fileName = path.toString() +".dat";
        saveFileStream = new FileOutputStream(fileName);
        saveObjectStream = new ObjectOutputStream(saveFileStream);
        saveObjectStream.writeObject(document);
        saveObjectStream.close();

    }

    @Override
    public void deleteDocument(Document document){
        throw new UnsupportedOperationException("Functionality Delete document not Implemented yet");
        //need todo implementation;
    }

    @Override
    public Document updateDocument(Document document){
        throw new UnsupportedOperationException("Functionality Update document not Implemented yet");
        //need todo implementation;
    }

    @Override
    public List<Document> getAllDocuments() throws Exception {
        throw new UnsupportedOperationException("Functionality getAllDocuments not Implemented yet");
        //need todo implementation;
    }


//    private String getTargetDirectory(AbstractDocument document) {
//        String fileName = pathPrefix.toString();
//
//        if (document.getType().isMainDocument()) {
//            fileName.concat("/" + document.getOwner().getPersonNames());
//        } else {
//           fileName.concat(document.getMainDocument().getType().getTypeName());
////           fileName.concat()
//
//        }
//        fileName.concat(document.getId().toString());
//
//        return fileName;
//    }


}