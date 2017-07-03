package timeplaner.gui.docs.skeletons;


import timeplaner.entities.DocumentModel;

public interface Skeleton {

    public Skeleton newSkeleton(DocumentModel DocumentModel);

    public Skeleton updateSkeleton(DocumentModel documentModel);

    public DocumentModel getDocument();

}
