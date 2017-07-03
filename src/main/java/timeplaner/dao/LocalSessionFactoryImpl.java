package timeplaner.dao;


import timeplaner.entities.StubDocument;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.logging.Logger;

public class LocalSessionFactoryImpl<T extends StubDocument> implements SessionFactory<T> {

    private ObjectOutputStream saveObjectStream;
    private ObjectInputStream loadObjectStream;
    private FileInputStream loadFileStream;
    private FileOutputStream saveFileStream;
    private final Path pathPrefix = Paths.get("src/main/resources/");

    Logger logger = Logger.getLogger(LocalSessionFactoryImpl.class.getName());
    String savePattern = "Try to save {0} with Id: {1}";
    String loadPattern = "Try to load {0} with Id: {1}";

    protected String getTargetDirectory(T documentModel){
        return pathPrefix.toString()+ documentModel.getType() +documentModel.getId() + ".dat";
    }

    private String getMessageFormat(String pattern ,String ... args){
        MessageFormat mf = new MessageFormat(pattern);
        return mf.format(args);
    }

    @Override
    public T readDocument(T documentModel) throws IOException, ClassNotFoundException {//todo Add logger
        logger.info(getMessageFormat(savePattern,
                documentModel.getType().getTypeName(), documentModel.getId().toString()));
        Path path = Paths.get(getTargetDirectory(documentModel));
        if (!Files.exists(path)) {
//            String fileName = path.toString() +documentModel.getId() + ".dat";
            loadFileStream = new FileInputStream(path.toFile());
            loadObjectStream = new ObjectInputStream(loadFileStream);
            T loadDocument = null;
            loadDocument = (T) loadObjectStream.readObject();
            loadObjectStream.close();
            return loadDocument;
        } else {
            throw new FileNotFoundException();
        }
    }

    @Override
    public T createDocument(T documentModel) throws IOException {
        logger.info(getMessageFormat(loadPattern,
                documentModel.getType().getTypeName(), documentModel.getId().toString()));
        Path path = Paths.get(getTargetDirectory(documentModel)); //todo Add logger
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        } else {
            throw new FileNotFoundException();
        }
//        String fileName = path.toString() +documentModel.getId() + ".dat";
        saveFileStream = new FileOutputStream(path.toFile());
        saveObjectStream = new ObjectOutputStream(saveFileStream);
        saveObjectStream.writeObject(documentModel);
        saveObjectStream.close();
        return documentModel;
    }

}