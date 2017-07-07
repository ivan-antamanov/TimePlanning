package timeplaner.core;


import timeplaner.core.entities.DocumentModel;

public interface Skeleton<T extends Skeleton, V extends DocumentModel> {

    public T newSkeleton(V documentModel);

    public T updateSkeleton(V documentModel);

    public V getDocument();

}
