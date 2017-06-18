package timeplaner.gui.docs.carcases;


import timeplaner.entities.AbstractDocument;
import timeplaner.entities.Document;
import timeplaner.gui.docs.carcases.impl.AbstractSkeleton;

public interface Skeleton {

    public AbstractSkeleton newSkeleton(AbstractDocument abstractDocument);

    public AbstractSkeleton updateSkeleton(AbstractDocument abstractDocument);

    public AbstractDocument getDocument();

}
