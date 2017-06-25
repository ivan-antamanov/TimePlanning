package timeplaner.gui.docs.skeletons;


import timeplaner.entities.AbstractDocument;
import timeplaner.entities.Document;

public interface Skeleton {

    public Skeleton newSkeleton(AbstractDocument abstractDocument);

    public Skeleton updateSkeleton(AbstractDocument abstractDocument);

//    public Document getDocument();

}
