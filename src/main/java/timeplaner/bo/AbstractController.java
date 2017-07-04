package timeplaner.bo;


import timeplaner.dao.DocumentDao;
import timeplaner.entities.DocumentModel;

public abstract class AbstractController<T extends DocumentDao, V extends DocumentModel> implements Controller<V> {

    protected T dao;

}
