package timeplaner.gui.docs.skeletons;


import timeplaner.entities.Document;

public interface Skeleton {

    public Skeleton newSkeleton(Document Document);

    public Skeleton updateSkeleton(Document document);

    public Document getDocument();

}
