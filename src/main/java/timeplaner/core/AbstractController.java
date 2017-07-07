package timeplaner.core;


import timeplaner.plugin.dao.DocumentDao;
import timeplaner.core.entities.DocumentModel;

public abstract class AbstractController<T extends DocumentDao, V extends DocumentModel> implements Controller<V> {

    protected T dao;

}
