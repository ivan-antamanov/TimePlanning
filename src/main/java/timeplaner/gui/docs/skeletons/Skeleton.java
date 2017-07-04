package timeplaner.gui.docs.skeletons;


import timeplaner.entities.DocumentModel;

public interface Skeleton<T extends Skeleton, V extends DocumentModel> {

    public T newSkeleton(V documentModel);

    public T updateSkeleton(V documentModel);

    public V getDocument();

}
