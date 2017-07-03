package timeplaner.dao;


import timeplaner.entities.DocumentModel;

import java.util.List;

public interface DocumentDao<T extends DocumentModel> {

    public T create(T document);

    public T read(T document);

    public T update(T document);

    public T delete(T document);

    public List<T> findAll();
}
